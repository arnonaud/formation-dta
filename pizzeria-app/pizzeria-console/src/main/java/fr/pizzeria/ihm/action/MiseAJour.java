package fr.pizzeria.ihm.action;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
public class MiseAJour extends Action {

	private IhmUtil ihmUtil;

	public MiseAJour(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void executerAction() throws StockageException {
		System.out.println("mise à jour d'une pizza");
		// Listing de toute les pizzas
		ListerPizzas listerPizza = new ListerPizzas(ihmUtil);
		listerPizza.executerAction();

		System.out.println("Veuillez choisir la pizza � modifier");
		System.out.println("99 pour abandonner");

		// Recherche de la pizza � modifier
		Scanner sc = this.ihmUtil.getScanner();
		String codePizza = sc.nextLine();
		if (!codePizza.equals("99")) {

			// récuperation de l'indice de la pizza � modifier
			List<Pizza> pizzas = this.ihmUtil.getPizzaDao().findAll();
			int indice = pizzas.indexOf(pizzas.stream().filter(p -> p.getCode().equals(codePizza)).findFirst().get());
	
			// Demande des saisies avec stockage des modifications
			System.out.println("Veuillez saisir le code");
			String code = sc.nextLine();
			System.out.println("Veuillez saisir le nom (sans espace)");
			String nom = sc.nextLine();
			System.out.println("Veuillez saisir le prix");
			double prix = Double.parseDouble(sc.nextLine());
			System.out.println("Veuillez saisir la cat�gorie (Viande, Poisson, Sans Viande)");
			String categorie = sc.nextLine();
			CategoriePizza cat;
			if (categorie.equals("Viande")) {
				cat = CategoriePizza.VIANDE;
			} else if (categorie.equals("Poisson")) {
				cat = CategoriePizza.POISSON;
			} else if (categorie.equals("Sans Viande")) {
				cat = CategoriePizza.SANS_VIANDE;
			} else
				throw new UpdatePizzaException();

			// instanciation d'une nouvelle pizza
			Pizza pizza = new Pizza(code, nom, prix, cat);

			this.ihmUtil.getPizzaDao().updatePizza(indice, pizza);
			System.out.println("Liste des pizzas modifi�e");

		}

	}

}