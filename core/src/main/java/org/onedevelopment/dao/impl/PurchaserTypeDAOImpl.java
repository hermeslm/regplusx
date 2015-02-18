package org.onedevelopment.dao.impl;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.criterion.Restrictions;
import org.onedevelopment.dao.api.PurchaserTypeDAO;
import org.onedevelopment.model.PurchaserType;
import org.springframework.stereotype.Repository;

@Repository("purchaserTypeDao")
public class PurchaserTypeDAOImpl extends GenericDaoHibernate<PurchaserType, Integer>
		implements PurchaserTypeDAO {

	public PurchaserTypeDAOImpl() {
		super(PurchaserType.class);
	}

	@Override
	public List<PurchaserType> findByName(String name) {

		return getSession().createCriteria(PurchaserType.class)
				.add(Restrictions.eq("name", name)).list();
	}

}
