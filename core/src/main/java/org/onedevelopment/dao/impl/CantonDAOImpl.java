package org.onedevelopment.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.onedevelopment.dao.api.CantonDAO;
import org.onedevelopment.model.Canton;
import org.onedevelopment.model.Province;
import org.springframework.stereotype.Repository;

@Repository("cantonDao")
public class CantonDAOImpl extends GenericDaoHibernate<Canton, Integer>
		implements CantonDAO {

	public CantonDAOImpl() {
		super(Canton.class);
	}

	@Override
	public List<Canton> findByName(String name) {

		return getSession().createCriteria(Canton.class)
				.add(Restrictions.eq("name", name)).list();
	}

	public List<Canton> getAllSorted(String sortFied) {

		Criteria criteria = getSession().createCriteria(Canton.class);
		criteria.addOrder(Order.asc(sortFied));
		List<Canton> result = new ArrayList<Canton>();
		try {
			result = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public List<Canton> findByProvinceId(int provinceId) {

		List<Canton> result = new ArrayList<Canton>();
		try {
			Criteria criteria = getSession().createCriteria(Canton.class);
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("id"))
					.add(Projections.property("name")));
			// criteria.addOrder(Order.asc(sortFied));
			Province province = new Province();
			province.setId(provinceId);
			criteria.add(Restrictions.eq("province", province));

			result = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
