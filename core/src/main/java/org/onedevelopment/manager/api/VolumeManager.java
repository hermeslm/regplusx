package org.onedevelopment.manager.api;

import java.util.List;

import org.appfuse.service.GenericManager;
import org.onedevelopment.model.Volume;

public interface VolumeManager extends GenericManager<Volume, Integer> {

	List<Volume> findByName(String name);

}
