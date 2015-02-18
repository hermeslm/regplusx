package org.onedevelopment.dao.impl;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.onedevelopment.dao.api.TradePropertyDAO;
import org.onedevelopment.model.TradeProperty;
import org.springframework.stereotype.Repository;

@Repository("treadeTradePropertyDao")
public class TradePropertyDAOImpl extends
		GenericDaoHibernate<TradeProperty, Integer> implements TradePropertyDAO {

	public TradePropertyDAOImpl() {
		super(TradeProperty.class);
	}

	@Override
	public List<TradeProperty> getAllSorted(String sortFied) {
		return null;
	}

}
