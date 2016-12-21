package fr.pizzeria.listener;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class TechniqueListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		Integer compteur = (Integer) se.getSession().getServletContext().getAttribute("compteur");
		if(compteur == null){
			compteur = 0;
		}
		se.getSession().getServletContext().setAttribute("compteur", compteur+1);
		
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}
	

}
