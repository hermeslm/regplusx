package org.onedevelopment.dao.api;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.onedevelopment.model.Canton;

public interface CantonDAO extends GenericDao<Canton, Integer> {

	public List<Canton> findByName(String Name);

	public List<Canton> getAllSorted(String sortFied);

	public List<Canton> findByProvinceId(int provinceId);

}
