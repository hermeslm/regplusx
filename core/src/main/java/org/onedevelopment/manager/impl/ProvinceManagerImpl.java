package org.onedevelopment.manager.impl;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.onedevelopment.dao.api.ProvinceDAO;
import org.onedevelopment.manager.api.ProvinceManager;
import org.onedevelopment.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("provinceManager")
@Transactional
public class ProvinceManagerImpl extends GenericManagerImpl<Province, Integer>
		implements ProvinceManager {

	private ProvinceDAO provinceDao;

	@Autowired
	public void setProvinceDAO(final ProvinceDAO provinceDao) {
		this.dao = provinceDao;
		this.provinceDao = provinceDao;
	}

	@Override
	public List<Province> findByName(String name) {
		return provinceDao.findByName(name);
	}

	public List<Province> getProvince() {
		return provinceDao.getAll();
	}

}
