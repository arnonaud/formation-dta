package fr.pizzeria.dao;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.commons.codec.digest.DigestUtils;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJPA implements PizzaDao {

	private EntityManagerFactory emf;

	public PizzaDaoJPA() {
		this.emf = Persistence.createEntityManagerFactory("pizzeria-console");

	}

	public void saveCommande(Commande p) throws PizzaException {

		execute((EntityManager em) -> {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.merge(p);
			et.commit();
			return Void.TYPE;
		});

	}

	public void saveClient(Client p) throws PizzaException {

		execute((EntityManager em) -> {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.merge(p);
			et.commit();
			return Void.TYPE;
		});

	}

	public void saveLivreur(Livreur p) throws PizzaException {

		execute((EntityManager em) -> {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.merge(p);
			et.commit();
			return Void.TYPE;
		});

	}

	interface IRunJPA<T> {
		T exe(EntityManager em) throws SQLException;
	}

	public <T> T execute(IRunJPA<T> run) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			return run.exe(em);
		} catch (Exception e) {
			Logger.getLogger(PizzaDaoJPA.class.getName()).severe(e.getMessage());
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return null;

	}

	@Override
	public List<Pizza> findAll() {

		return execute((EntityManager em) -> {
			TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p", Pizza.class);
			List<Pizza> pizzas = query.getResultList();
			return pizzas;
		});

	}

	@Override
	public List<Livreur> findAllLivreur() {
		return execute((EntityManager em) -> {
			TypedQuery<Livreur> query = em.createQuery("SELECT p FROM Livreur p", Livreur.class);
			List<Livreur> livreurs = query.getResultList();
			return livreurs;
		});

	}

	@Override
	public List<Client> findAllClient() {
		return execute((EntityManager em) -> {
			TypedQuery<Client> query = em.createQuery("SELECT p FROM Client p", Client.class);
			List<Client> clients = query.getResultList();
			return clients;
		});

	}

	@Override
	public void savePizza(Pizza p) throws PizzaException {

		execute((EntityManager em) -> {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.merge(p);
			et.commit();
			return Void.TYPE;
		});

	}

	@Override
	public void updatePizza(int indice, Pizza pizza) throws PizzaException {

		execute((EntityManager em) -> {
			EntityTransaction et = em.getTransaction();
			et.begin();

			Pizza p = em.find(Pizza.class, indice);
			if (p != null) {
				p.setCode(pizza.getCode());
				p.setNom(pizza.getNom());
				p.setPrix(pizza.getPrix());
				p.setCategorie(pizza.getCategorie());
				p.setUrlImage(pizza.getUrlImage());

			}

			et.commit();
			return Void.TYPE;
		});

	}

	@Override
	public void deletePizza(String codePizza) throws PizzaException {

		execute((EntityManager em) -> {
			EntityTransaction et = em.getTransaction();
			et.begin();

			int indice = findAll().stream().filter(p -> p.getCode().equals(codePizza)).findFirst().get().getId();
			Pizza p = em.find(Pizza.class, indice);
			if (p != null) {
				em.remove(p);
			}

			et.commit();
			return Void.TYPE;
		});

	}

	@Override
	public boolean connection(String identifiant, String mdp) {
		return execute((EntityManager em) -> {
			TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c Where nom=:identifiant", Client.class)
					.setParameter("identifiant", identifiant);

			if (DigestUtils.shaHex(mdp).toString().equals(query.getSingleResult().getMdp())) {
				return true;
			} else {
				return false;
			}

		});

	}

	@Override
	public void addCommande(Commande c) {
		execute((EntityManager em) -> {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.merge(c);
			et.commit();
			return Void.TYPE;
		});
	}

	@Override
	public List<Commande> listerCommande(String identifiant) {
		return execute((EntityManager em) -> {
			TypedQuery<Commande> query = em.createQuery("SELECT c FROM Commande c", Commande.class);
			List<Commande> commandes = query.getResultList();

			commandes.stream().forEach(c -> {
				c.afficher();
			});
			return commandes;
		});
	}

}
