package org.onedevelopment.manager.impl;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.onedevelopment.dao.api.VolumeDAO;
import org.onedevelopment.manager.api.VolumeManager;
import org.onedevelopment.model.Volume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("volumeManager")
@Transactional
public class VolumeManagerImpl extends GenericManagerImpl<Volume, Integer>
		implements VolumeManager {

	private VolumeDAO volumeDao;

	@Autowired
	public void setVolumeDAO(final VolumeDAO volumeDao) {
		this.dao = volumeDao;
		this.volumeDao = volumeDao;
	}

	@Override
	public List<Volume> findByName(String name) {
		return volumeDao.findByName(name);
	}

	public List<Volume> getVolume() {
		return volumeDao.getAll();
	}

}
