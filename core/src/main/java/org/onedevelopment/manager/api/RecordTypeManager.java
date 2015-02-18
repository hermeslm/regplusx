package org.onedevelopment.manager.api;

import java.util.List;

import org.appfuse.service.GenericManager;
import org.onedevelopment.model.RecordType;

public interface RecordTypeManager extends GenericManager<RecordType, Integer> {

	List<RecordType> findByName(String name);

}
