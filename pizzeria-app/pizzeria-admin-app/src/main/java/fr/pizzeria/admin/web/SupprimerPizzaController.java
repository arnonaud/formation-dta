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

@WebServlet( name="SupprimerPizzaController", urlPatterns = {"/pizzas/suppression"} )
public class SupprimerPizzaController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoConfig = bundle.getString("dao.impl");
		AbstractFactory daoFactory;
		try {
			daoFactory = (AbstractFactory) Class.forName(daoConfig).newInstance();
			PizzaDao pizzaDao = daoFactory.getService().getPizzas();

			String code = req.getParameter("code");
			pizzaDao.deletePizza(code);

			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/pizzas/list");
			dispatcher.forward(req, resp);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
