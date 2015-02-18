package org.onedevelopment.manager.impl;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.onedevelopment.dao.api.RecordTypeDAO;
import org.onedevelopment.manager.api.RecordTypeManager;
import org.onedevelopment.model.RecordType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("recordTypeManager")
@Transactional
public class RecordTypeManagerImpl extends GenericManagerImpl<RecordType, Integer>
		implements RecordTypeManager {

	private RecordTypeDAO recordTypeDao;

	@Autowired
	public void setRecordTypeDAO(final RecordTypeDAO recordTypeDao) {
		this.dao = recordTypeDao;
		this.recordTypeDao = recordTypeDao;
	}

	@Override
	public List<RecordType> findByName(String name) {
		return recordTypeDao.findByName(name);
	}

	public List<RecordType> getRecordType() {
		return recordTypeDao.getAll();
	}

}
