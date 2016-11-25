package fr.pizzeria.exception;

public class DeletePizzaException extends StockageException {
	

	@Override
	public void getMsg() {
		System.out.println("Erreur dans la suppression d'une pizza : code introuvable");
		
	}
}
