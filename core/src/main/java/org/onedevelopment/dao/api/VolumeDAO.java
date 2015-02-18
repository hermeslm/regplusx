package org.onedevelopment.dao.api;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.onedevelopment.model.Volume;

public interface VolumeDAO extends GenericDao<Volume, Integer> {

	public List<Volume> findByName(String Name);

}
