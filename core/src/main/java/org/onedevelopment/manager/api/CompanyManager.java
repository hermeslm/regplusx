package org.onedevelopment.manager.api;

import java.util.List;

import org.appfuse.service.GenericManager;
import org.onedevelopment.model.Company;

public interface CompanyManager extends GenericManager<Company, Integer> {

	List<Company> findByName(String name);

}
