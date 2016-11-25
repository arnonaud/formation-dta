package fr.pizzeria.ihm.action;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;

public class Supprimer extends Action {

	private IhmUtil ihmUtil;
	
	public Supprimer(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void executerAction() {
		System.out.println("Mise à jour d'une pizza");
		//Listing de toute les pizzas
		ListerPizzas listerPizza = new ListerPizzas(ihmUtil);
		listerPizza.executerAction();
		
		System.out.println("Veuillez choisir la pizza à modifier");
		System.out.println("99 pour abandonner");
		
		String codePizza = this.ihmUtil.getScanner().nextLine();
		if(!codePizza.equals("99")){
			List<Pizza> pizzas = this.ihmUtil.getPizzaDao().findAll();

			//index de la pizza à supprimer
			int i=0;
			while((i<pizzas.size())&&(codePizza.equals(pizzas.get(i).getCode()) == false))
			{
				i++;
			}	
			try {
				this.ihmUtil.getPizzaDao().deletePizza(i);
			} catch (StockageException e) {
				e.getMsg();
			}
		}
		
	
		
	}

}
