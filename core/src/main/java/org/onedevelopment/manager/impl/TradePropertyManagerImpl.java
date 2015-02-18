package org.onedevelopment.manager.impl;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.onedevelopment.dao.api.TradePropertyDAO;
import org.onedevelopment.manager.api.TradePropertyManager;
import org.onedevelopment.model.TradeProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tradePropertyManager")
@Transactional
public class TradePropertyManagerImpl extends
		GenericManagerImpl<TradeProperty, Integer> implements
		TradePropertyManager {

	private TradePropertyDAO tradePropertyDao;

	@Autowired
	public void setTradePropertyDAO(final TradePropertyDAO tradeTradePropertyDao) {
		this.dao = tradeTradePropertyDao;
		this.tradePropertyDao = tradeTradePropertyDao;
	}

	public List<TradeProperty> getTradeProperty() {
		return tradePropertyDao.getAll();
	}

}
