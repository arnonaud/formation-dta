package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Repository;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.Pizza;

//@Repository
public class PizzaDaoJpaSpring implements PizzaDao {

	@PersistenceContext
	EntityManager em;

	@Autowired
	JpaTransactionManager txManager;

	@Override
	@Transactional
	public List<Pizza> findAll() {

		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p", Pizza.class);
		List<Pizza> pizzas = query.getResultList();
		return pizzas;

	}

	@Override
	@Transactional
	public void savePizza(Pizza p) throws PizzaException {
		em.merge(p);

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
