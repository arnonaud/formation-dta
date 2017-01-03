package fr.pizzeria.dao;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Client;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoApiRest implements PizzaDao {

	
	@Override
	public List<Pizza> findAll() {
	
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/arnaud-pizzeria-admin-app");
		Invocation.Builder builder = target.path("api").path("rest").path("pizzas").request();
		Response response = builder.get();
		List<Pizza> readEntity = response.readEntity(new GenericType<List<Pizza>>() {});
		
		return readEntity;
	}
	
	@Override
	public List<fr.pizzeria.model.Client> findAllClient() throws PizzaException {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/arnaud-pizzeria-admin-app");
		Invocation.Builder builder = target.path("api").path("rest").path("clients").request();
		Response response = builder.get();
		List<fr.pizzeria.model.Client> readEntity = response.readEntity(new GenericType<List<fr.pizzeria.model.Client>>() {});
		
		return readEntity;
	}

	@Override
	public void savePizza(Pizza p) throws PizzaException {
	
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/arnaud-pizzeria-admin-app");
		
		Invocation.Builder builder = target.path("api").path("rest").path("pizzas").request();

		p.setId(15);
		builder.post(Entity.json(p));

	}

	@Override
	public void updatePizza(int indice, Pizza pizza) throws PizzaException {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/arnaud-pizzeria-admin-app");
		
		Invocation.Builder builder = target.path("api").path("rest").path("pizzas").path(String.valueOf(indice)).request();

		pizza.setId(7);
		builder.put(Entity.json(pizza));
	}

	@Override
	public void deletePizza(String codePizza) throws PizzaException {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/arnaud-pizzeria-admin-app");
		
		Invocation.Builder builder = target.path("api").path("rest").path("pizzas").path(codePizza).request();

		builder.delete();
	}

}
