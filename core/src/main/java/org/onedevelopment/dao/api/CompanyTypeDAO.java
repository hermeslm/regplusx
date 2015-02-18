package org.onedevelopment.dao.api;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.onedevelopment.model.CompanyType;

public interface CompanyTypeDAO extends GenericDao<CompanyType, Integer> {

	public List<CompanyType> findByName(String Name);

}
