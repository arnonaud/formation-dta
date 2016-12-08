package fr.pizzeria.service;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoJdbc;

public class ServiceJdbc implements Service{

	@Override
	public PizzaDao getPizzas() {
	
		return new PizzaDaoJdbc();
	}
	

}
