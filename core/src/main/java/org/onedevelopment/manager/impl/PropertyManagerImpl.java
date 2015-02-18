package org.onedevelopment.manager.impl;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.onedevelopment.dao.api.PropertyDAO;
import org.onedevelopment.manager.api.PropertyManager;
import org.onedevelopment.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("propertyManager")
@Transactional
public class PropertyManagerImpl extends GenericManagerImpl<Property, Integer>
		implements PropertyManager {

	private PropertyDAO propertyDao;

	@Autowired
	public void setPropertyDAO(final PropertyDAO propertyDao) {
		this.dao = propertyDao;
		this.propertyDao = propertyDao;
	}

	public List<Property> getProperty() {
		return propertyDao.getAll();
	}

}
