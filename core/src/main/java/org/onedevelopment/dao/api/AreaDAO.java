package org.onedevelopment.dao.api;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.onedevelopment.model.Area;

public interface AreaDAO extends GenericDao<Area, Integer> {

	public List<Area> findByName(String Name);

}
