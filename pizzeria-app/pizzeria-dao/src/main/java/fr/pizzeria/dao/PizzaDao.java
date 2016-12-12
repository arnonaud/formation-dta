package fr.pizzeria.dao;

import java.util.List;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;

public interface PizzaDao {

	List<Pizza> findAll();
	
	default List<Livreur> findAllLivreur() throws PizzaException{
		throw new PizzaException("Not Yet Implement");
	};
	
	default List<Client> findAllClient() throws PizzaException{
		throw new PizzaException("Not Yet Implement");
	};
	
	void savePizza(Pizza p) throws PizzaException;
	
	default void saveClient(Client p) throws PizzaException{
		throw new PizzaException("Not Yet Implement");
	};

	default void saveCommande(Commande p) throws PizzaException{
		throw new PizzaException("Not Yet Implement");
	};
	
	void updatePizza(int indice, Pizza pizza) throws PizzaException;

	void deletePizza(String codePizza) throws PizzaException;
	
	default void importJdbc() throws PizzaException{
		throw new PizzaException("Not Yet Implement");
	};
	
	default boolean connection(String identifiant,String mdp) throws PizzaException{
		throw new PizzaException("Not Yet Implement");
	};
	
	default void addCommande(Commande c) throws PizzaException{
		throw new PizzaException("Not Yet Implement");
	};
	
	default List<Commande> listerCommande(String identifiant) throws PizzaException{
		throw new PizzaException("Not Yet Implement");
	};
}
