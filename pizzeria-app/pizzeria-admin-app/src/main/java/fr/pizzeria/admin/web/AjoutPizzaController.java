package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;


@WebServlet(name = "AjoutPizzaController", urlPatterns = { "/pizzas/ajout" })
public class AjoutPizzaController extends HttpServlet{

	@Inject private PizzaService servicePizza;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/ajouterPizza.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		Double prix = Double.parseDouble(req.getParameter("prix"));
		CategoriePizza cat = CategoriePizza.valueOf(req.getParameter("cat"));
		String img = req.getParameter("img");
	
		servicePizza.savePizza(new Pizza(code, nom, prix, cat, img));
		
		resp.sendRedirect("list");

	}
	
}
