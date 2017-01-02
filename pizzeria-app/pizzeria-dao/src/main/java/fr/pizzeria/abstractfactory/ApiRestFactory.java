package fr.pizzeria.abstractfactory;

import fr.pizzeria.service.ServiceApiRest;

public class ApiRestFactory extends AbstractFactory{

	public ApiRestFactory() {
		super(new ServiceApiRest());
		
	}
	

}
