package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaDaoTableau implements PizzaDao{

	private Pizza[] pizzas = {};
	
	
	public PizzaDaoTableau() {
		Pizza pizzas[] =  {
				new Pizza("PEP", "P�p�roni", 12.50),
				new Pizza("MAR", "Margherita", 14.00),
				new Pizza("REI", "La Reine", 11.50),
				new Pizza("FRO", "La 4 fromages", 11.50),
				new Pizza("CAN", "La cannibale", 11.50),
				new Pizza("SAV", "La savoyarde", 11.50),
				new Pizza("ORI", "L'orientale", 11.50),
				new Pizza("IND", "L'indienne", 11.50)
		};
		this.pizzas = pizzas;
	}
	
	
	@Override
	public Pizza[] findAll() {
		return pizzas;
	}

	@Override
	public void save(Pizza p) {
		//Cr�ation d'un nouveau tableau temporaire et ajout des anciennes valeurs de pizzas
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
	public void deletePizza(int indice) {
		//Cr�ation d'un nouveau tableau temporaire avec suppression de la pizza voulue
		Pizza[] newPizzas = new Pizza[(Pizza.getNbPizzas()-1)];
		int indexNewPizza = 0;
		for(int j=0; j<Pizza.getNbPizzas(); j++) {
			if(j!=indice){
				newPizzas[indexNewPizza] = pizzas[j];
				indexNewPizza++;
			}
		}
		
		this.pizzas = newPizzas;
		
	}
	

}