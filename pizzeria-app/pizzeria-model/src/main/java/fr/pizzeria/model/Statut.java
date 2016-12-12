package fr.pizzeria.model;

public enum Statut {
	NON_TRAITE("Non Traité"),EN_COURS("En Cours"), TERMINER("Terminer");
	
	private String name;

	private Statut(String value) {
		this.name = value;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
}
