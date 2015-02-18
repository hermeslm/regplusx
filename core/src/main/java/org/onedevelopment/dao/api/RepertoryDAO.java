package org.onedevelopment.dao.api;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.onedevelopment.model.Repertory;

public interface RepertoryDAO extends GenericDao<Repertory, Integer> {

	public List<Repertory> findByName(String repertory);

	public List<Repertory> getAllSorted(String sortFied);

}
