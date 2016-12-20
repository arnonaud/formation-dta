package fr.pizzeria.admin.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.abstractfactory.AbstractFactory;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaServletWebApi extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoConfig = bundle.getString("dao.impl");
		AbstractFactory daoFactory;
		try {
			daoFactory = (AbstractFactory) Class.forName(daoConfig).newInstance();
			PizzaDao pizzaDao = daoFactory.getService().getPizzas();
			List<Pizza> pizzas = pizzaDao.findAll();
			PrintWriter out = resp.getWriter();
			
			
			pizzas.stream().forEach(p -> {
				out.write(p.afficherPizza());
				out.write("\r\n");
			});			
			resp.setStatus(200);
			
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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoConfig = bundle.getString("dao.impl");
		AbstractFactory daoFactory;
		try {
			daoFactory = (AbstractFactory) Class.forName(daoConfig).newInstance();
			PizzaDao pizzaDao = daoFactory.getService().getPizzas();	
			
			String nom = req.getParameter("nom");
			String code = req.getParameter("code");
			Double prix = Double.parseDouble(req.getParameter("prix"));
			CategoriePizza cat = CategoriePizza.valueOf(req.getParameter("categorie"));
			
			pizzaDao.savePizza(new Pizza(code,nom,prix,cat));
			
			resp.setStatus(201);
			
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
