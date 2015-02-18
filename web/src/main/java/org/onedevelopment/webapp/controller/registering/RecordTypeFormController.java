package org.onedevelopment.webapp.controller.registering;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.onedevelopment.manager.api.BookManager;
import org.onedevelopment.manager.api.RecordTypeManager;
import org.onedevelopment.model.Book;
import org.onedevelopment.model.RecordType;
import org.onedevelopment.webapp.controller.BaseFormController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("registering/recordtypeform*")
public class RecordTypeFormController extends BaseFormController {

	private RecordTypeManager recordTypeManager = null;
	private BookManager bookManager = null;

	@Autowired
	public void setRecordTypeManager(RecordTypeManager recordTypeManager) {
		this.recordTypeManager = recordTypeManager;
	}

	/**
	 * @param bookManager
	 *            the bookManager to set
	 */
	@Autowired
	public void setBookManager(BookManager bookManager) {
		this.bookManager = bookManager;
	}

	public RecordTypeFormController() {
		setCancelView("redirect:recordtype");
		setSuccessView("redirect:recordtype");
	}

	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	public RecordType showForm(HttpServletRequest request, ModelMap map)
			throws Exception {
		String id = request.getParameter("id");

		List<Book> books = bookManager.getAll();
		map.addAttribute("bookList", books);

		if (!StringUtils.isBlank(id)) {
			return recordTypeManager.get(new Integer(id));
		}

		return new RecordType();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(RecordType recordType, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getParameter("cancel") != null) {
			return getCancelView();
		}

		if (getValidator() != null) { // validator is null during testing
			getValidator().validate(recordType, errors);

			if (errors.hasErrors() && request.getParameter("delete") == null) { // don't
																				// validate
																				// when
																				// deleting
				return "recordtypeform";
			}
		}

		log.debug("entering 'onSubmit' method...");

		boolean isNew = (recordType.getId() == null);
		String success = getSuccessView();
		Locale locale = request.getLocale();

		if (request.getParameter("delete") != null) {
			recordTypeManager.remove(recordType.getId());
			saveMessage(request, getText("recordType.deleted", locale));
		} else {
			recordTypeManager.save(recordType);
			String key = (isNew) ? "recordType.added" : "recordType.updated";
			saveMessage(request, getText(key, locale));

			if (!isNew) {
				success = "redirect:recordtypeform?id=" + recordType.getId();
			}
		}

		return success;
	}

}
