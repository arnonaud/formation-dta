package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.abstractfactory.AbstractFactory;
import fr.pizzeria.abstractfactory.FichierFactory;
import fr.pizzeria.abstractfactory.TableauFactory;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.ihm.Menu;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		// AbstractFactory factory = new TableauFactory();
		AbstractFactory factory = new FichierFactory();

		PizzaDao pizzaDao = factory.getService().getPizzas();
		Scanner sc = new Scanner(System.in);
		IhmUtil ihmUtil = new IhmUtil(sc, pizzaDao);

		Menu menu = new Menu(ihmUtil);
		menu.demarrer();

	}

}
