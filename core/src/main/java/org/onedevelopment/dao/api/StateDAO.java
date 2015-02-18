package org.onedevelopment.dao.api;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.onedevelopment.model.State;

public interface StateDAO extends GenericDao<State, Integer> {

	public List<State> findByName(String Name);

}
