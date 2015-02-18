package org.onedevelopment.manager.impl;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.onedevelopment.dao.api.BookTypeDAO;
import org.onedevelopment.manager.api.BookTypeManager;
import org.onedevelopment.model.BookType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookTypeManager")
@Transactional
public class BookTypeManagerImpl extends GenericManagerImpl<BookType, Integer>
		implements BookTypeManager {

	private BookTypeDAO bookTypeDao;

	@Autowired
	public void setBookTypeDAO(final BookTypeDAO bookTypeDao) {
		this.dao = bookTypeDao;
		this.bookTypeDao = bookTypeDao;
	}

	@Override
	public List<BookType> findByName(String name) {
		return bookTypeDao.findByName(name);
	}

	public List<BookType> getBookType() {
		return bookTypeDao.getAll();
	}

}
