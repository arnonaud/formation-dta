package fr.pizzeria.abstractfactory;

import fr.pizzeria.service.Service;

public class AbstractFactory {
	private Service service;

	public AbstractFactory(Service service){
		this.service = service;
		
	}
	
	public Service getService(){
		return this.service;
	}
}
