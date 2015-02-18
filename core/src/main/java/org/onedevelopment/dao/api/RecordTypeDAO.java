package org.onedevelopment.dao.api;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.onedevelopment.model.RecordType;

public interface RecordTypeDAO extends GenericDao<RecordType, Integer> {

	public List<RecordType> findByName(String Name);

}
