package fr.pizzeria.ihm.action;

import fr.pizzeria.exception.StockageException;

public abstract class Action {

	public abstract void executerAction() throws StockageException;

}
