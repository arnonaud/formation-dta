package fr.pizzeria.ihm.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;

import java.util.List;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.Performance;

@Controller
public class ListerPerfomance extends Action{

	
	@Autowired
	private PizzaDao pizzaDao;

	public ListerPerfomance() {
		super();
	}
	
	@Override
	public void executerAction() throws PizzaException {
		System.out.println("Liste des performances");
		
		List<Performance> performances = this.pizzaDao.findAllPerformance();
		performances.stream().forEach(p -> System.out.println(p.afficherPerformance()));		
	}
	

}
