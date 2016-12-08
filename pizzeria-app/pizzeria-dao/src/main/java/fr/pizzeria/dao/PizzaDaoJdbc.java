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


import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJdbc implements PizzaDao{

	private Connection connection;
	private Statement statement;
	private List<Pizza> pizzas;
	
	public PizzaDaoJdbc()  {
		try {
			
			connection();
			ResultSet resultats = statement.executeQuery("SELECT * FROM PIZZA");
			
			List<Pizza> pizzas = new ArrayList<Pizza>();
			while(resultats.next()){
				String code = resultats.getString("reference");
				String nom = resultats.getString("libelle");
				double prix = resultats.getDouble("prix");
				CategoriePizza cat = CategoriePizza.valueOf(resultats.getString("categorie").replaceAll(" ", "_").toUpperCase());
				pizzas.add(new Pizza(code,nom,prix,cat));
			}
			this.pizzas = pizzas;
			resultats.close();
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void connection() throws SQLException{
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String jdbcAdress = bundle.getString("jdbc.adress");
		String jdbcUser = bundle.getString("jdbc.user");
		String jdbcPwd = bundle.getString("jdbc.pwd");
		
		connection = DriverManager.getConnection(jdbcAdress,jdbcUser,jdbcPwd);
		statement = connection.createStatement();
	}
	
	public void closeConnection() throws SQLException{
		connection.close();
		statement.close();
	}
	
	@Override
	public List<Pizza> findAll() {
		
		return this.pizzas;
	}

	@Override
	public void save(Pizza p) throws SavePizzaException {
		
		if (p.getCode().length() != 3) {
			throw new SavePizzaException();
		} else {
			
			try {
				connection();
				String nom = p.getNom();
				String code = p.getCode();
				double prix = p.getPrix();
				CategoriePizza cat = p.getCategorie();
				
				
				PreparedStatement insertPizza = connection.prepareStatement("INSERT INTO Pizza(libelle,reference,prix,URLImage,categorie) VALUES (?,?,?,?,?)");
				insertPizza.setString(1, nom);
				insertPizza.setString(2, code);
				insertPizza.setDouble(3, prix);
				insertPizza.setString(4, "");
				insertPizza.setString(5, cat.toString());
				insertPizza.executeUpdate();
				insertPizza.close();
				closeConnection();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}

			this.pizzas.add(p);
		}
	}

	@Override
	public void updatePizza(int indice, Pizza pizza) throws UpdatePizzaException {
		if (indice > this.pizzas.size() - 1) {
			throw new UpdatePizzaException();
		} else {
			
			String previousCode = this.pizzas.get(indice).getCode();
			this.pizzas.set(indice, pizza);
			

			try {
				connection();
				String nom = pizza.getNom();
				String code = pizza.getCode();
				double prix = pizza.getPrix();
				CategoriePizza cat = pizza.getCategorie();
				
				
				PreparedStatement updatePizza = connection.prepareStatement("UPDATE Pizza SET libelle=?,reference=?,prix=?,categorie=? WHERE reference=?");
				updatePizza.setString(1, nom);
				updatePizza.setString(2, code);
				updatePizza.setDouble(3, prix);
				updatePizza.setString(4, cat.toString());
				updatePizza.setString(5, previousCode);
				updatePizza.executeUpdate();
				updatePizza.close();
				closeConnection();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
		}
		
	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException {
		int indice = pizzas.indexOf(pizzas.stream().filter(p -> p.getCode().equals(codePizza)).findFirst().get());
		if (this.pizzas.size() <= indice) {
			throw new DeletePizzaException();
		} else {

			this.pizzas.remove(indice);
			try {
				connection();
				
				PreparedStatement deletePizza = connection.prepareStatement("DELETE FROM Pizza WHERE reference=?");
				deletePizza.setString(1,codePizza);
				deletePizza.executeUpdate();
				deletePizza.close();
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			

		}
		
	}

}
