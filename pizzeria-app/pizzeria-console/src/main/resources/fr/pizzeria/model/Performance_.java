package fr.pizzeria.model;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-01-09T10:18:45.466+0100")
@StaticMetamodel(Performance.class)
public class Performance_ {
	public static volatile SingularAttribute<Performance, Integer> id;
	public static volatile SingularAttribute<Performance, Date> date;
	public static volatile SingularAttribute<Performance, Long> milliSecondes;
}
