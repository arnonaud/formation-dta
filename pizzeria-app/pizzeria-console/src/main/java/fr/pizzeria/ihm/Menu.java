package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.PizzaDaoJdbc;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.ihm.action.Action;
import fr.pizzeria.ihm.action.Ajouter;
import fr.pizzeria.ihm.action.ListerPerfomance;
import fr.pizzeria.ihm.action.ListerPizzas;
import fr.pizzeria.ihm.action.MiseAJour;
import fr.pizzeria.ihm.action.Supprimer;

/**
 * Class menu représentant le démarrage de l'application,
 * 
 * @author Arnaud
 *
 */

@Component
public class Menu {

	/**
	 * Liste des différentes actions
	 * 
	 * @see Action
	 */
	private Map<Integer, Action> menu;

	@Autowired
	private Scanner scanner;
	
	@Autowired
	private ListerPizzas listerPizzas;
	
	@Autowired
	private Ajouter ajouterPizza;

	@Autowired
	private MiseAJour majPizza;
	
	@Autowired
	private Supprimer supprimerPizza;
	
	@Autowired
	private ListerPerfomance listerPerformances;
	
	public Menu() {

	}

	@PostConstruct
	public void init(){
		menu = new HashMap<>();
		menu.put(1, listerPizzas);
		menu.put(2, ajouterPizza);
		menu.put(3, majPizza);
		menu.put(4, supprimerPizza);
		menu.put(5, listerPerformances);
	}
	
	/**
	 * Permet de lancer l'action saisie par l'utilisateur
	 */
	private void execAction() {

		int choix = Integer.parseInt(this.scanner.nextLine());
		if (choix != 99) {
			if (choix <= 5) {
				try {
					menu.get(choix).executerAction();
				} catch (PizzaException e) {
					Logger.getLogger(PizzaDaoJdbc.class.getName()).severe(e.getMessage());
					throw new PizzaException(e);
				}
			} else {
				System.out.println("Commande non reconnu");
			}

			demarrer();
		}
	}

	/**
	 * Demarrage de l'application avec affichage du menu et appel execAction()
	 */
	public void demarrer() {
		System.out.println();
		System.out.println("*****Pizzeria Administration*****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("5. Lister performances");
		System.out.println("99. Sortir");
		execAction();
	}
}
