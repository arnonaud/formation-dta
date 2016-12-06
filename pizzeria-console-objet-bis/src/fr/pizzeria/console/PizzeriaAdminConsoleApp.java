package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoTableau;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.ihm.Menu;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		PizzaDaoTableau pizzaDaoTableau = new PizzaDaoTableau();
		Scanner sc = new Scanner(System.in);
		IhmUtil ihmUtil = new IhmUtil(sc, pizzaDaoTableau);

		Menu menu = new Menu(ihmUtil);
		menu.demarrer();

	}

}
