package org.onedevelopment.manager.api;

import java.util.List;

import org.appfuse.service.GenericManager;
import org.onedevelopment.model.Record;

public interface RecordManager extends GenericManager<Record, Integer> {

	List<Record> findByRecord(Integer record);

}
