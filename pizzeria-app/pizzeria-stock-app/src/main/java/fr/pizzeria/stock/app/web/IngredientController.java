package fr.pizzeria.stock.app.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Ingredient;



@Controller
public class IngredientController {

	@Autowired
	private PizzaDao pizzaDao;
	
	@RequestMapping(value="/ingredients", method = RequestMethod.GET)
	public String listIngredients() {
		return "listIngredients";
	}
	
	@RequestMapping(value ="/ingredient/{ingredientId}", method = RequestMethod.GET)
	public String editIngredient(@PathVariable int ingredientId, Model model) {
		
		Ingredient ingredient = pizzaDao.findAllIngredients().stream().filter(i -> i.getId() == ingredientId).findFirst().get();
		model.addAttribute("ingredient",ingredient);
		return "editIngredient";
	}

}
