package fr.pizzeria.ihm.action;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
public class MiseAJour extends Action {

	@Autowired
	private Scanner sc;

	@Autowired
	private PizzaDao pizzaDao;
	
	@Autowired
	private ListerPizzas listerPizzas;
	
	public MiseAJour() {
		super();
	}

	@Override
	public void executerAction() throws PizzaException {
		System.out.println("mise à jour d'une pizza");
		// Listing de toute les pizzas
		listerPizzas.executerAction();

		System.out.println("Veuillez choisir la pizza à modifier");
		System.out.println("99 pour abandonner");

		// Recherche de la pizza à modifier
		String codePizza = sc.nextLine();
		if (!codePizza.equals("99")) {

			// récuperation de l'indice de la pizza à modifier
			List<Pizza> pizzas = this.pizzaDao.findAll();
			int indice = pizzas.stream().filter(p -> p.getCode().equals(codePizza)).findFirst().get().getId();
			
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
				throw new PizzaException();

			// instanciation d'une nouvelle pizza
			Pizza pizza = new Pizza(code, nom, prix, cat);

			this.pizzaDao.updatePizza(indice, pizza);
			System.out.println("Liste des pizzas modifi�e");

		}

	}

}