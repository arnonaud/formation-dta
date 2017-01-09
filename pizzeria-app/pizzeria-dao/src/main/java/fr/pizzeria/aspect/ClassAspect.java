package fr.pizzeria.aspect;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Performance;
import fr.pizzeria.model.Pizza;

@Aspect
@Component
public class ClassAspect {

	@Autowired
	PizzaDao pizzaDao;
	
	@Before("execution(* savePizza(..))")
	public void remplaceCodeIfNull(JoinPoint p) {

		Object o = p.getArgs()[0];
		Pizza pizza = (Pizza) o;

		if (pizza.getCode().length() != 3) {
			pizza.setCode("ZZZ");
		}

	}
	
	//@Around("execution(* fr.pizzeria.dao.PizzaDao.*(..))")
	//public void savePerfomance(ProceedingJoinPoint pjp){
		/*Date date = new Date();
		
		
		long timeMilli = date.getTime();
		
		try {
			Object valeur = pjp.proceed();
			
			long timeMilli2 = date.getTime();

		//	pizzaDao.savePerformance(new Performance("test",new Date(),(int)timeMilli));
			
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
	//}

}
