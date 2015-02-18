package org.onedevelopment.dao.api;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.onedevelopment.model.AgreementType;

public interface AgreementTypeDAO extends GenericDao<AgreementType, Integer> {

	public List<AgreementType> findByName(String Name);

}
