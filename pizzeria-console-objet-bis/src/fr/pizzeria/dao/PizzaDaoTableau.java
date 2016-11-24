package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaDaoTableau implements PizzaDao{

	private Pizza[] pizzas = {};
	
	
	public PizzaDaoTableau() {
		Pizza pizzas[] =  {
				new Pizza(0, "PEP", "Pépéroni", 12.50),
				new Pizza(1, "MAR", "Margherita", 14.00),
				new Pizza(2, "REI", "La Reine", 11.50),
				new Pizza(3, "FRO", "La 4 fromages", 11.50),
				new Pizza(4, "CAN", "La cannibale", 11.50),
				new Pizza(5, "SAV", "La savoyarde", 11.50),
				new Pizza(6, "ORI", "L'orientale", 11.50),
				new Pizza(7, "IND", "L'indienne", 11.50)
		};
		this.pizzas = pizzas;
	}
	
	
	@Override
	public Pizza[] findAll() {
		return pizzas;
	}

	@Override
	public void save(Pizza p) {
		//Création d'un nouveau tableau temporaire et ajout des anciennes valeurs de pizzas
		Pizza[] newPizzas;
		newPizzas = new Pizza[Pizza.getNbPizzas()+1];
		for(int i=0; i<Pizza.getNbPizzas(); i++) {
			newPizzas[i] = pizzas[i];
		}
		newPizzas[Pizza.getNbPizzas()] = p;
		this.pizzas = newPizzas;
		
	}


	@Override
	public void updatePizza(int indice, Pizza pizza) {
		this.pizzas[indice] = pizza;
		
	}


	@Override
	public void deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		
	}
	

}
