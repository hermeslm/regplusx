package org.onedevelopment.dao.api;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.onedevelopment.model.Parroquia;

public interface ParroquiaDAO extends GenericDao<Parroquia, Integer> {

	public List<Parroquia> findByName(String Name);

	public List<Parroquia> findByCantonId(int cantonId);

}
