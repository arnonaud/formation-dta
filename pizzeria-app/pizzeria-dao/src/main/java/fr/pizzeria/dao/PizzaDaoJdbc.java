package fr.pizzeria.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import org.apache.commons.collections4.ListUtils;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJdbc implements PizzaDao {

	private ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
	private String jdbcAdress = bundle.getString("jdbc.adress");
	private String jdbcUser = bundle.getString("jdbc.user");
	private String jdbcPwd = bundle.getString("jdbc.pwd");

	@Override
	public List<Pizza> findAll() {
		List<Pizza> pizzas = new ArrayList<Pizza>();
		try (Connection connection = DriverManager.getConnection(jdbcAdress, jdbcUser, jdbcPwd);
				Statement statement = connection.createStatement()) {

			ResultSet resultats = statement.executeQuery("SELECT * FROM PIZZA");

			while (resultats.next()) {
				String code = resultats.getString("reference");
				String nom = resultats.getString("libelle");
				double prix = resultats.getDouble("prix");
				CategoriePizza cat = CategoriePizza
						.valueOf(resultats.getString("categorie").replaceAll(" ", "_").toUpperCase());
				pizzas.add(new Pizza(code, nom, prix, cat));
			}

			resultats.close();
		} catch (SQLException e) {
			Logger.getLogger(PizzaDaoJdbc.class.getName()).severe(e.getMessage());
			throw new PizzaException(e);
		}
		return pizzas;
	}

	@Override
	public void save(Pizza p) throws PizzaException {

		if (p.getCode().length() != 3) {
			throw new PizzaException();
		} else {

			try (Connection connection = DriverManager.getConnection(jdbcAdress, jdbcUser, jdbcPwd);) {

				String nom = p.getNom();
				String code = p.getCode();
				double prix = p.getPrix();
				CategoriePizza cat = p.getCategorie();

				PreparedStatement insertPizza = connection.prepareStatement(
						"INSERT INTO Pizza(libelle,reference,prix,URLImage,categorie) VALUES (?,?,?,?,?)");
				insertPizza.setString(1, nom);
				insertPizza.setString(2, code);
				insertPizza.setDouble(3, prix);
				insertPizza.setString(4, "");
				insertPizza.setString(5, cat.toString());
				insertPizza.executeUpdate();
				insertPizza.close();

			} catch (SQLException e) {
				Logger.getLogger(PizzaDaoJdbc.class.getName()).severe(e.getMessage());
				throw new PizzaException(e);
			}

		}
	}

	@Override
	public void updatePizza(int indice, Pizza pizza) throws PizzaException {
		if (indice > findAll().size() - 1) {
			throw new PizzaException();
		} else {

			try (Connection connection = DriverManager.getConnection(jdbcAdress, jdbcUser, jdbcPwd);) {
				String previousCode = findAll().get(indice).getCode();
				String nom = pizza.getNom();
				String code = pizza.getCode();
				double prix = pizza.getPrix();
				CategoriePizza cat = pizza.getCategorie();

				PreparedStatement updatePizza = connection.prepareStatement(
						"UPDATE Pizza SET libelle=?,reference=?,prix=?,categorie=? WHERE reference=?");
				updatePizza.setString(1, nom);
				updatePizza.setString(2, code);
				updatePizza.setDouble(3, prix);
				updatePizza.setString(4, cat.toString());
				updatePizza.setString(5, previousCode);
				updatePizza.executeUpdate();
				updatePizza.close();

			} catch (SQLException e) {
				Logger.getLogger(PizzaDaoJdbc.class.getName()).severe(e.getMessage());
				throw new PizzaException(e);
			}

		}

	}

	@Override
	public void deletePizza(String codePizza) throws PizzaException {
		List<Pizza> pizzas = findAll();
		int indice = pizzas.indexOf(pizzas.stream().filter(p -> p.getCode().equals(codePizza)).findFirst().get());
		if (pizzas.size() <= indice) {
			throw new PizzaException();
		} else {

			findAll().remove(indice);
			try (Connection connection = DriverManager.getConnection(jdbcAdress, jdbcUser, jdbcPwd);) {

				PreparedStatement deletePizza = connection.prepareStatement("DELETE FROM Pizza WHERE reference=?");
				deletePizza.setString(1, codePizza);
				deletePizza.executeUpdate();
				deletePizza.close();
			} catch (SQLException e) {
				Logger.getLogger(PizzaDaoJdbc.class.getName()).severe(e.getMessage());
				throw new PizzaException(e);
			}

		}

	}

	@Override
	public void importJdbc() throws PizzaException {

		PizzaDaoFichier pizzaDaoFichier = new PizzaDaoFichier();
		List<Pizza> pizzas = pizzaDaoFichier.findAll();
		try (Connection connection = DriverManager.getConnection(jdbcAdress, jdbcUser, jdbcPwd);) {
			List<List<Pizza>> listPizzas = ListUtils.partition(pizzas, 3);

			listPizzas.stream().forEach(l -> {
				try {
					connection.setAutoCommit(false);

					for (int i = 0; i < l.size(); i++) {
						PreparedStatement insertPizza = connection.prepareStatement(
								"INSERT INTO Pizza(libelle,reference,prix,URLImage,categorie) VALUES (?,?,?,?,?)");
						insertPizza.setString(1, l.get(i).getNom());
						insertPizza.setString(2, l.get(i).getCode());
						insertPizza.setDouble(3, l.get(i).getPrix());
						insertPizza.setString(4, "");
						insertPizza.setString(5, l.get(i).getCategorie().toString());
						insertPizza.executeUpdate();
					}

					connection.commit();
				} catch (SQLException e) {
					try {
						connection.rollback();
					} catch (SQLException e1) {
						Logger.getLogger(PizzaDaoJdbc.class.getName()).severe(e.getMessage());
						throw new PizzaException(e);
					}
					Logger.getLogger(PizzaDaoJdbc.class.getName()).severe(e.getMessage());
					throw new PizzaException(e);
				}
			});
		} catch (SQLException e) {
			Logger.getLogger(PizzaDaoJdbc.class.getName()).severe(e.getMessage());
			throw new PizzaException(e);
		}

	}

}
