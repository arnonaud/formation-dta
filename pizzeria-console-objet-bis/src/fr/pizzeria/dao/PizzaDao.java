package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public interface PizzaDao {
	
	Pizza[] findAll();
	void save(Pizza p);
	void updatePizza(int indice, Pizza pizza);
	void deletePizza(int indice);
} 
