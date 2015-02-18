package org.onedevelopment.manager.impl;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.onedevelopment.dao.api.RecordDAO;
import org.onedevelopment.manager.api.RecordManager;
import org.onedevelopment.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("recordManager")
@Transactional
public class RecordManagerImpl extends GenericManagerImpl<Record, Integer>
		implements RecordManager {

	private RecordDAO recordDao;

	@Autowired
	public void setRecordDAO(final RecordDAO recordDao) {
		this.dao = recordDao;
		this.recordDao = recordDao;
	}

	@Override
	public List<Record> findByRecord(Integer record) {
		return recordDao.findByRecord(record);
	}

	public List<Record> getRecord() {
		return recordDao.getAll();
	}

}
