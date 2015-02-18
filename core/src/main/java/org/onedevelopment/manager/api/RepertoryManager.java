package org.onedevelopment.manager.api;

import java.util.List;

import org.appfuse.service.GenericManager;
import org.onedevelopment.model.Repertory;

public interface RepertoryManager extends GenericManager<Repertory, Integer> {

	List<Repertory> findByName(String repertory);

}
