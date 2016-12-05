package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.abstractfactory.AbstractFactory;
import fr.pizzeria.abstractfactory.FichierFactory;
import fr.pizzeria.abstractfactory.TableauFactory;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;


public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		Pizza p1 = new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE);
      
        
        Pizza p2 = new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE);
        
        System.out.println("p1=p2 ? " + p1.equals(p2));
		
		
		
		 AbstractFactory factory = new TableauFactory();
		//AbstractFactory factory = new FichierFactory();

		PizzaDao pizzaDao = factory.getService().getPizzas();
		Scanner sc = new Scanner(System.in);
		IhmUtil ihmUtil = new IhmUtil(sc, pizzaDao);

		Menu menu = new Menu(ihmUtil);
		menu.demarrer();

	}

}
