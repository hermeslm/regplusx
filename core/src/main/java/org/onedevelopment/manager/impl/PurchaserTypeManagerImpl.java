package org.onedevelopment.manager.impl;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.onedevelopment.dao.api.PurchaserTypeDAO;
import org.onedevelopment.manager.api.PurchaserTypeManager;
import org.onedevelopment.model.PurchaserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("purchaserTypeManager")
@Transactional
public class PurchaserTypeManagerImpl extends GenericManagerImpl<PurchaserType, Integer>
		implements PurchaserTypeManager {

	private PurchaserTypeDAO purchaserTypeDao;

	@Autowired
	public void setPurchaserTypeDAO(final PurchaserTypeDAO purchaserTypeDao) {
		this.dao = purchaserTypeDao;
		this.purchaserTypeDao = purchaserTypeDao;
	}

	@Override
	public List<PurchaserType> findByName(String name) {
		return purchaserTypeDao.findByName(name);
	}

	public List<PurchaserType> getPurchaserType() {
		return purchaserTypeDao.getAll();
	}

}
