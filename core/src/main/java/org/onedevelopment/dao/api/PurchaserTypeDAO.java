package org.onedevelopment.dao.api;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.onedevelopment.model.PurchaserType;

public interface PurchaserTypeDAO extends GenericDao<PurchaserType, Integer> {

	public List<PurchaserType> findByName(String Name);

}
