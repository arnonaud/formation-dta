package fr.pizzeria.ihm.action;

import java.util.logging.Logger;

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

	private IhmUtil ihmUtil;

	public Supprimer(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void executerAction() {
		System.out.println("Mise à jour d'une pizza");
		// Listing de toute les pizzas
		ListerPizzas listerPizza = new ListerPizzas(ihmUtil);
		listerPizza.executerAction();

		System.out.println("Veuillez choisir la pizza à supprimer");
		System.out.println("99 pour abandonner");

		String codePizza = this.ihmUtil.getScanner().nextLine();
		if (!codePizza.equals("99")) {
			try {
				this.ihmUtil.getPizzaDao().deletePizza(codePizza);
				System.out.println("Pizza suprimée");
			} catch (PizzaException e) {
				Logger.getLogger(PizzaDaoJdbc.class.getName()).severe(e.getMessage());
				throw new PizzaException(e);			}
		}

	}

}
