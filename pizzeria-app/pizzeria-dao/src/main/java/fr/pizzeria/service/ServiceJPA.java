package fr.pizzeria.service;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoJPA;
public class ServiceJPA implements Service{

	@Override
	public PizzaDao getPizzas() {
		return new PizzaDaoJPA();
	}

}
