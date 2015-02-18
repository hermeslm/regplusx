package org.onedevelopment.dao.impl;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.criterion.Restrictions;
import org.onedevelopment.dao.api.CompanyDAO;
import org.onedevelopment.model.Company;
import org.springframework.stereotype.Repository;

@Repository("companyDao")
public class CompanyDAOImpl extends GenericDaoHibernate<Company, Integer>
		implements CompanyDAO {

	public CompanyDAOImpl() {
		super(Company.class);
	}

	@Override
	public List<Company> findByName(String name) {

		return getSession().createCriteria(Company.class)
				.add(Restrictions.eq("name", name)).list();
	}

	@Override
	public List<Company> getAllSorted(String sortFied) {
		return null;
	}

}
