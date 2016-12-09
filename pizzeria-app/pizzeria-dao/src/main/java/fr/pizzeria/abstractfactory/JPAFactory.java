package fr.pizzeria.abstractfactory;

import fr.pizzeria.service.ServiceJPA;

public class JPAFactory extends AbstractFactory{

	public JPAFactory() {
		super(new ServiceJPA());
		
	}

}
