package org.onedevelopment.service.api;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.appfuse.service.GenericManager;
import org.onedevelopment.model.Province;

@WebService
@Path("/province")
public interface ProvinceService extends GenericManager<Province, Integer> {

	@GET
	@Path("{name}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	List<Province> findByName(@PathParam("name") String name);

	@GET
	List<Province> getProvince();

}
