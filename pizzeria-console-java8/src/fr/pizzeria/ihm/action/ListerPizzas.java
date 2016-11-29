package fr.pizzeria.ihm.action;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ListerPizzas extends Action {

	private IhmUtil ihmUtil;

	public ListerPizzas(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void executerAction() {
		System.out.println("Liste des pizzas par catégorie");
		
		//récupération de toutes les pizzas
		List<Pizza> pizzas = this.ihmUtil.getPizzaDao().findAll();
		
		//trie des pizzas par catégorie
		Map<CategoriePizza, List<Pizza>> map = pizzas.stream().collect(Collectors.groupingBy(Pizza::getCategorie));
		
		//affichage des pizzas par catégorie
		Stream.of(CategoriePizza.values())
			.forEach(c -> {
				System.out.println(c);
				map.get(c)
				.stream()
				.forEach(p -> p.afficherPizza());
			});
	
	
		//affichage de la pizza la plus cher
		System.out.println("Pizza la plus chere");
		Comparator<Pizza> comparator = Comparator.comparing(Pizza::getPrix);
		pizzas.stream().max(comparator).get().afficherPizza();
	
	}

}
