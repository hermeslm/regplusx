package org.onedevelopment.dao.impl;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.criterion.Restrictions;
import org.onedevelopment.dao.api.ProvinceDAO;
import org.onedevelopment.model.Province;
import org.springframework.stereotype.Repository;

@Repository("provinceDao")
public class ProvinceDAOImpl extends GenericDaoHibernate<Province, Integer>
		implements ProvinceDAO {

	public ProvinceDAOImpl() {
		super(Province.class);
	}

	@Override
	public List<Province> findByName(String name) {

		return getSession().createCriteria(Province.class)
				.add(Restrictions.eq("name", name)).list();
	}

}
