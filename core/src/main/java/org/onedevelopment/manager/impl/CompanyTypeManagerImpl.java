package org.onedevelopment.manager.impl;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.onedevelopment.dao.api.CompanyTypeDAO;
import org.onedevelopment.manager.api.CompanyTypeManager;
import org.onedevelopment.model.CompanyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("companyTypeManager")
@Transactional
public class CompanyTypeManagerImpl extends GenericManagerImpl<CompanyType, Integer>
		implements CompanyTypeManager {

	private CompanyTypeDAO companyTypeDao;

	@Autowired
	public void setCompanyTypeDAO(final CompanyTypeDAO companyTypeDao) {
		this.dao = companyTypeDao;
		this.companyTypeDao = companyTypeDao;
	}

	@Override
	public List<CompanyType> findByName(String name) {
		return companyTypeDao.findByName(name);
	}

	public List<CompanyType> getCompanyType() {
		return companyTypeDao.getAll();
	}

}
