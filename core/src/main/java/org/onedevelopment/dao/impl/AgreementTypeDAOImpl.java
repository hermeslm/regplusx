package org.onedevelopment.dao.impl;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.criterion.Restrictions;
import org.onedevelopment.dao.api.AgreementTypeDAO;
import org.onedevelopment.model.AgreementType;
import org.springframework.stereotype.Repository;

@Repository("agreementTypeDao")
public class AgreementTypeDAOImpl extends GenericDaoHibernate<AgreementType, Integer>
		implements AgreementTypeDAO {

	public AgreementTypeDAOImpl() {
		super(AgreementType.class);
	}

	@Override
	public List<AgreementType> findByName(String name) {

		return getSession().createCriteria(AgreementType.class)
				.add(Restrictions.eq("name", name)).list();
	}

}
