package org.onedevelopment.service.api;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.appfuse.service.GenericManager;
import org.onedevelopment.model.Canton;

@WebService
@Path("/canton")
public interface CantonService extends GenericManager<Canton, Integer> {

	@GET
	@Path("{findByName}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	List<Canton> findByName(@PathParam("name") String name);
	
	@GET
	@Path("{findByProvinceId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	List<Canton> findByProvinceId(@PathParam("provinceId") int provinceId);

	@GET
	List<Canton> getCanton();

}
