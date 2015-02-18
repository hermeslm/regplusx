package org.onedevelopment.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.onedevelopment.dao.api.ParroquiaDAO;
import org.onedevelopment.model.Canton;
import org.onedevelopment.model.Parroquia;
import org.springframework.stereotype.Repository;

@Repository("parroquiaDao")
public class ParroquiaDAOImpl extends GenericDaoHibernate<Parroquia, Integer>
		implements ParroquiaDAO {

	public ParroquiaDAOImpl() {
		super(Parroquia.class);
	}

	@Override
	public List<Parroquia> findByName(String name) {

		return getSession().createCriteria(Parroquia.class)
				.add(Restrictions.eq("name", name)).list();
	}

	@Override
	public List<Parroquia> findByCantonId(int cantonId) {

		List<Parroquia> result = new ArrayList<Parroquia>();
		try {
			Criteria criteria = getSession().createCriteria(Parroquia.class);
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("id"))
					.add(Projections.property("name")));
			// criteria.addOrder(Order.asc(sortFied));
			Canton canton = new Canton();
			canton.setId(cantonId);
			criteria.add(Restrictions.eq("canton", canton));

			result = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
