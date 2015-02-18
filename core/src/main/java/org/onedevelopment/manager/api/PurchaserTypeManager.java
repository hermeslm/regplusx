package org.onedevelopment.manager.api;

import java.util.List;

import org.appfuse.service.GenericManager;
import org.onedevelopment.model.PurchaserType;

public interface PurchaserTypeManager extends GenericManager<PurchaserType, Integer> {

	List<PurchaserType> findByName(String name);

}
