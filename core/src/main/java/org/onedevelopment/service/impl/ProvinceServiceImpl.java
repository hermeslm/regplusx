package org.onedevelopment.service.impl;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.appfuse.dao.SearchException;
import org.appfuse.service.impl.GenericManagerImpl;
import org.onedevelopment.dao.api.ProvinceDAO;
import org.onedevelopment.model.Province;

@WebService(serviceName = "ProvinceService", endpointInterface = "org.onedevelopment.dao.api.ProvinceDAO")
public class ProvinceServiceImpl extends GenericManagerImpl<Province, Integer>
		implements ProvinceDAO {

	public ProvinceServiceImpl() {
	}

	private ProvinceDAO provinceDao;

	public ProvinceServiceImpl(ProvinceDAO provinceDao) {
		super(provinceDao);
		this.provinceDao = provinceDao;
	}

	@Override
	public List<Province> findByName(String name) {
		return provinceDao.findByName(name);
	}

	public List<Province> getProvince() {
		return provinceDao.getAll();
	}

	@Override
	public List<Province> findByNamedQuery(String arg0, Map<String, Object> arg1) {
		return null;
	}

	@Override
	public List<Province> getAllDistinct() {
		return provinceDao.getAllDistinct();
	}

	@Override
	public List<Province> search(String arg0) throws SearchException {
		return null;
	}

}
