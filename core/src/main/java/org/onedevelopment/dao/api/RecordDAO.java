package org.onedevelopment.dao.api;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.onedevelopment.model.Record;

public interface RecordDAO extends GenericDao<Record, Integer> {

	public List<Record> findByRecord(Integer record);

}
