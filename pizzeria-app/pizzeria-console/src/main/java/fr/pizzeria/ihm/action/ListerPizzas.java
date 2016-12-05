package fr.pizzeria.ihm.action;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;



public class ListerPizzas extends Action {

	private IhmUtil ihmUtil;

	public ListerPizzas(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void executerAction() {
		System.out.println("Liste des pizzas par cat�gorie");

		// r�cup�ration de toutes les pizzas
		List<Pizza> pizzas = this.ihmUtil.getPizzaDao().findAll();

		// affichage des pizzas par cat�gorie

		Comparator<Pizza> comparatorCategorie = Comparator.comparing(Pizza::getCategorie);
		List<Pizza> list = pizzas.stream().sorted(comparatorCategorie).collect(Collectors.toList());
		list.stream().forEach(p -> p.afficherPizza());

		// affichage de la pizza la plus cher
		System.out.println("Pizza la plus chere");
		Comparator<Pizza> comparator = Comparator.comparing(Pizza::getPrix);
		pizzas.stream().max(comparator).get().afficherPizza();

	}

}