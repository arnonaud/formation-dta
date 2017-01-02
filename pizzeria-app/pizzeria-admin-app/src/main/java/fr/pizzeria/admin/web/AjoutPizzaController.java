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
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;


@WebServlet(name = "AjoutPizzaController", urlPatterns = { "/pizzas/ajout" })
public class AjoutPizzaController extends HttpServlet{

	//@Inject private PizzaService servicePizza;
	
	@EJB private PizzaServiceEJB servicePizza;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/ajouterPizza.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String nom = req.getParameter("nomCli");
		String mail = req.getParameter("mailCli");
		String password = req.getParameter("mdpCli");
		
		servicePizza.saveClient(new Client(nom,mail,password));
	

	}
	
}
