package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Login", urlPatterns = { "/login" })
public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/login.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userid = req.getParameter("userid");
		String mdp = req.getParameter("password");
		
		
		if ((userid.equals("admin@pizzeria.fr") && (mdp.equals("admin")))) {
			HttpSession session = req.getSession(true);
			session.setAttribute("login", "ok");
			session.setMaxInactiveInterval(10000);
			resp.sendRedirect("http://localhost:8080/arnaud-pizzeria-admin-app/pizzas/list");
			
		} else {
			resp.sendRedirect("login");

		}

	}
}
