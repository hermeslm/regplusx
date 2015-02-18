package org.onedevelopment.manager.api;

import java.util.List;

import org.appfuse.service.GenericManager;
import org.onedevelopment.model.BookType;

public interface BookTypeManager extends GenericManager<BookType, Integer> {

	List<BookType> findByName(String name);

}
