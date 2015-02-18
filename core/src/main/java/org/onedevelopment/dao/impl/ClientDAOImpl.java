package org.onedevelopment.dao.impl;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.criterion.Restrictions;
import org.onedevelopment.dao.api.ClientDAO;
import org.onedevelopment.model.Client;
import org.springframework.stereotype.Repository;

@Repository("clientDao")
public class ClientDAOImpl extends GenericDaoHibernate<Client, Integer>
		implements ClientDAO {

	public ClientDAOImpl() {
		super(Client.class);
	}

	@Override
	public List<Client> findByName(String name) {

		return getSession().createCriteria(Client.class)
				.add(Restrictions.eq("name", name)).list();
	}

}
