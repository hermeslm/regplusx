package org.onedevelopment.dao.impl;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.criterion.Restrictions;
import org.onedevelopment.dao.api.CompanyTypeDAO;
import org.onedevelopment.model.CompanyType;
import org.springframework.stereotype.Repository;

@Repository("companyTypeDao")
public class CompanyTypeDAOImpl extends GenericDaoHibernate<CompanyType, Integer>
		implements CompanyTypeDAO {

	public CompanyTypeDAOImpl() {
		super(CompanyType.class);
	}

	@Override
	public List<CompanyType> findByName(String name) {

		return getSession().createCriteria(CompanyType.class)
				.add(Restrictions.eq("name", name)).list();
	}

}
