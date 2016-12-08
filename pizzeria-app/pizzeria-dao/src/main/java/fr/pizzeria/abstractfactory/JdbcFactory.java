package fr.pizzeria.abstractfactory;

import fr.pizzeria.service.ServiceJdbc;

public class JdbcFactory extends AbstractFactory {
	
	public JdbcFactory(){
		super(new ServiceJdbc());
	}
	
}
