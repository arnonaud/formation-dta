package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.admin.metier.PizzaServiceEJB;

@WebServlet(name = "ModifierPizzaController", urlPatterns = { "/pizzas/edit" })
public class ModifierPizzaController extends HttpServlet {

	//@Inject private PizzaService servicePizza;
	
	@EJB private PizzaServiceEJB servicePizza;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Pizza> pizzas = servicePizza.findAll();
		
		String code = req.getParameter("code");
		Pizza pizza = pizzas.stream().filter(p -> p.getCode().equals(code)).findFirst().get();

		req.setAttribute("pizza", pizza);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/miseajour.jsp");
		dispatcher.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		Double prix = Double.parseDouble(req.getParameter("prix"));
		CategoriePizza cat = CategoriePizza.valueOf(req.getParameter("cat"));
		String img = req.getParameter("img");
		String prevCode = req.getParameter("prevCode");
		
		int indice = servicePizza.findAll().stream().filter(p -> p.getCode().equals(prevCode)).findFirst().get().getId();
		
		servicePizza.updatePizza(indice, new Pizza(code, nom, prix, cat, img));

		resp.sendRedirect("list");
		
	}

}
