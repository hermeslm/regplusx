package org.onedevelopment.manager.api;

import java.util.List;

import org.appfuse.service.GenericManager;
import org.onedevelopment.model.AgreementType;

public interface AgreementTypeManager extends GenericManager<AgreementType, Integer> {

	List<AgreementType> findByName(String name);

}
