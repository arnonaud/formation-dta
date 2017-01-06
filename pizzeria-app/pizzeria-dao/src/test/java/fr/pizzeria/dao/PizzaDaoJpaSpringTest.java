package fr.pizzeria.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PizzaDaoJpaSpringConfig.class)
public class PizzaDaoJpaSpringTest {

	@Autowired
	@Qualifier("pizzaDaoJpaSpring")
	private PizzaDao pizzaDao;

	@Test
	public void findAllPizzas() {
		Assert.assertNotNull(pizzaDao.findAll());
	}

	@Test
	public void addPizza() {
		pizzaDao.savePizza(new Pizza("NNN", "nananan", 12.32, CategoriePizza.VIANDE));
	}

}
