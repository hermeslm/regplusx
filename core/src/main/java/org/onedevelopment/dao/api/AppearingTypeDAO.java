package org.onedevelopment.dao.api;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.onedevelopment.model.AppearingType;

public interface AppearingTypeDAO extends GenericDao<AppearingType, Integer> {

	public List<AppearingType> findByName(String Name);

}
