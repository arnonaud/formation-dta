package fr.pizzeria.ihm.action;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.ihm.IhmUtil;

public class ImportJdbc extends Action{

	
	private IhmUtil ihmUtil;

	public ImportJdbc(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
	}

	
	public void executerAction() throws PizzaException {
	
		this.ihmUtil.getPizzaDao().importJdbc();
	}
	

}
