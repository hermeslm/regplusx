package org.onedevelopment.manager.impl;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.onedevelopment.dao.api.RepertoryDAO;
import org.onedevelopment.manager.api.RepertoryManager;
import org.onedevelopment.model.Repertory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("repertoryManager")
@Transactional
public class RepertoryManagerImpl extends
		GenericManagerImpl<Repertory, Integer> implements RepertoryManager {

	private RepertoryDAO repertoryDao;

	@Autowired
	public void setRepertoryDAO(final RepertoryDAO repertoryDao) {
		this.dao = repertoryDao;
		this.repertoryDao = repertoryDao;
	}

	@Override
	public List<Repertory> findByName(String repertory) {
		return repertoryDao.findByName(repertory);
	}

	public List<Repertory> getRepertory() {
		return repertoryDao.getAll();
	}

}
