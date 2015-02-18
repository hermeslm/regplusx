package org.onedevelopment.dao.impl;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.criterion.Restrictions;
import org.onedevelopment.dao.api.RepertoryDAO;
import org.onedevelopment.model.Repertory;
import org.springframework.stereotype.Repository;

@Repository("repertoryDao")
public class RepertoryDAOImpl extends GenericDaoHibernate<Repertory, Integer>
		implements RepertoryDAO {

	public RepertoryDAOImpl() {
		super(Repertory.class);
	}

	@Override
	public List<Repertory> findByName(String repertory) {

		return getSession().createCriteria(Repertory.class)
				.add(Restrictions.eq("repertory", repertory)).list();
	}

	@Override
	public List<Repertory> getAllSorted(String sortFied) {
		return null;
	}

}
