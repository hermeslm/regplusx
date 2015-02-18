package org.onedevelopment.manager.impl;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.onedevelopment.dao.api.AreaDAO;
import org.onedevelopment.manager.api.AreaManager;
import org.onedevelopment.model.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("areaManager")
@Transactional
public class AreaManagerImpl extends GenericManagerImpl<Area, Integer>
		implements AreaManager {

	private AreaDAO areaDao;

	@Autowired
	public void setAreaDAO(final AreaDAO areaDao) {
		this.dao = areaDao;
		this.areaDao = areaDao;
	}

	@Override
	public List<Area> findByName(String name) {
		return areaDao.findByName(name);
	}

	public List<Area> getArea() {
		return areaDao.getAll();
	}

}
