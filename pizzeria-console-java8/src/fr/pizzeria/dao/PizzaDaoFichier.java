package fr.pizzeria.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
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
				InputStream ips = new FileInputStream("data/" + f);
				InputStreamReader ipsr = new InputStreamReader(ips);
				BufferedReader br = new BufferedReader(ipsr);

				String ligne = br.readLine();
				String[] valeurs = ligne.split(";");

				CategoriePizza cat = null;
				cat = CategoriePizza.valueOf(valeurs[2].replaceAll(" ", "_").toUpperCase());
				pizzas.add(new Pizza(f.substring(0, f.length() - 4), valeurs[0], Double.parseDouble(valeurs[1]), cat));
				
				br.close();
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

			File f = new File("data/" + p.getCode() + ".txt");
			try {
				FileWriter fw = new FileWriter(f);
				fw.write(p.getNom() + ";" + p.getPrix() + ";" + p.getCategorie());
				fw.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}

	@Override
	public void updatePizza(int indice, Pizza pizza) throws UpdatePizzaException {

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
