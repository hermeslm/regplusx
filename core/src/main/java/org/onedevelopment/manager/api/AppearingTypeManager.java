package org.onedevelopment.manager.api;

import java.util.List;

import org.appfuse.service.GenericManager;
import org.onedevelopment.model.AppearingType;

public interface AppearingTypeManager extends GenericManager<AppearingType, Integer> {

	List<AppearingType> findByName(String name);

}
