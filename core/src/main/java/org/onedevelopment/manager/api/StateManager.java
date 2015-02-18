package org.onedevelopment.manager.api;

import java.util.List;

import org.appfuse.service.GenericManager;
import org.onedevelopment.model.State;

public interface StateManager extends GenericManager<State, Integer> {

	List<State> findByName(String name);

}
