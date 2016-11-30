package fr.pizzeria.ihm.action;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
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
	public void executerAction() throws SavePizzaException {
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
		if (categorie.equals("Viande")) {
			cat = CategoriePizza.VIANDE;
		} else if (categorie.equals("Poisson")) {
			cat = CategoriePizza.POISSON;
		} else if (categorie.equals("Sans Viande")) {
			cat = CategoriePizza.SANS_VIANDE;
		} else
			throw new SavePizzaException();

		// cr�e l'objet pizza � partir de la saisie
		Pizza p = new Pizza(code, nom, Double.parseDouble(prix), cat);
		try {
			this.ihmUtil.getPizzaDao().save(p);
		} catch (StockageException e) {
			e.getMsg();
		}

	}

}
