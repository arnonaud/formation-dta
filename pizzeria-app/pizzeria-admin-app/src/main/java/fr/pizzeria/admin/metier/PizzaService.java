package fr.pizzeria.admin.metier;

import java.util.List;
import java.util.ResourceBundle;

import fr.pizzeria.abstractfactory.AbstractFactory;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

public class PizzaService {

	private PizzaDao pizzaDao;
	
	public PizzaService() {
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoConfig = bundle.getString("dao.impl");
		AbstractFactory daoFactory;
		
		
		try {
			daoFactory = (AbstractFactory) Class.forName(daoConfig).newInstance();
			this.pizzaDao = daoFactory.getService().getPizzas();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Pizza> findAll(){
		return pizzaDao.findAll();
	}
	
	public void savePizza(Pizza p){
		pizzaDao.savePizza(p);
	}
	
	public void updatePizza(int indice, Pizza p){
		pizzaDao.updatePizza(indice, p);
	}
	
	public void deletePizza(String codePizza){
		pizzaDao.deletePizza(codePizza);
	}
}
