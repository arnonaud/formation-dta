package fr.pizzeria.model;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-12-12T12:33:18.075+0100")
@StaticMetamodel(Commande.class)
public class Commande_ {
	public static volatile SingularAttribute<Commande, Integer> id;
	public static volatile SingularAttribute<Commande, Integer> numeroCommande;
	public static volatile SingularAttribute<Commande, Statut> statut;
	public static volatile SingularAttribute<Commande, Date> dateCommande;
	public static volatile SingularAttribute<Commande, Livreur> livreur;
	public static volatile SingularAttribute<Commande, Client> client;
}
