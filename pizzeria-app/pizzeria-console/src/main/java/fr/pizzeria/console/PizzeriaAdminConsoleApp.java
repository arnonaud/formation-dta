package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.abstractfactory.AbstractFactory;
import fr.pizzeria.dao.PizzaDao;

import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.ihm.Menu;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoConfig = bundle.getString("dao.impl");
		AbstractFactory daoFactory = (AbstractFactory) Class.forName(daoConfig).newInstance();
		

		PizzaDao pizzaDao = daoFactory.getService().getPizzas();
		Scanner sc = new Scanner(System.in);
		IhmUtil ihmUtil = new IhmUtil(sc, pizzaDao);

		Menu menu = new Menu(ihmUtil);
		menu.demarrer();

	}

}
