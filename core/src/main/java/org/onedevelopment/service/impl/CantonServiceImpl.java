package org.onedevelopment.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.appfuse.service.impl.GenericManagerImpl;
import org.onedevelopment.dao.api.CantonDAO;
import org.onedevelopment.model.Canton;
import org.onedevelopment.service.api.CantonService;
import org.springframework.beans.factory.annotation.Autowired;

@WebService(serviceName = "CantonService", endpointInterface = "org.onedevelopment.service.api.CantonManager")
public class CantonServiceImpl extends GenericManagerImpl<Canton, Integer>
		implements CantonService {

	private CantonDAO cantonDao;

	public CantonDAO getCantonDao() {
		return cantonDao;
	}

	public void setCantonDao(CantonDAO cantonDao) {
		this.cantonDao = cantonDao;
	}

	@Autowired
	public CantonServiceImpl(CantonDAO cantonDao) {
		super(cantonDao);
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
