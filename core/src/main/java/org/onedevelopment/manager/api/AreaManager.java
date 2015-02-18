package org.onedevelopment.manager.api;

import java.util.List;

import org.appfuse.service.GenericManager;
import org.onedevelopment.model.Area;

public interface AreaManager extends GenericManager<Area, Integer> {

	List<Area> findByName(String name);

}
