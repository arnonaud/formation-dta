package fr.pizzeria.admin.api.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.metier.PizzaServiceEJB;
import fr.pizzeria.model.Client;

@Path("/clients")
public class ClientResource {
	@EJB
	private PizzaServiceEJB servicePizza;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> findAllClient() {
		return servicePizza.findAllClient();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addClient(Client client){
		servicePizza.saveClient(client);
	}
}
