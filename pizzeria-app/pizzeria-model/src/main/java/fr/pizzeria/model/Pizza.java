package fr.pizzeria.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;



/**
 * Definition d'une pizza
 * 
 * @author Arnaud
 *
 */

@Entity
public class Pizza {

	@Id
	private Integer id;
	@Column(name="reference")
	private String code;
	@Column(name="libelle")
	private String nom;
	private double prix;
	private static int nbPizzas;
	@Enumerated(EnumType.STRING)
	private CategoriePizza categorie;

	public Pizza(){
		
	}
	
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
		System.out.println(this.code + " -> " + this.nom + " (" + this.prix + "€), categorie : " + this.categorie);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) { return false; }
		   if (obj == this) { return true; }
		   if (obj.getClass() != getClass()) {
		     return false;
		   }
		   Pizza rhs = (Pizza) obj;
		   return new EqualsBuilder()
		                 .append(code, rhs.code)
		                 .append(nom, rhs.nom)
		                 .append(prix, rhs.prix)
		                 .append(categorie, rhs.categorie)
		                 .isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).
			       append(code).
			       append(nom).
			       append(prix).
			       append(categorie).
			       toHashCode();
	}
}
