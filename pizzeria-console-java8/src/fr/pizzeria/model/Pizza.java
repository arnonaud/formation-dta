package fr.pizzeria.model;

/**
 * Definition d'une pizza
 * 
 * @author Arnaud
 *
 */
public class Pizza {

	private Integer id;
	private String code;
	private String nom;
	private double prix;
	private static int nbPizzas;
	private CategoriePizza categorie;

	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		this.id = nbPizzas;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		Pizza.nbPizzas = 8;
		this.categorie = categorie;

	}

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public static int getNbPizzas() {
		return nbPizzas;
	}

	public static void addNbPizzas() {
		Pizza.nbPizzas++;
	}

	public static void supNbPizzas() {
		Pizza.nbPizzas--;
	}

	public void afficherPizza() {
		System.out.println(this.code + " -> " + this.nom + " (" + this.prix + "�), categorie : " + this.categorie);
	}
}