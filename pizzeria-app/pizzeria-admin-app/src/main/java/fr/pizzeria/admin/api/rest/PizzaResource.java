package fr.pizzeria.admin.api.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.metier.PizzaServiceEJB;
import fr.pizzeria.model.Pizza;

@Path("/pizzas")
public class PizzaResource {
	
	@EJB private PizzaServiceEJB servicePizza;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> findAll(){
		return servicePizza.findAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addPizza(Pizza pizza){
		servicePizza.savePizza(pizza);
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updatePizza(@PathParam("id") Integer id, Pizza pizza){
		servicePizza.updatePizza(id, pizza);
	}
	
	@DELETE
	@Path("/{code}")
	public void deletePizza(@PathParam("code") String codePizza){
		servicePizza.deletePizza(codePizza);
	}
	
}
