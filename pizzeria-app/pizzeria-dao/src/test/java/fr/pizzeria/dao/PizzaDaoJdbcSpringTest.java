package fr.pizzeria.dao;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PizzaDaoJdbcSpringConfig.class)
public class PizzaDaoJdbcSpringTest {

	@Autowired
	private PizzaDao pizzaDao;
	
	@Test
	public void listPizzas() {
		Assert.assertNotNull(pizzaDao.findAll().size());
	}
	
	@Test
	public void ajoutPizza(){
		pizzaDao.savePizza(new Pizza("NNN","nananan",12.32,CategoriePizza.VIANDE));
	}
	
	
	@Test
	public void updatePizza(){
		pizzaDao.updatePizza(11, new Pizza("OOA","nananan",12.32,CategoriePizza.VIANDE));
	}
	
	@Test
	public void deletePizza(){
		pizzaDao.deletePizza("NNN");
	}

}
