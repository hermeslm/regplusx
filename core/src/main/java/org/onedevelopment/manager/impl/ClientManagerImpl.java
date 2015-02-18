package org.onedevelopment.manager.impl;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.onedevelopment.dao.api.ClientDAO;
import org.onedevelopment.manager.api.ClientManager;
import org.onedevelopment.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("clientManager")
@Transactional
public class ClientManagerImpl extends GenericManagerImpl<Client, Integer>
		implements ClientManager {

	private ClientDAO clientDao;

	@Autowired
	public void setClientDAO(final ClientDAO clientDao) {
		this.dao = clientDao;
		this.clientDao = clientDao;
	}

	@Override
	public List<Client> findByName(String name) {
		return clientDao.findByName(name);
	}

}
