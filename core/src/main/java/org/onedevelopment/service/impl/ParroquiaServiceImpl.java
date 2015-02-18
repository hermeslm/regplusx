package org.onedevelopment.service.impl;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.appfuse.dao.SearchException;
import org.appfuse.service.impl.GenericManagerImpl;
import org.onedevelopment.dao.api.ParroquiaDAO;
import org.onedevelopment.model.Parroquia;

@WebService(serviceName = "ParroquiaService", endpointInterface = "org.onedevelopment.dao.api.ParroquiaDAO")
public class ParroquiaServiceImpl extends GenericManagerImpl<Parroquia, Integer>
		implements ParroquiaDAO {

	public ParroquiaServiceImpl() {
	}

	private ParroquiaDAO parroquiaDao;

	public ParroquiaServiceImpl(ParroquiaDAO parroquiaDao) {
		super(parroquiaDao);
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
	public List<Parroquia> findByNamedQuery(String arg0, Map<String, Object> arg1) {
		return null;
	}

	@Override
	public List<Parroquia> getAllDistinct() {
		return null;
	}

	@Override
	public List<Parroquia> search(String arg0) throws SearchException {
		return null;
	}

	@Override
	public List<Parroquia> findByCantonId(int cantonId) {
		// TODO Auto-generated method stub
		return null;
	}

}
