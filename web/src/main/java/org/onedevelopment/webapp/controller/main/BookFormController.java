package org.onedevelopment.webapp.controller.main;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.onedevelopment.manager.api.BookManager;
import org.onedevelopment.manager.api.BookTypeManager;
import org.onedevelopment.model.Book;
import org.onedevelopment.model.BookType;
import org.onedevelopment.model.Province;
import org.onedevelopment.webapp.controller.BaseFormController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("main/bookform*")
public class BookFormController extends BaseFormController {

	private BookManager bookManager = null;
	private BookTypeManager bookTypeManager = null;

	@Autowired
	public void setBookManager(BookManager bookManager) {
		this.bookManager = bookManager;
	}

	/**
	 * @param bookTypeManager the bookTypeManager to set
	 */
	@Autowired
	public void setBookTypeManager(BookTypeManager bookTypeManager) {
		this.bookTypeManager = bookTypeManager;
	}

	public BookFormController() {
		setCancelView("redirect:book");
		setSuccessView("redirect:book");
	}

	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	public Book showForm(HttpServletRequest request, ModelMap map)
			throws Exception {
		String id = request.getParameter("id");

		List<BookType> bookTypes = bookTypeManager.getAll();
		// map.addAttribute("employee", new EmployeeEntity());
		map.addAttribute("bookTypeList", bookTypes);

		if (!StringUtils.isBlank(id)) {
			return bookManager.get(new Integer(id));
		}

		return new Book();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Book book, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getParameter("cancel") != null) {
			return getCancelView();
		}

		if (getValidator() != null) { // validator is null during testing
			getValidator().validate(book, errors);

			if (errors.hasErrors() && request.getParameter("delete") == null) { // don't
																				// validate
																				// when
																				// deleting
				return "bookform";
			}
		}

		log.debug("entering 'onSubmit' method...");

		boolean isNew = (book.getId() == null);
		String success = getSuccessView();
		Locale locale = request.getLocale();

		if (request.getParameter("delete") != null) {
			bookManager.remove(book.getId());
			saveMessage(request, getText("book.deleted", locale));
		} else {
			bookManager.save(book);
			String key = (isNew) ? "book.added" : "book.updated";
			saveMessage(request, getText(key, locale));

			if (!isNew) {
				success = "redirect:bookform?id=" + book.getId();
			}
		}

		return success;
	}

}
