package fr.pizzeria.admin.metier;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Pizza;

import fr.pizzeria.model.Client;

@Stateless
public class ClientServiceEJB {

	@PersistenceContext(unitName="pizza-db") private EntityManager em;

	public List<Client> findAllClient(){
		TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c", Client.class);
		List<Client> clients = query.getResultList();
		return clients;
	}

	public void saveClient(Client c){
		em.merge(c);
	}
	
	public void deleteClient(Integer i){
		Client c = em.find(Client.class, i);
		if(c != null) {
			em.remove(c);
		}
	}
	
	public void updateClient(int indice, Client client){

		Client c = em.find(Client.class, indice);
		if (c != null) {
			c.setNom(client.getNom());
			c.setMail(client.getMail());
			c.setMdp(client.getMdp());

		}

		em.merge(c);
	}
}
