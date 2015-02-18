package org.onedevelopment.manager.api;

import java.util.List;

import org.appfuse.service.GenericManager;
import org.onedevelopment.model.CompanyType;

public interface CompanyTypeManager extends GenericManager<CompanyType, Integer> {

	List<CompanyType> findByName(String name);

}
