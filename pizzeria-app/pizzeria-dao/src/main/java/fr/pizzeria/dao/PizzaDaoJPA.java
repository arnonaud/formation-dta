package fr.pizzeria.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
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
import fr.pizzeria.model.Statut;

public class PizzaDaoJPA implements PizzaDao{

	private EntityManagerFactory emf;
	
	 public PizzaDaoJPA() {
		this.emf = Persistence.createEntityManagerFactory("pizzeria-console");
	
		
		/*Pizza p1 =new Pizza("AAA", "Margherita", 14.00, CategoriePizza.POISSON);
		Pizza p2 =new Pizza("BBB", "La Reine", 11.50, CategoriePizza.SANS_VIANDE);
		Pizza p3 =new Pizza("NNNN", "La 4 fromages", 11.50, CategoriePizza.VIANDE);
		Pizza p4 =new Pizza("FFF", "La cannibale", 11.50, CategoriePizza.VIANDE);
		Pizza p5 =new Pizza("DDD", "La savoyarde", 11.50, CategoriePizza.SANS_VIANDE);
										
		save(p1);
		save(p2);
		save(p3);
		save(p4);
		save(p5);
		save(new Pizza("SSS", "L'orientale", 11.50, CategoriePizza.VIANDE));
		save(new Pizza("QQQ", "L'indienne", 11.50, CategoriePizza.POISSON));
		
		
		Client c1 = new Client("Jean", "jean@gmail.com", "123456");
		Client c2 = new Client("Doe", "doe@gmail.com", "123456");
		Client c3 = new Client("Dupont", "dupont@gmail.com", "123456");
		Client c4 = new Client("Tintin", "tintin@gmail.com", "123456");
		
		saveClient(c1);
		saveClient(c2);
		saveClient(c3);
		saveClient(new Client("Man", "man@gmail.com", "123456"));
		saveClient(c4);
		saveClient(new Client("Luke", "luke@gmail.com", "123456"));
		saveClient(new Client("Telo", "telo@gmail.com", "123456"));
		saveClient(new Client("Gar", "gar@gmail.com", "123456"));
		saveClient(new Client("Angelo", "angelo@gmail.com", "123456"));
		saveClient(new Client("Tom", "tom@gmail.com", "123456"));
		
		
		Livreur l1 = new Livreur("man","super");
		Livreur l2 = new Livreur("invisible","man");
		saveLivreur(l1);
		saveLivreur(l2);
		
		Set<Pizza> pizzas1 = new HashSet<Pizza>();
		pizzas1.add(p1);
		Set<Pizza> pizzas2 = new HashSet<Pizza>();
		pizzas2.add(p2);
		pizzas2.add(p3);
		Set<Pizza> pizzas3 = new HashSet<Pizza>();
		pizzas3.add(p4);
		pizzas3.add(p5);
		saveCommande(new Commande("123", Statut.COMMANDER, Date.valueOf("2016-12-12"), l1, c1, pizzas1));
		saveCommande(new Commande("124", Statut.COMMANDER, Date.valueOf("2016-11-15"), l1, c3, pizzas2));
		saveCommande(new Commande("125", Statut.COMMANDER, Date.valueOf("2016-05-01"), l1, c4, pizzas3));
		
		*/
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
			TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p",Pizza.class);
			List<Pizza> pizzas = query.getResultList();
			return pizzas;
		});
		
	}

	@Override
	public List<Livreur> findAllLivreur(){
		return execute((EntityManager em) -> {
			TypedQuery<Livreur> query = em.createQuery("SELECT p FROM Livreur p",Livreur.class);
			List<Livreur> livreurs= query.getResultList();
			return livreurs;
		});
		
	}
	
	@Override
	public List<Client> findAllClient(){
		return execute((EntityManager em) -> {
			TypedQuery<Client> query = em.createQuery("SELECT p FROM Client p",Client.class);
			List<Client> clients= query.getResultList();
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
			if(p != null){
				p.setCode(pizza.getCode());
				p.setNom(pizza.getNom());
				p.setPrix(pizza.getPrix());
				p.setCategorie(pizza.getCategorie());
				
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
			if(p != null){
				em.remove(p);
			}
			
			et.commit();
			return Void.TYPE;
		});
		
	}
	
	@Override
	public boolean connection(String identifiant, String mdp){
		return execute((EntityManager em) -> {
			TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c Where nom=:identifiant",Client.class)
										.setParameter("identifiant", identifiant);
		
					
		
			if(DigestUtils.shaHex(mdp).toString().equals(query.getSingleResult().getMdp())){
				return true;
			}
			else{
				return false;
			}
			
		});
		
		
	}
	
	@Override
	public void addCommande(Commande c){
		execute((EntityManager em) -> {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.merge(c);
			et.commit();
			return Void.TYPE;
		});
	}

	@Override
	public List<Commande> listerCommande(String identifiant){
		return execute((EntityManager em) -> {
			TypedQuery<Commande> query = em.createQuery("SELECT c FROM Commande c",Commande.class);
			List<Commande> commandes = query.getResultList();
			
			
			return commandes;
		});
	}
	
	
}
