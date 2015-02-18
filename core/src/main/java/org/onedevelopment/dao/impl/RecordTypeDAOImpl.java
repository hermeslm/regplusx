package org.onedevelopment.dao.impl;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.criterion.Restrictions;
import org.onedevelopment.dao.api.RecordTypeDAO;
import org.onedevelopment.model.RecordType;
import org.springframework.stereotype.Repository;

@Repository("recordTypeDao")
public class RecordTypeDAOImpl extends GenericDaoHibernate<RecordType, Integer>
		implements RecordTypeDAO {

	public RecordTypeDAOImpl() {
		super(RecordType.class);
	}

	@Override
	public List<RecordType> findByName(String descripcion) {

		return getSession().createCriteria(RecordType.class)
				.add(Restrictions.eq("descripcion", descripcion)).list();
	}

}
