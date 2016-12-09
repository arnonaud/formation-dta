package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.Pizza;

public interface PizzaDao {

	List<Pizza> findAll();

	void save(Pizza p) throws PizzaException;

	void updatePizza(int indice, Pizza pizza) throws PizzaException;

	void deletePizza(String codePizza) throws PizzaException;
	
	default void importJdbc() throws PizzaException{
		throw new PizzaException("Not Yet Implement");
	};
}
