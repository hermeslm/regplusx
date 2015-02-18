package org.onedevelopment.dao.api;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.onedevelopment.model.Company;

public interface CompanyDAO extends GenericDao<Company, Integer> {

	public List<Company> findByName(String Name);

	public List<Company> getAllSorted(String sortFied);

}
