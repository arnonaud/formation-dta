package fr.pizzeria.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-12-12T12:32:33.338+0100")
@StaticMetamodel(Client.class)
public class Client_ {
	public static volatile SingularAttribute<Client, Integer> id;
	public static volatile SingularAttribute<Client, String> nom;
	public static volatile SingularAttribute<Client, String> mail;
	public static volatile SingularAttribute<Client, String> mdp;
}
