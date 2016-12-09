package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.Pizza;

@Entity
public class PizzaDaoJPA implements PizzaDao{

	private EntityManagerFactory emf;
	private EntityManager em;
	 public PizzaDaoJPA() {
		this.emf = Persistence.createEntityManagerFactory("pizzeria-console");
	 }
	
	@Override
	public List<Pizza> findAll() {
		
		em = emf.createEntityManager();
		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p",Pizza.class);
		List<Pizza> pizzas = query.getResultList();
		em.close();
		return pizzas;
	}

	@Override
	public void save(Pizza p) throws PizzaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePizza(int indice, Pizza pizza) throws PizzaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePizza(String codePizza) throws PizzaException {
		// TODO Auto-generated method stub
		
	}
	

}
