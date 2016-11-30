package fr.pizzeria.abstractfactory;

import fr.pizzeria.service.ServiceTableau;

public class TableauFactory extends AbstractFactory {

	public TableauFactory() {
		super(new ServiceTableau());
	}

}
