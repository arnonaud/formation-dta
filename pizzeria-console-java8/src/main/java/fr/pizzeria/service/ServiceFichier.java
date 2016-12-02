package fr.pizzeria.service;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoFichier;

public class ServiceFichier implements Service {

	@Override
	public PizzaDao getPizzas() {

		return new PizzaDaoFichier();
	}

}
