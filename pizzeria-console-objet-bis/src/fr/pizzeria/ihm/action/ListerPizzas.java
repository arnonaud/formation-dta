package fr.pizzeria.ihm.action;

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
		System.out.println("Liste des pizzas");
		for (Pizza p : this.ihmUtil.getPizzaDao().findAll()) {
			System.out.println(p.getCode() + " -> " + p.getNom() + " (" + p.getPrix() + "€)");
		}

	}

}
