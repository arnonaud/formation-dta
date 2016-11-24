package fr.pizzeria.ihm.action;


import java.util.Scanner;

import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;

public class MiseAJour extends Action{

	private IhmUtil ihmUtil;
	
	public MiseAJour(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
	}
	
	
	@Override
	public void executerAction() {
		System.out.println("mise à jour d'une pizza");
		//Listing de toute les pizzas
		ListerPizzas listerPizza = new ListerPizzas(ihmUtil);
		listerPizza.executerAction();
		
		System.out.println("Veuillez choisir la pizza à modifier");
		System.out.println("99 pour abandonner");
		
		//Recherche de la pizza à modifier
		Scanner sc = this.ihmUtil.getScanner();
		String codePizza = sc.nextLine();
		int i=0;
		Pizza[] pizzas = this.ihmUtil.getPizzaDao().findAll();
		while(codePizza.equals(pizzas[i].getCode()) == false)
		{
			i++;
		}
		
		//Demande des saisies avec stockage des modifications
		System.out.println("Veuillez saisir le code");
		String code = sc.nextLine();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = sc.nextLine();
		System.out.println("Veuillez saisir le prix");
		double prix = Double.parseDouble(sc.nextLine());
		
		Pizza pizza = new Pizza(i, code, nom, prix);
		
		this.ihmUtil.getPizzaDao().updatePizza(i, pizza);
		System.out.println("Liste des pizzas modifiée");
	
	}

}