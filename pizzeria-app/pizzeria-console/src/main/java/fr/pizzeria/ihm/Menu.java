package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.action.Action;
import fr.pizzeria.ihm.action.Ajouter;
import fr.pizzeria.ihm.action.ListerPizzas;
import fr.pizzeria.ihm.action.MiseAJour;
import fr.pizzeria.ihm.action.Supprimer;

/**
 * Class menu repr�sentant le d�marrage de l'application,
 * 
 * @author Arnaud
 *
 */

public class Menu {

	/**
	 * Liste des diff�rentes actions
	 * 
	 * @see Action
	 */
	private Map<Integer, Action> menu;

	/**
	 * @see IhmUtil
	 */
	private IhmUtil ihmUtil;

	/**
	 * Constructeur avec cr�ation des differentes Action possibles (lister,
	 * ajouter, mise � jour, suppression)
	 * 
	 * @param ihmUtil
	 */
	public Menu(IhmUtil ihmUtil) {

		this.ihmUtil = ihmUtil;
		menu = new HashMap<>();
		menu.put(1, new ListerPizzas(ihmUtil));
		menu.put(2, new Ajouter(ihmUtil));
		menu.put(3, new MiseAJour(ihmUtil));
		menu.put(4, new Supprimer(ihmUtil));
	}

	/**
	 * Permet de lancer l'action saisie par l'utilisateur
	 */
	private void execAction() {

		int choix = Integer.parseInt(this.ihmUtil.getScanner().nextLine());
		if (choix != 99) {
			if (choix <= 4) {
				try {
					menu.get(choix).executerAction();
				} catch (StockageException e) {
					e.getMsg();
				}
			} else {
				System.out.println("Commande non reconnu");
			}

			demarrer();
		}
	}

	/**
	 * Demarrage de l'application avec affichage du menu et appel � execAction()
	 */
	public void demarrer() {
		System.out.println();
		System.out.println("*****Pizzeria Administration*****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre � jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
		execAction();
	}
}
