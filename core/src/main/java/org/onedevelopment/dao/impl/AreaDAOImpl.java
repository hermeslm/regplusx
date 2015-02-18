package org.onedevelopment.dao.impl;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.criterion.Restrictions;
import org.onedevelopment.dao.api.AreaDAO;
import org.onedevelopment.model.Area;
import org.springframework.stereotype.Repository;

@Repository("areaDao")
public class AreaDAOImpl extends GenericDaoHibernate<Area, Integer> implements
		AreaDAO {

	public AreaDAOImpl() {
		super(Area.class);
	}

	@Override
	public List<Area> findByName(String name) {

		return getSession().createCriteria(Area.class)
				.add(Restrictions.eq("name", name)).list();
	}

}
