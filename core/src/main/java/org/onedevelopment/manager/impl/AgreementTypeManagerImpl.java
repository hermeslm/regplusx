package org.onedevelopment.manager.impl;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.onedevelopment.dao.api.AgreementTypeDAO;
import org.onedevelopment.manager.api.AgreementTypeManager;
import org.onedevelopment.model.AgreementType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("agreementTypeManager")
@Transactional
public class AgreementTypeManagerImpl extends GenericManagerImpl<AgreementType, Integer>
		implements AgreementTypeManager {

	private AgreementTypeDAO agreementTypeDao;

	@Autowired
	public void setAgreementTypeDAO(final AgreementTypeDAO agreementTypeDao) {
		this.dao = agreementTypeDao;
		this.agreementTypeDao = agreementTypeDao;
	}

	@Override
	public List<AgreementType> findByName(String name) {
		return agreementTypeDao.findByName(name);
	}

	public List<AgreementType> getAgreementType() {
		return agreementTypeDao.getAll();
	}

}
