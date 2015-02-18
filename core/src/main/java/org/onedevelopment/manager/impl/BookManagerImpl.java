package org.onedevelopment.manager.impl;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.onedevelopment.dao.api.BookDAO;
import org.onedevelopment.manager.api.BookManager;
import org.onedevelopment.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookManager")
@Transactional
public class BookManagerImpl extends GenericManagerImpl<Book, Integer>
		implements BookManager {

	private BookDAO bookTypeDao;

	@Autowired
	public void setBookDAO(final BookDAO bookTypeDao) {
		this.dao = bookTypeDao;
		this.bookTypeDao = bookTypeDao;
	}

	@Override
	public List<Book> findByName(String name) {
		return bookTypeDao.findByName(name);
	}

	public List<Book> getBook() {
		return bookTypeDao.getAll();
	}

}
