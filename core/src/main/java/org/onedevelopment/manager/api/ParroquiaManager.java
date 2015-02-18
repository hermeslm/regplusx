package org.onedevelopment.manager.api;

import java.util.List;

import org.appfuse.service.GenericManager;
import org.onedevelopment.model.Parroquia;

public interface ParroquiaManager extends GenericManager<Parroquia, Integer> {

	List<Parroquia> findByName(String name);

	List<Parroquia> findByCantonId(int cantonId);

}
