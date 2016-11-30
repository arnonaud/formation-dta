package fr.pizzeria.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoFichier implements PizzaDao{

	private List<Pizza> pizzas;
	
	public PizzaDaoFichier(){
		List<Pizza> pizzas = new ArrayList<Pizza>();
		
		String [] listefichiers; 
		File repertoire = new File("data");
		int i; 
		listefichiers = repertoire.list(); 
		
		
		
		for(i=0;i<listefichiers.length;i++){ 
			try {
				InputStream ips=new FileInputStream("data/"+listefichiers[i]); 
				InputStreamReader ipsr=new InputStreamReader(ips);
				BufferedReader br=new BufferedReader(ipsr);
			
				String ligne=br.readLine();
				String[] valeurs = ligne.split(";");
				
				CategoriePizza cat = null;
				if (valeurs[2].equals("Viande")) {
					cat = CategoriePizza.VIANDE;
				} else if (valeurs[2].equals("Poisson")) {
					cat = CategoriePizza.POISSON;
				} else if (valeurs[2].equals("Sans Viande")) {
					cat = CategoriePizza.SANS_VIANDE;
				}
				
				pizzas.add(new Pizza(listefichiers[i].substring(0, listefichiers[i].length()-4),valeurs[0],Double.parseDouble(valeurs[1]),cat));
				br.close(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
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

		
			File f = new File("data\\"+codePizza+".txt"); 
			f.delete(); 
		}
		
	}

}
