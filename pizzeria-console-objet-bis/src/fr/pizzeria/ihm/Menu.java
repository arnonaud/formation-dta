package fr.pizzeria.ihm;

import fr.pizzeria.ihm.action.Action;
import fr.pizzeria.ihm.action.Ajouter;
import fr.pizzeria.ihm.action.ListerPizzas;
import fr.pizzeria.ihm.action.MiseAJour;
import fr.pizzeria.ihm.action.Supprimer;

/**
 * Class menu représentant le démarrage de l'application,
 * @author Arnaud
 *
 */

public class Menu {

	/**
	 * Liste des différentes actions
	 * @see Action
	 */
	private Action[] menu = new Action[5];
	
	
	/**
	 * @see IhmUtil
	 */
	private IhmUtil ihmUtil;
	
	
	/**
	 * Constructeur avec création des differentes Action possibles (lister, ajouter, mise à jour, suppression)
	 * @param ihmUtil
	 */
	public Menu(IhmUtil ihmUtil) {
			
		this.ihmUtil = ihmUtil;
		
		this.menu[1] = new ListerPizzas(ihmUtil);
		this.menu[2] = new Ajouter(ihmUtil);
		this.menu[3] = new MiseAJour(ihmUtil);
		this.menu[4] = new Supprimer(ihmUtil);
	}
	
	/**
	 * Permet de lancer l'action saisie par l'utilisateur
	 */
	private void execAction() {
		
		int choix = Integer.parseInt(this.ihmUtil.getScanner().nextLine());
		if(choix != 99){
			this.menu[choix].executerAction();
			demarrer();
		}
		
	}
	
	/**
	 * Demarrage de l'application avec affichage du menu et appel à execAction()
	 */
	public void demarrer() {
		System.out.println();
		System.out.println("*****Pizzeria Administration*****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");	
		execAction();
	}
}
