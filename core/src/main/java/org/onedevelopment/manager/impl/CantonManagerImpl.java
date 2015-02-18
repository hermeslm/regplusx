package org.onedevelopment.manager.impl;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.onedevelopment.dao.api.CantonDAO;
import org.onedevelopment.manager.api.CantonManager;
import org.onedevelopment.model.Canton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cantonManager")
@Transactional
public class CantonManagerImpl extends GenericManagerImpl<Canton, Integer>
		implements CantonManager {

	private CantonDAO cantonDao;

	@Autowired
	public void setCantonDAO(final CantonDAO cantonDao) {
		this.dao = cantonDao;
		this.cantonDao = cantonDao;
	}

	@Override
	public List<Canton> findByName(String name) {
		return cantonDao.findByName(name);
	}

	public List<Canton> getCanton() {
		return cantonDao.getAll();
	}

	public List<Canton> getAllSorted(String sortFied) {
		return cantonDao.getAllSorted(sortFied);
	}

	@Override
	public List<Canton> findByProvinceId(int provinceId) {
		return cantonDao.findByProvinceId(provinceId);
	}

}
