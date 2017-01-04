package fr.pizzeria.console;

import java.util.logging.Level;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.logging.Logger;
import fr.pizzeria.ihm.Menu;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				PizzeriaAppSpringConfig.class)) {
			Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

			Menu menu = context.getBean(Menu.class);
			menu.demarrer();

		}

	}

}
