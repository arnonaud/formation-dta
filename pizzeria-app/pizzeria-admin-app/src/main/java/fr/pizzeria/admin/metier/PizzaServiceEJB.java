package fr.pizzeria.admin.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Pizza;

@Stateless
public class PizzaServiceEJB {

	@PersistenceContext(unitName="pizza-db") private EntityManager em;
	
	public List<Pizza> findAll(){
		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p", Pizza.class);
		List<Pizza> pizzas = query.getResultList();
		return pizzas;
	}
	
	public void savePizza(Pizza p){
		em.merge(p);
	}
	
	public void updatePizza(int indice, Pizza pizza){

		Pizza p = em.find(Pizza.class, indice);
		if (p != null) {
			p.setCode(pizza.getCode());
			p.setNom(pizza.getNom());
			p.setPrix(pizza.getPrix());
			p.setCategorie(pizza.getCategorie());
			p.setUrlImage(pizza.getUrlImage());

		}

		em.merge(p);
	}
	
	public void deletePizza(String codePizza){
		int indice = findAll().stream().filter(p -> p.getCode().equals(codePizza)).findFirst().get().getId();
		Pizza p = em.find(Pizza.class, indice);
		if (p != null) {
			em.remove(p);
		}
	}
	
}
