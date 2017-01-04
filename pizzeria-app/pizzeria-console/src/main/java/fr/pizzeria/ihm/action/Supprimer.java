package fr.pizzeria.ihm.action;

import java.util.Scanner;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoJdbc;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.ihm.IhmUtil;


/**
 * Classe heritant de Action permettant la suppression d'une pizza
 * 
 * @see Action
 * @author Arnaud
 *
 */
public class Supprimer extends Action {

	@Autowired
	private Scanner scanner;
	@Autowired
	private PizzaDao pizzaDao;
	@Autowired
	private ListerPizzas listerPizzas;
	public Supprimer() {
		super();
	}

	@Override
	public void executerAction() {
		System.out.println("Mise à jour d'une pizza");
		// Listing de toute les pizzas
		listerPizzas.executerAction();

		System.out.println("Veuillez choisir la pizza à supprimer");
		System.out.println("99 pour abandonner");

		String codePizza = this.scanner.nextLine();
		if (!codePizza.equals("99")) {
			try {
				this.pizzaDao.deletePizza(codePizza);
				System.out.println("Pizza suprimée");
			} catch (PizzaException e) {
				Logger.getLogger(PizzaDaoJdbc.class.getName()).severe(e.getMessage());
				throw new PizzaException(e);			}
		}

	}

}
