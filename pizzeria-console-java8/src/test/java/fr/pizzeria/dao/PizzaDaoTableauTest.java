package fr.pizzeria.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoTableauTest {

	
	private static final Logger LOG = Logger.getLogger(PizzaDaoTableau.class.getName());
	private PizzaDaoTableau pizzaDaoTableau;
	
	@Before
	public void creerPizzaDaoTableau(){
		this.pizzaDaoTableau = new PizzaDaoTableau();
	}
	
	@Test
	public void testSave() {
		
		LOG.info("Etant donnée une nouvelle pizza");
		//prérequis
		Pizza pizza = new Pizza("UNI", "Test Pizza", 12, CategoriePizza.VIANDE);
		
		LOG.info("J'ajoute la nouvelle pizza à la PizzaDaoTableau");
		//enregistrement de la nouvelle pizza
		try {
			pizzaDaoTableau.save(pizza);
		} catch (SavePizzaException e) {
			e.printStackTrace();
		}
		
		//récuperation de la derniere pizza ajoutée
		List<Pizza> pizzas = pizzaDaoTableau.findAll();
		Pizza pizza2 = pizzas.get(pizzas.size()-1);
		
		LOG.info("La dernière pizza ajoutée correspond à la pizza créée au début");
		//test des valeurs de la pizza
		assertEquals(pizza2.getCode(),pizza.getCode());
		assertEquals(pizza2.getNom(),pizza.getNom());
		assertEquals(pizza2.getPrix(),pizza.getPrix(),0.001);
		assertEquals(pizza2.getCategorie(),pizza.getCategorie());
	}

}
