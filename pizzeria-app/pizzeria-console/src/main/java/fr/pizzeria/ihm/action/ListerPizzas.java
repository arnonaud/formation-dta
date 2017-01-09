package fr.pizzeria.ihm.action;

import java.sql.Date;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Performance;
import fr.pizzeria.model.Pizza;

@Controller
public class ListerPizzas extends Action {

	@Autowired
	private PizzaDao pizzaDao;

	public ListerPizzas() {
		super();
	}

	@Override
	public void executerAction() {
		System.out.println("Liste des pizzas par catégorie");

		// récupétation de toutes les pizzas
		List<Pizza> pizzas = this.pizzaDao.findAll();
		// affichage des pizzas par catégorie

		Comparator<Pizza> comparatorCategorie = Comparator.comparing(Pizza::getCategorie);
		List<Pizza> list = pizzas.stream().sorted(comparatorCategorie).collect(Collectors.toList());
		list.stream().forEach(p -> System.out.println(p.afficherPizza()));

		// affichage de la pizza la plus cher
		System.out.println("Pizza la plus chere");
		Comparator<Pizza> comparator = Comparator.comparing(Pizza::getPrix);
		Pizza pizza = pizzas.stream().max(comparator).get();
		System.out.println(pizza.afficherPizza());
		
	}

}
