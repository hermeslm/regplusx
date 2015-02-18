package org.onedevelopment.dao.api;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.onedevelopment.model.Book;

public interface BookDAO extends GenericDao<Book, Integer> {

	public List<Book> findByName(String Name);

}
