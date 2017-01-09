package fr.pizzeria.ihm.action;


import java.sql.Date;
import java.util.Scanner;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoJdbc;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Performance;
import fr.pizzeria.model.Pizza;

@Controller
public class Ajouter extends Action {

	//private IhmUtil ihmUtil;

	@Autowired
	private Scanner scanner;
	@Autowired
	private PizzaDao pizzaDao;
	
	public Ajouter() {
		super();
	}

	@Override
	public void executerAction() throws PizzaException {
		// demande saisie
		System.out.println("Ajout d'une pizza");
		System.out.println("Veuillez saisir le code");
		String code = this.scanner.nextLine();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = this.scanner.nextLine();
		System.out.println("Veuillez saisir le prix");
		String prix = this.scanner.nextLine();
		System.out.println("Veuillez saisir la cat�gorie (Viande, Poisson, Sans Viande)");
		String categorie = this.scanner.nextLine();
		CategoriePizza cat;
		cat = CategoriePizza.valueOf(categorie.replaceAll(" ", "_").toUpperCase());
		// crée l'objet pizza à partir de la saisie
		Pizza p = new Pizza(code, nom, Double.parseDouble(prix), cat);
		try {
			this.pizzaDao.savePizza(p);
			
			this.pizzaDao.savePerformance(new Performance("test", new Date(111), 111));
			
		} catch (PizzaException e) {
			Logger.getLogger(PizzaDaoJdbc.class.getName()).severe(e.getMessage());
			throw new PizzaException(e);
		}

	}
	
	

}
