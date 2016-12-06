package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoTableau implements PizzaDao {

	private List<Pizza> pizzas;

	public PizzaDaoTableau() {
		ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
		pizzas.add(new Pizza("PEP", "Pépéroni", 12.50));
		pizzas.add(new Pizza("MAR", "Margherita", 14.00));
		pizzas.add(new Pizza("REI", "La Reine", 11.50));
		pizzas.add(new Pizza("FRO", "La 4 fromages", 11.50));
		pizzas.add(new Pizza("CAN", "La cannibale", 11.50));
		pizzas.add(new Pizza("SAV", "La savoyarde", 11.50));
		pizzas.add(new Pizza("ORI", "L'orientale", 11.50));
		pizzas.add(new Pizza("IND", "L'indienne", 11.50));

		this.pizzas = pizzas;
	}

	@Override
	public List<Pizza> findAll() {
		return pizzas;
	}

	@Override
	public void save(Pizza p) throws SavePizzaException {

		if (p.getCode().length() != 3) {
			throw new SavePizzaException();
		} else {

			this.pizzas.add(p);
		}

	}

	@Override
	public void updatePizza(int indice, Pizza pizza) throws UpdatePizzaException {

		if (indice > this.pizzas.size() - 1) {
			throw new UpdatePizzaException();
		} else {
			this.pizzas.set(indice, pizza);
		}
	}

	@Override
	public void deletePizza(int indice) throws DeletePizzaException {

		if (this.pizzas.size() <= indice) {
			throw new DeletePizzaException();
		} else {

			this.pizzas.remove(indice);

		}

	}

}
