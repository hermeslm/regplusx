package org.onedevelopment.manager.api;

import java.util.List;

import org.appfuse.service.GenericManager;
import org.onedevelopment.model.Book;

public interface BookManager extends GenericManager<Book, Integer> {

	List<Book> findByName(String name);

}
