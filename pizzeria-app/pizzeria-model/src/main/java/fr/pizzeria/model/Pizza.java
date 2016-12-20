package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;



/**
 * Definition d'une pizza
 * 
 * @author Arnaud
 *
 */

@Entity
@Table(name="pizza")
public class Pizza {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String code;
	private String nom;
	private double prix;
	@Column(name="url_image")
	private String urlImage;
	@Enumerated(EnumType.STRING)
	private CategoriePizza categorie;

	public Pizza(){
		
	}
	
	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
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

	

	public String afficherPizza() {
		return this.id +" : " +this.code + " -> " + this.nom + " (" + this.prix + "€), categorie : " + this.categorie;
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

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String url_image) {
		this.urlImage = url_image;
	}
}
