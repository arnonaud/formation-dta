package fr.pizzeria.abstractfactory;

import fr.pizzeria.service.ServiceFichier;

public class FichierFactory extends AbstractFactory {

	public FichierFactory() {
		super(new ServiceFichier());
	}

}
