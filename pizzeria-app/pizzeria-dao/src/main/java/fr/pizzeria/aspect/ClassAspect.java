package fr.pizzeria.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ClassAspect {

	@Pointcut("execution(* savePizza(..))")
	private void toutesLesMethodesAjout(){
		
	}
	
	@Before("fr.pizzeria.aspect.ClassAspect.toutesLesMethodesAjout")
	public void remplaceCodeIfNull(){
		
	}
}
