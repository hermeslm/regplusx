package org.onedevelopment.dao.impl;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.onedevelopment.dao.api.PropertyDAO;
import org.onedevelopment.model.Property;
import org.springframework.stereotype.Repository;

@Repository("propertyDao")
public class PropertyDAOImpl extends GenericDaoHibernate<Property, Integer>
		implements PropertyDAO {

	public PropertyDAOImpl() {
		super(Property.class);
	}

}
