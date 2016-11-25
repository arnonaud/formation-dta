package fr.pizzeria.exception;

public class SavePizzaException extends StockageException {

	@Override
	public void getMsg() {
		System.out.println("Erreur dans l'ajout d'une pizza : longueur du code différent de 3");
	
	}

}
