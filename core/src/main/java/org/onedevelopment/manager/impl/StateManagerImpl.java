package org.onedevelopment.manager.impl;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.onedevelopment.dao.api.StateDAO;
import org.onedevelopment.manager.api.StateManager;
import org.onedevelopment.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("stateManager")
@Transactional
public class StateManagerImpl extends GenericManagerImpl<State, Integer>
		implements StateManager {

	private StateDAO stateDao;

	@Autowired
	public void setStateDAO(final StateDAO stateDao) {
		this.dao = stateDao;
		this.stateDao = stateDao;
	}

	@Override
	public List<State> findByName(String name) {
		return stateDao.findByName(name);
	}

	public List<State> getState() {
		return stateDao.getAll();
	}

}
