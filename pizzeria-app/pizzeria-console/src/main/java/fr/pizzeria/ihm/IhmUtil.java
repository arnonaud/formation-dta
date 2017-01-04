package fr.pizzeria.ihm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.PizzaDao;



/**
 * Class IhmUtil avec attribut Scanner et PizzaDAO
 * 
 * @author Arnaud
 *
 */
@Component
public class IhmUtil {

	@Autowired
	private Scanner scanner;
	@Autowired
	private PizzaDao pizzaDao;

		
	public IhmUtil() {

	}

	public Scanner getScanner() {
		return this.scanner;
	}

	public PizzaDao getPizzaDao() {
		return pizzaDao;
	}

}
