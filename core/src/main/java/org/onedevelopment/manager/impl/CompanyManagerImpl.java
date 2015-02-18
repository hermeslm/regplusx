package org.onedevelopment.manager.impl;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.onedevelopment.dao.api.CompanyDAO;
import org.onedevelopment.manager.api.CompanyManager;
import org.onedevelopment.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("companyManager")
@Transactional
public class CompanyManagerImpl extends GenericManagerImpl<Company, Integer>
		implements CompanyManager {

	private CompanyDAO companyDao;

	@Autowired
	public void setCompanyDAO(final CompanyDAO companyDao) {
		this.dao = companyDao;
		this.companyDao = companyDao;
	}

	@Override
	public List<Company> findByName(String name) {
		return companyDao.findByName(name);
	}

	public List<Company> getCompany() {
		return companyDao.getAll();
	}

}
