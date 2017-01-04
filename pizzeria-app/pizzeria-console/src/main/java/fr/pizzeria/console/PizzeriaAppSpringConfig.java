package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.pizzeria.abstractfactory.AbstractFactory;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.ihm.action.Action;
import fr.pizzeria.ihm.action.Ajouter;
import fr.pizzeria.ihm.action.ListerPizzas;
import fr.pizzeria.ihm.action.MiseAJour;
import fr.pizzeria.ihm.action.Supprimer;

@Configuration
@ComponentScan("fr.pizzeria.ihm")
public class PizzeriaAppSpringConfig {

	@Bean
	public Scanner scanner() {
		Scanner scanner = new Scanner(System.in);
		return scanner;
	}

	@Bean
	public PizzaDao pizzaDao() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoConfig = bundle.getString("dao.impl");
		AbstractFactory daoFactory;

		daoFactory = (AbstractFactory) Class.forName(daoConfig).newInstance();
		return daoFactory.getService().getPizzas();

	}
	
	@Bean
	public Action listerPizzas(){
		return new ListerPizzas(); 
	}

	@Bean
	public Action ajouterPizza(){
		return new Ajouter();
	}
	
	@Bean
	public Action majPizza(){
		return new MiseAJour();
	}
	
	@Bean
	public Action supprimerPizza(){
		return new Supprimer();
	}
}
