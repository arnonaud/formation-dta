package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.Pizza;

@Entity
public class PizzaDaoJPA implements PizzaDao{

	private EntityManagerFactory emf;
	
	 public PizzaDaoJPA() {
		this.emf = Persistence.createEntityManagerFactory("pizzeria-console");
	 }
	
	@Override
	public List<Pizza> findAll() {
		
		EntityManager em = emf.createEntityManager();
		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p",Pizza.class);
		List<Pizza> pizzas = query.getResultList();
		em.close();
		return pizzas;
	}

	@Override
	public void save(Pizza p) throws PizzaException {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(p);
		et.commit();
		em.close();
		
	}

	@Override
	public void updatePizza(int indice, Pizza pizza) throws PizzaException {
		EntityManager em = emf.createEntityManager();
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
		em.close();
		
	}

	@Override
	public void deletePizza(String codePizza) throws PizzaException {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		int indice = findAll().stream().filter(p -> p.getCode().equals(codePizza)).findFirst().get().getId();		
		Pizza p = em.find(Pizza.class, indice);
		if(p != null){
			em.remove(p);
		}
		
		et.commit();
		em.close();
		
	}
	

}
