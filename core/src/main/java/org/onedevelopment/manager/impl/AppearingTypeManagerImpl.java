package org.onedevelopment.manager.impl;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.onedevelopment.dao.api.AppearingTypeDAO;
import org.onedevelopment.manager.api.AppearingTypeManager;
import org.onedevelopment.model.AppearingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("appearingTypeManager")
@Transactional
public class AppearingTypeManagerImpl extends
		GenericManagerImpl<AppearingType, Integer> implements
		AppearingTypeManager {

	private AppearingTypeDAO appearingTypeDao;

	@Autowired
	public void setAppearingTypeDAO(final AppearingTypeDAO appearingTypeDao) {
		this.dao = appearingTypeDao;
		this.appearingTypeDao = appearingTypeDao;
	}

	@Override
	public List<AppearingType> findByName(String name) {
		return appearingTypeDao.findByName(name);
	}

	public List<AppearingType> getAppearingType() {
		return appearingTypeDao.getAll();
	}

}
