package fr.pizzeria.service;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoTableau;

public class ServiceTableau implements Service {

	@Override
	public PizzaDao getPizzas() {
		return new PizzaDaoTableau();
	}

}
