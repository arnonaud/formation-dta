package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public interface PizzaDao {

	List<Pizza> findAll();

	void save(Pizza p) throws SavePizzaException;

	void updatePizza(int indice, Pizza pizza) throws UpdatePizzaException;

	void deletePizza(int indice) throws DeletePizzaException;
}
