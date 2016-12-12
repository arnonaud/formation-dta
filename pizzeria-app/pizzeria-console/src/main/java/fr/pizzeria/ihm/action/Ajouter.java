package fr.pizzeria.ihm.action;


import java.util.logging.Logger;

import fr.pizzeria.dao.PizzaDaoJdbc;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
public class Ajouter extends Action {

	private IhmUtil ihmUtil;

	public Ajouter(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void executerAction() throws PizzaException {
		// demande saisie
		System.out.println("Ajout d'une pizza");
		System.out.println("Veuillez saisir le code");
		String code = this.ihmUtil.getScanner().nextLine();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = this.ihmUtil.getScanner().nextLine();
		System.out.println("Veuillez saisir le prix");
		String prix = this.ihmUtil.getScanner().nextLine();
		System.out.println("Veuillez saisir la cat�gorie (Viande, Poisson, Sans Viande)");
		String categorie = this.ihmUtil.getScanner().nextLine();
		CategoriePizza cat;
		cat = CategoriePizza.valueOf(categorie.replaceAll(" ", "_").toUpperCase());
		// crée l'objet pizza à partir de la saisie
		Pizza p = new Pizza(code, nom, Double.parseDouble(prix), cat);
		try {
			this.ihmUtil.getPizzaDao().savePizza(p);
		} catch (PizzaException e) {
			Logger.getLogger(PizzaDaoJdbc.class.getName()).severe(e.getMessage());
			throw new PizzaException(e);
		}

	}

}
