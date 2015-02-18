package org.onedevelopment.dao.impl;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.criterion.Restrictions;
import org.onedevelopment.dao.api.BookTypeDAO;
import org.onedevelopment.model.BookType;
import org.springframework.stereotype.Repository;

@Repository("bookTypeDao")
public class BookTypeDAOImpl extends GenericDaoHibernate<BookType, Integer>
		implements BookTypeDAO {

	public BookTypeDAOImpl() {
		super(BookType.class);
	}

	@Override
	public List<BookType> findByName(String name) {

		return getSession().createCriteria(BookType.class)
				.add(Restrictions.eq("name", name)).list();
	}

}
