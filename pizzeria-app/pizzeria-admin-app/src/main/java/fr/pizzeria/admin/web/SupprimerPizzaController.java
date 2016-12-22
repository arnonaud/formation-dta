package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.admin.metier.PizzaServiceEJB;

@WebServlet(name = "SupprimerPizzaController", urlPatterns = { "/pizzas/suppression" })
public class SupprimerPizzaController extends HttpServlet {

	//@Inject private PizzaService servicePizza;
	
	@EJB private PizzaServiceEJB servicePizza;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String code = req.getParameter("code");
		servicePizza.deletePizza(code);

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/pizzas/list");
		dispatcher.forward(req, resp);

	}

}
