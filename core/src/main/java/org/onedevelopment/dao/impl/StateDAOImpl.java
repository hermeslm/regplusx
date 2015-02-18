package org.onedevelopment.dao.impl;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.criterion.Restrictions;
import org.onedevelopment.dao.api.StateDAO;
import org.onedevelopment.model.State;
import org.springframework.stereotype.Repository;

@Repository("stateDao")
public class StateDAOImpl extends GenericDaoHibernate<State, Integer> implements
		StateDAO {

	public StateDAOImpl() {
		super(State.class);
	}

	@Override
	public List<State> findByName(String name) {

		return getSession().createCriteria(State.class)
				.add(Restrictions.eq("name", name)).list();
	}

}
