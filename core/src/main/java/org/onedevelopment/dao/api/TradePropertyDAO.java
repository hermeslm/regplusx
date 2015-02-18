package org.onedevelopment.dao.api;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.onedevelopment.model.TradeProperty;

public interface TradePropertyDAO extends GenericDao<TradeProperty, Integer> {

	//public List<TradeProperty> findByName(String Name);

	public List<TradeProperty> getAllSorted(String sortFied);

}
