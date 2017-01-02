package fr.pizzeria.service;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoApiRest;

public class ServiceApiRest implements Service{

	@Override
	public PizzaDao getPizzas() {
		return new PizzaDaoApiRest();
	}
	

}
