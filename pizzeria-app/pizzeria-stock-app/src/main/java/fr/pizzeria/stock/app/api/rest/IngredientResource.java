package fr.pizzeria.stock.app.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Ingredient;

@Controller
public class IngredientResource {

	@Autowired
	private PizzaDao pizzaDao;

	@RequestMapping(value = "/rest/ingredients", method = RequestMethod.GET)
	@ResponseBody
	public List<Ingredient> listIngredients() {
		return pizzaDao.findAllIngredients();
	}

	@RequestMapping(value = "/rest/ingredient", method = RequestMethod.POST)
	public void ajoutIngredient(@ModelAttribute("ingredient") Ingredient ingredient) {
		pizzaDao.saveIngredient(ingredient);
	}

	@RequestMapping(value = "/rest/ingredient/{ingredientId}", method = RequestMethod.GET)
	@ResponseBody
	public Ingredient findIngredient(@PathVariable int ingredientId) {
		return pizzaDao.findAllIngredients().stream().filter(i -> i.getId() == ingredientId).findFirst().get();
	}

	@RequestMapping(value = "/ingredient/{ingredientId}", method = RequestMethod.POST)
	@ResponseBody
	public void updateIngredient(@PathVariable int ingredientId, @ModelAttribute("ingredient") Ingredient ingredient) {
		pizzaDao.updateIngredient(ingredientId, ingredient);

	}

}
