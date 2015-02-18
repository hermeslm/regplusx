package org.onedevelopment.manager.api;

import java.util.List;

import org.appfuse.service.GenericManager;
import org.onedevelopment.model.Province;

public interface ProvinceManager extends GenericManager<Province, Integer> {

	List<Province> findByName(String name);

}
