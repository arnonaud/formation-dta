package fr.pizzeria.admin.api.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.metier.ClientServiceEJB;
import fr.pizzeria.model.Client;


@Path("/clients")
public class ClientResource {
	
	@EJB private ClientServiceEJB serviceClient;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> findAllClient() {
		return serviceClient.findAllClient();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addClient(Client client){
		serviceClient.saveClient(client);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteClient(@QueryParam("id") int id){
		 serviceClient.deleteClient(id);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateClient(@QueryParam("id") int id, Client client){
		serviceClient.updateClient(id,client);
	}
	

}
