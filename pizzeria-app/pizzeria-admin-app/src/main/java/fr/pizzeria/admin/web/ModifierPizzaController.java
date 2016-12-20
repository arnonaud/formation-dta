package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.abstractfactory.AbstractFactory;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;


@WebServlet( name="ModifierPizzaController", urlPatterns = {"/pizzas/edit"} )
public class ModifierPizzaController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoConfig = bundle.getString("dao.impl");
		AbstractFactory daoFactory;
		try {
			daoFactory = (AbstractFactory) Class.forName(daoConfig).newInstance();
			PizzaDao pizzaDao = daoFactory.getService().getPizzas();
			List<Pizza> pizzas = pizzaDao.findAll();
			
			String code = req.getParameter("code");
			
			Pizza pizza = pizzas.stream().filter(p -> p.getCode().equals(code)).findFirst().get();		
			
			
			req.setAttribute("pizza", pizza);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/miseajour.jsp");
			dispatcher.forward(req, resp);
		
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
