package fr.pizzeria.exception;

public class UpdatePizzaException extends StockageException {

	@Override
	public void getMsg() {
		System.out.println("Erreur dans la modification d'une pizza : code introuvable");

	}
}
