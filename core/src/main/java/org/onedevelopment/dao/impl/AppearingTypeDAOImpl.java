package org.onedevelopment.dao.impl;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.criterion.Restrictions;
import org.onedevelopment.dao.api.AppearingTypeDAO;
import org.onedevelopment.model.AppearingType;
import org.springframework.stereotype.Repository;

@Repository("appearingTypeDao")
public class AppearingTypeDAOImpl extends GenericDaoHibernate<AppearingType, Integer>
		implements AppearingTypeDAO {

	public AppearingTypeDAOImpl() {
		super(AppearingType.class);
	}

	@Override
	public List<AppearingType> findByName(String name) {

		return getSession().createCriteria(AppearingType.class)
				.add(Restrictions.eq("name", name)).list();
	}

}
