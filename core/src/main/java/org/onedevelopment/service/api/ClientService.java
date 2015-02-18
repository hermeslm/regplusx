package org.onedevelopment.service.api;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.appfuse.service.GenericManager;
import org.onedevelopment.model.Client;

@WebService
@Path("/client")
public interface ClientService extends GenericManager<Client, Integer> {

	@GET
	@Path("{name}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	List<Client> findByName(@PathParam("name") String name);

	@GET
	List<Client> getCient();

}
