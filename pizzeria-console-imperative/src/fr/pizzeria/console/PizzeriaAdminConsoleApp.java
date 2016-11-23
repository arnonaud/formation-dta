package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {
	
	
	
	public static void main(String args[]){
				
		String pizzas[][]  = {{"0","PEP","Pépéroni","12.50"},
							  {"1","MAR","Margherita","14.00"},
							  {"2","REI","La Reine","11.50"},
							  {"3","FRO","La 4 fromages","12.00"},
							  {"4","CAN","La cannibale","12.50"},
							  {"5","SAV","La savoyarde","13.00"},
							  {"6","ORI","L'orientale","13.50"},
							  {"7","IND","L'indienne","14.00"}};

		afficherMenu();
		Scanner sc = new Scanner(System.in);
		String choix = sc.nextLine();
		do {
			switch (choix) {
			case "1":
				
				listPizzas(pizzas);
				break;

			case "2":
				
				pizzas = ajouterPizza(sc,pizzas);
				break;
				
			case "3":
				
				pizzas = majPizza(sc,pizzas);
				break;
			case "4":
				
				
				pizzas = supprimerPizza(sc,pizzas);
				break;
				
			default:
				break;
			
			}
			afficherMenu();
			choix = sc.nextLine();
		}while (choix.equals("99") == false);
		
		
		sc.close();
	}
	
		
	public static void afficherMenu(){
		System.out.println();
		System.out.println("*****Pizzeria Administration*****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");	
	}
	
	public static void listPizzas(String[][] pizzas){
		//Listing de toutes les pizzas
		for(int i=0; i<pizzas.length; i++) {
			System.out.println(pizzas[i][1] + " -> " + pizzas[i][2] +  " (" + pizzas[i][3] + "€)");
		}
	}
	
	public static String[][] ajouterPizza(Scanner sc, String[][] pizzas){
		
		//Enregistrement des valeurs de l'utilisateur
		System.out.println("Veuillez saisir le code");
		String code = sc.nextLine();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = sc.nextLine();
		System.out.println("Veuillez saisir le prix");
		String prix = sc.nextLine();
		
		//Création d'un nouveau tableau temporaire et ajout des anciennes valeurs de pizzas
		String[][] newPizzas = new String[(pizzas.length)+1][4];
		for(int i=0; i<pizzas.length; i++) {
			newPizzas[i] = pizzas[i];
		}
		
		//index de la nouvelle pizza à ajouter
		int posPizza = pizzas.length;
		
		//ajout de la nouvelle pizza
		newPizzas[posPizza][0] = String.valueOf((newPizzas.length));
		newPizzas[posPizza][1] = code;
		newPizzas[posPizza][2] = nom;
		newPizzas[posPizza][3] = prix;
	
		
		System.out.println("Pizza ajoutée");
		return newPizzas;
		
	}
	
	public static String[][] majPizza(Scanner sc, String[][] pizzas) {
		
		System.out.println("Mise à jour d'une pizza");
		//Listing de toute les pizzas
		listPizzas(pizzas);
		
		System.out.println("Veuillez choisir la pizza à modifier");
		System.out.println("99 pour abandonner");
		
		String codePizza = sc.nextLine();
		int i=0;
		while(codePizza.equals(pizzas[i][1]) == false)
		{
			i++;
		}
		
		System.out.println("Veuillez saisir le code");
		pizzas[i][1] = sc.nextLine();
		System.out.println("Veuillez saisir le nom (sans espace)");
		pizzas[i][2] = sc.nextLine();
		System.out.println("Veuillez saisir le prix");
		pizzas[i][3] = sc.nextLine();
		
		System.out.println("Liste des pizzas modifiée");
		return pizzas;
	}
	
	public static String[][] supprimerPizza(Scanner sc, String[][] pizzas) {
	
		System.out.println("Mise à jour d'une pizza");
		//Listing de toute les pizzas
		listPizzas(pizzas);
		
		System.out.println("Veuillez choisir la pizza à modifier");
		System.out.println("99 pour abandonner");
		
		String codePizza = sc.nextLine();
		if(codePizza.equals("99")){
			return pizzas;
		}
		//index de la pizza à supprimer
		int i=0;
		while(codePizza.equals(pizzas[i][1]) == false)
		{
			i++;
		}	
		
		//Création d'un nouveau tableau temporaire avec suppression de la pizza voulue
		String[][] newPizzas = new String[(pizzas.length)-1][4];
		int indexNewPizza = 0;
		for(int j=0; j<pizzas.length; j++) {
			if(j!=i){
				newPizzas[indexNewPizza] = pizzas[j];
				indexNewPizza++;
			}
		}
		return newPizzas;
	}
}
