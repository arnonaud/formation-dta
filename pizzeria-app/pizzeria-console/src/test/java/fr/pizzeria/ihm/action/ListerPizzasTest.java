package fr.pizzeria.ihm.action;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.console.PizzeriaAppSpringConfig;
import fr.pizzeria.dao.PizzaDao;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PizzeriaAppSpringConfig.class)
public class ListerPizzasTest {

	@Autowired
	private PizzaDao pizzaDao;

	@Test
	public void test() {
		Assert.assertEquals(4, pizzaDao.findAll().size());
	}

}
