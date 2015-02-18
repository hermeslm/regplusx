package org.onedevelopment.dao.api;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.onedevelopment.model.Province;

public interface ProvinceDAO extends GenericDao<Province, Integer> {

	public List<Province> findByName(String Name);

}
