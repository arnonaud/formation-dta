package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoTableau;

/**
 * Class IhmUtil avec attribut Scanner et PizzaDAO
 * 
 * @author Arnaud
 *
 */
public class IhmUtil {
	
	
	private Scanner scanner;
	private PizzaDao pizzaDao;
	
	
	public IhmUtil(Scanner scanner, PizzaDaoTableau pizzaDaoTableau) {
		super();
		this.scanner = scanner;
		this.pizzaDao = pizzaDaoTableau;
	}

	public Scanner getScanner() {
		return this.scanner;
	}

	public PizzaDao getPizzaDao() {
		return pizzaDao;
	}

	
}