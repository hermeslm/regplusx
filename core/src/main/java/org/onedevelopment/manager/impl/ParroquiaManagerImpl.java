package org.onedevelopment.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.onedevelopment.dao.api.ParroquiaDAO;
import org.onedevelopment.manager.api.ParroquiaManager;
import org.onedevelopment.model.Canton;
import org.onedevelopment.model.Parroquia;
import org.onedevelopment.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("parroquiaManager")
@Transactional
public class ParroquiaManagerImpl extends
		GenericManagerImpl<Parroquia, Integer> implements ParroquiaManager {

	private ParroquiaDAO parroquiaDao;

	@Autowired
	public void setParroquiaDAO(final ParroquiaDAO parroquiaDao) {
		this.dao = parroquiaDao;
		this.parroquiaDao = parroquiaDao;
	}

	@Override
	public List<Parroquia> findByName(String name) {
		return parroquiaDao.findByName(name);
	}

	public List<Parroquia> getParroquia() {
		return parroquiaDao.getAll();
	}

	@Override
	public List<Parroquia> findByCantonId(int cantonId) {
		return parroquiaDao.findByCantonId(cantonId);
	}

}
