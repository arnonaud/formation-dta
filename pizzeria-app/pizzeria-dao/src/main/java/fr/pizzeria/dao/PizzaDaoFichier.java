package fr.pizzeria.dao;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoFichier implements PizzaDao {

	private List<Pizza> pizzas;

	public PizzaDaoFichier() {
		List<Pizza> pizzas = new ArrayList<Pizza>();

		String[] listefichiers;
		File repertoire = new File("data");
		listefichiers = repertoire.list();
		List<String> fichiers = Arrays.asList(listefichiers);

		fichiers.stream().forEach(f -> {
			try {
				List<String> ligne = Files.readAllLines(Paths.get("data/" + f));
				String[] valeurs = ligne.get(0).split(";");
				CategoriePizza cat = CategoriePizza.valueOf(valeurs[2].replaceAll(" ", "_").toUpperCase());
				pizzas.add(new Pizza(f.substring(0, f.length() - 4), valeurs[0], Double.parseDouble(valeurs[1]), cat));

			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		this.pizzas = pizzas;

	}

	@Override
	public List<Pizza> findAll() {
		return pizzas;
	}

	@Override
	public void save(Pizza p) throws SavePizzaException {
		if (p.getCode().length() != 3) {
			throw new SavePizzaException();
		} else {

			this.pizzas.add(p);

			
			try {
				List<String> ligne = new ArrayList<String>();
				ligne.add(p.getNom() + ";" + p.getPrix() + ";" + p.getCategorie());
				Files.write(Paths.get("data/" + p.getCode() + ".txt"),ligne);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}

	@Override
	public void updatePizza(int indice, Pizza pizza) throws UpdatePizzaException {
		//TODO correction file save doesn't work
		if (indice > this.pizzas.size() - 1) {
			throw new UpdatePizzaException();
		} else {
			this.pizzas.set(indice, pizza);
			File f = new File("data/" + pizza.getCode() + ".txt");
			try {
				FileWriter fw = new FileWriter(f);
				fw.write(pizza.getNom() + ";" + pizza.getPrix() + ";" + pizza.getCategorie());
				fw.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException {
		if (codePizza == null) {
			throw new DeletePizzaException();
		} else {
			int indice = pizzas.indexOf(pizzas.stream().filter(p -> p.getCode().equals(codePizza)).findFirst().get());
			if (this.pizzas.size() <= indice) {
				throw new DeletePizzaException();
			} else {

				this.pizzas.remove(indice);
				File f = new File("data\\" + codePizza + ".txt");
				f.delete();
			}

		}

	}

}
