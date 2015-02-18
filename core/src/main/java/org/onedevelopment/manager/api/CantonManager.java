package org.onedevelopment.manager.api;

import java.util.List;

import org.appfuse.service.GenericManager;
import org.onedevelopment.model.Canton;

public interface CantonManager extends GenericManager<Canton, Integer> {

	List<Canton> findByName(String name);

	List<Canton> findByProvinceId(int provinceId);

	List<Canton> getCanton();

}
