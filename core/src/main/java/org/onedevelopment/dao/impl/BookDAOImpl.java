package org.onedevelopment.dao.impl;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.criterion.Restrictions;
import org.onedevelopment.dao.api.BookDAO;
import org.onedevelopment.model.Book;
import org.springframework.stereotype.Repository;

@Repository("bookDao")
public class BookDAOImpl extends GenericDaoHibernate<Book, Integer> implements
		BookDAO {

	public BookDAOImpl() {
		super(Book.class);
	}

	@Override
	public List<Book> findByName(String name) {

		return getSession().createCriteria(Book.class)
				.add(Restrictions.eq("name", name)).list();
	}

}
