package org.onedevelopment.dao.api;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.onedevelopment.model.Client;

public interface ClientDAO extends GenericDao<Client, Integer> {

	public List<Client> findByName(String Name);

}
