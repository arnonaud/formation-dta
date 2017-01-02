package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaServiceEJB;

@WebServlet(name = "ClientsController", urlPatterns = {"/clients"})
public class ClientsController extends HttpServlet{
	@EJB private PizzaServiceEJB servicePizza;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/clients.jsp");
		dispatcher.forward(req, resp);
		
	}
	
}
