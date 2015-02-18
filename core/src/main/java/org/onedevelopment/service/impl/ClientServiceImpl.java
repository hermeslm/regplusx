package org.onedevelopment.service.impl;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.appfuse.dao.SearchException;
import org.appfuse.service.impl.GenericManagerImpl;
import org.onedevelopment.dao.api.ClientDAO;
import org.onedevelopment.model.Client;

@WebService(serviceName = "ClientService", endpointInterface = "org.onedevelopment.dao.api.ClientDAO")
public class ClientServiceImpl extends GenericManagerImpl<Client, Integer>
		implements ClientDAO {

	public ClientServiceImpl() {
	}

	private ClientDAO clientDao;

	public ClientServiceImpl(ClientDAO clientDao) {
		super(clientDao);
		this.clientDao = clientDao;
	}

	@Override
	public List<Client> findByName(String name) {
		return clientDao.findByName(name);
	}

	public List<Client> getClient() {
		return clientDao.getAll();
	}

	@Override
	public List<Client> findByNamedQuery(String arg0, Map<String, Object> arg1) {
		return null;
	}

	@Override
	public List<Client> getAllDistinct() {
		return null;
	}

	@Override
	public List<Client> search(String arg0) throws SearchException {
		return null;
	}

}
