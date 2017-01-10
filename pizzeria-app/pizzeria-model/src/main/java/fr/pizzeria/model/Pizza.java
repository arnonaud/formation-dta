package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



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

	public Pizza(String code, String nom, double prix, CategoriePizza categorie, String url) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
		this.urlImage = url;

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
	
	

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String url_image) {
		this.urlImage = url_image;
	}
}
