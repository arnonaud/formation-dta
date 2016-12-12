package fr.pizzeria.model;

import java.sql.Date;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "numero_commande")
	private String numeroCommande;
	@Enumerated(EnumType.STRING)
	private Statut statut;
	@Column(name = "date_commande")
	private Date dateCommande;
	@ManyToOne
	@JoinColumn(name = "livreur_id")
	private Livreur livreur;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@ManyToMany
	@JoinTable(name = "commande_pizza", joinColumns = @JoinColumn(name = "commande_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"))
	private Set<Pizza> pizzas;

	public Commande() {

	}

	public Commande(String numeroCommande, Statut statut, Date dateCommande, Livreur livreur, Client client,
			Set<Pizza> pizzas) {
		super();
		this.numeroCommande = numeroCommande;
		this.statut = statut;
		this.dateCommande = dateCommande;
		this.livreur = livreur;
		this.client = client;
		this.pizzas = pizzas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getnumeroCommande() {
		return numeroCommande;
	}

	public void setnumeroCommande(String numeroCommande) {
		this.numeroCommande = numeroCommande;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Date getdateCommande() {
		return dateCommande;
	}

	public void setdateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Livreur getlivreur() {
		return livreur;
	}

	public void setlivreur(Livreur livreur) {
		this.livreur = livreur;
	}

	public Client getclient() {
		return client;
	}

	public void setclient(Client client) {
		this.client = client;
	}

	public void afficher() {
		System.out.println("Numero commande : " + this.numeroCommande);
		System.out.println("Statut : " + this.statut.getName());
		System.out.println("Date : " + this.dateCommande);
		System.out.println("Livreur : " + this.livreur.getNom() + " " + this.livreur.getPrenom());
		System.out.println("Pizza(s) : ");
		
		//TODO listing des pizzas
		//System.out.println(this.pizzas);
		
	
	}
}
