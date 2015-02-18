package org.onedevelopment.webapp.controller.main;

import java.util.List;

import org.onedevelopment.manager.api.BookManager;
import org.onedevelopment.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("main/book*")
public class BookController {

	private BookManager bookManager = null;

	@Autowired
	public void setBookManager(BookManager bookManager) {
		this.bookManager = bookManager;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception {

		List<Book> bookTypes = bookManager.getAll();

		return new ModelAndView().addObject(bookTypes);
	}

}
