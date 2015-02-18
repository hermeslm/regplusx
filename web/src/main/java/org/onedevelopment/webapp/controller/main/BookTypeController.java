package org.onedevelopment.webapp.controller.main;

import java.util.List;

import org.onedevelopment.manager.api.BookTypeManager;
import org.onedevelopment.model.BookType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("main/booktype*")
public class BookTypeController {

	private BookTypeManager bookTypeManager = null;

	@Autowired
	public void setBookTypeManager(BookTypeManager bookTypeManager) {
		this.bookTypeManager = bookTypeManager;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception {

		List<BookType> bookTypes = bookTypeManager.getAll();

		return new ModelAndView().addObject(bookTypes);
	}

}
