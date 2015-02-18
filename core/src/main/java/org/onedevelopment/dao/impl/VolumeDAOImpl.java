package org.onedevelopment.dao.impl;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.criterion.Restrictions;
import org.onedevelopment.dao.api.VolumeDAO;
import org.onedevelopment.model.Volume;
import org.springframework.stereotype.Repository;

@Repository("volumeDao")
public class VolumeDAOImpl extends GenericDaoHibernate<Volume, Integer>
		implements VolumeDAO {

	public VolumeDAOImpl() {
		super(Volume.class);
	}

	@Override
	public List<Volume> findByName(String name) {

		return getSession().createCriteria(Volume.class)
				.add(Restrictions.eq("name", name)).list();
	}

}
