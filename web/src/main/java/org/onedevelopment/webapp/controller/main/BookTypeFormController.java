package org.onedevelopment.webapp.controller.main;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.onedevelopment.manager.api.BookTypeManager;
import org.onedevelopment.model.BookType;
import org.onedevelopment.webapp.controller.BaseFormController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("main/booktypeform*")
public class BookTypeFormController extends BaseFormController {

	private BookTypeManager bookTypeManager = null;

	@Autowired
	public void setBookTypeManager(BookTypeManager bookTypeManager) {
		this.bookTypeManager = bookTypeManager;
	}

	public BookTypeFormController() {
		setCancelView("redirect:booktype");
		setSuccessView("redirect:booktype");
	}

	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	public BookType showForm(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");

		if (!StringUtils.isBlank(id)) {
			return bookTypeManager.get(new Integer(id));
		}

		return new BookType();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(BookType bookType, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getParameter("cancel") != null) {
			return getCancelView();
		}

		if (getValidator() != null) { // validator is null during testing
			getValidator().validate(bookType, errors);

			if (errors.hasErrors() && request.getParameter("delete") == null) { // don't
																				// validate
																				// when
																				// deleting
				return "bookTypeform";
			}
		}

		log.debug("entering 'onSubmit' method...");

		boolean isNew = (bookType.getId() == null);
		String success = getSuccessView();
		Locale locale = request.getLocale();

		if (request.getParameter("delete") != null) {
			bookTypeManager.remove(bookType.getId());
			saveMessage(request, getText("bookType.deleted", locale));
		} else {
			bookTypeManager.save(bookType);
			String key = (isNew) ? "bookType.added" : "bookType.updated";
			saveMessage(request, getText(key, locale));

			if (!isNew) {
				success = "redirect:bookTypeform?id=" + bookType.getId();
			}
		}

		return success;
	}

}
