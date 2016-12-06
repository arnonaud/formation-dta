package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
	
	
	
	public static void main(String args[]){
	
		Pizza[] pizzas;
		pizzas= new Pizza[8];
		pizzas[0] = new Pizza(0, "PEP", "Pépéroni", 12.50);
		pizzas[1] = new Pizza(1, "MAR", "Margherita", 14.00);
		pizzas[2] = new Pizza(2, "REI", "La Reine", 11.50);
		pizzas[3] = new Pizza(3, "FRO", "La 4 fromages", 11.50);
		pizzas[4] = new Pizza(4, "CAN", "La cannibale", 11.50);
		pizzas[5] = new Pizza(5, "SAV", "La savoyarde", 11.50);
		pizzas[6] = new Pizza(6, "ORI", "L'orientale", 11.50);
		pizzas[7] = new Pizza(7, "IND", "L'indienne", 11.50);
		Pizza.nbPizzas = 8;

		
		Scanner sc = new Scanner(System.in);
		String choix;
		do {
			afficherMenu();
			choix = sc.nextLine();
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
	
	public static void listPizzas(Pizza[] pizzas){
		//Listing de toutes les pizzas
		for(int i=0; i<Pizza.nbPizzas; i++) {
			System.out.println(pizzas[i].code + " -> " + pizzas[i].nom +  " (" + pizzas[i].prix + "€)");
		}
		System.out.println("------- " + Pizza.nbPizzas + " pizzas créées depuis l’initialisation du programme");
	}
	
	public static Pizza[] ajouterPizza(Scanner sc, Pizza[] pizzas){
		
		//Enregistrement des valeurs de l'utilisateur
		System.out.println("Veuillez saisir le code");
		String code = sc.nextLine();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = sc.nextLine();
		System.out.println("Veuillez saisir le prix");
		String prix = sc.nextLine();
		
	
		//Création d'un nouveau tableau temporaire et ajout des anciennes valeurs de pizzas
		Pizza[] newPizzas;
		newPizzas = new Pizza[Pizza.nbPizzas+1];
		for(int i=0; i<Pizza.nbPizzas; i++) {
			newPizzas[i] = pizzas[i];
		}
		
		//Ajout de la nouvelle pizza
		newPizzas[Pizza.nbPizzas] = new Pizza(Pizza.nbPizzas+1, code, nom, Double.parseDouble(prix));
		
		//Increment du nombre de pizza
		Pizza.nbPizzas++;	
		
		System.out.println("Pizza ajoutée");
		return newPizzas;
		
	}
	
	public static Pizza[] majPizza(Scanner sc, Pizza[] pizzas) {
		
		System.out.println("Mise à jour d'une pizza");
		//Listing de toute les pizzas
		listPizzas(pizzas);
		
		System.out.println("Veuillez choisir la pizza à modifier");
		System.out.println("99 pour abandonner");
		
		//Recherche de la pizza à modifier
		String codePizza = sc.nextLine();
		int i=0;
		while(codePizza.equals(pizzas[i].code) == false)
		{
			i++;
		}
		
		//Demande des saisies avec enregistrement des modifications
		System.out.println("Veuillez saisir le code");
		pizzas[i].code = sc.nextLine();
		System.out.println("Veuillez saisir le nom (sans espace)");
		pizzas[i].nom = sc.nextLine();
		System.out.println("Veuillez saisir le prix");
		pizzas[i].prix = Double.parseDouble(sc.nextLine());
		
		System.out.println("Liste des pizzas modifiée");
		return pizzas;
	}
	
	public static Pizza[] supprimerPizza(Scanner sc, Pizza[] pizzas) {
	
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
		while(codePizza.equals(pizzas[i].code) == false)
		{
			i++;
		}	
		
		//Création d'un nouveau tableau temporaire avec suppression de la pizza voulue
		Pizza[] newPizzas = new Pizza[(Pizza.nbPizzas)-1];
		int indexNewPizza = 0;
		for(int j=0; j<Pizza.nbPizzas; j++) {
			if(j!=i){
				newPizzas[indexNewPizza] = pizzas[j];
				indexNewPizza++;
			}
		}
		Pizza.nbPizzas--;
		return newPizzas;
	}
	
	
}
