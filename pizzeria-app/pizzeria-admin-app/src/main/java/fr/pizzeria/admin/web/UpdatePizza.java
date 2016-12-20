package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.abstractfactory.AbstractFactory;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@WebServlet( name="UpdatePizza", urlPatterns = {"/pizzas/updatePizza"} )
public class UpdatePizza extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoConfig = bundle.getString("dao.impl");
		AbstractFactory daoFactory;
		
			try {
				daoFactory = (AbstractFactory) Class.forName(daoConfig).newInstance();
				PizzaDao pizzaDao = daoFactory.getService().getPizzas();
				
			
				String code = req.getParameter("code");
				String nom = req.getParameter("nom");
				Double prix = Double.parseDouble(req.getParameter("prix"));
				CategoriePizza cat = CategoriePizza.valueOf(req.getParameter("cat"));
				String img = req.getParameter("img");
				
				int indice = pizzaDao.findAll().stream().filter(p -> p.getCode().equals(code)).findFirst().get().getId();
				pizzaDao.updatePizza(indice, new Pizza(code,nom,prix,cat));
				
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
}
