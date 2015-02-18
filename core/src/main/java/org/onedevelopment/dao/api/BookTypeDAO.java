package org.onedevelopment.dao.api;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.onedevelopment.model.BookType;

public interface BookTypeDAO extends GenericDao<BookType, Integer> {

	public List<BookType> findByName(String Name);

}
