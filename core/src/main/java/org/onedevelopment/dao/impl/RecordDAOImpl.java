package org.onedevelopment.dao.impl;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.criterion.Restrictions;
import org.onedevelopment.dao.api.RecordDAO;
import org.onedevelopment.model.Record;
import org.springframework.stereotype.Repository;

@Repository("recordDao")
public class RecordDAOImpl extends GenericDaoHibernate<Record, Integer>
		implements RecordDAO {

	public RecordDAOImpl() {
		super(Record.class);
	}

	@Override
	public List<Record> findByRecord(Integer record) {

		return getSession().createCriteria(Record.class)
				.add(Restrictions.eq("record", record)).list();
	}

}
