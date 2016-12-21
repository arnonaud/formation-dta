package fr.pizzeria.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns={"/login","/pizzas/list","/pizzas/edit","/pizzas/suppression","/pizzas/technique","/logout","/pizzas/technique"})
public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		if ((session.getAttribute("login") != null) && (session.getAttribute("login").equals("ok"))) {
			if (req.getRequestURI().equals("/arnaud-pizzeria-admin-app/login")) {
				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/pizzas/list");
				dispatcher.forward(req, resp);
			} else {
				chain.doFilter(request, response);
			}

		} else {

			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login");
			dispatcher.forward(req, resp);

		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
