package org.onedevelopment.manager.api;

import java.util.List;

import org.appfuse.service.GenericManager;
import org.onedevelopment.model.Client;

public interface ClientManager extends GenericManager<Client, Integer> {

	List<Client> findByName(String name);

}
