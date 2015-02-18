package org.onedevelopment.webapp.controller.registering;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.onedevelopment.manager.api.BookManager;
import org.onedevelopment.manager.api.ParroquiaManager;
import org.onedevelopment.manager.api.PropertyManager;
import org.onedevelopment.manager.api.RecordManager;
import org.onedevelopment.manager.api.StateManager;
import org.onedevelopment.model.Book;
import org.onedevelopment.model.Parroquia;
import org.onedevelopment.model.Property;
import org.onedevelopment.model.Record;
import org.onedevelopment.model.State;
import org.onedevelopment.model.Year;
import org.onedevelopment.webapp.controller.BaseFormController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("registering/propertyform*")
public class PropertyFormController extends BaseFormController {

	public static Integer startYear = Integer.parseInt(ResourceBundle
			.getBundle("yearsconfig").getString("startYear"));
	public static Integer endYear = Integer.parseInt(ResourceBundle.getBundle(
			"yearsconfig").getString("endYear"));

	private PropertyManager propertyManager = null;
	private ParroquiaManager parroquiaManager = null;
	private RecordManager recordManager = null;
	private StateManager stateManager = null;
	private BookManager bookManager = null;

	@Autowired
	public void setPropertyManager(PropertyManager propertyManager) {
		this.propertyManager = propertyManager;
	}

	/**
	 * @param stateManager
	 *            the stateManager to set
	 */
	@Autowired
	public void setStateManager(StateManager stateManager) {
		this.stateManager = stateManager;
	}

	/**
	 * @param bookManager
	 *            the bookManager to set
	 */
	@Autowired
	public void setBookManager(BookManager bookManager) {
		this.bookManager = bookManager;
	}

	/**
	 * @param parroquiaManager the parroquiaManager to set
	 */
	@Autowired
	public void setParroquiaManager(ParroquiaManager parroquiaManager) {
		this.parroquiaManager = parroquiaManager;
	}

	/**
	 * @param recordManager the recordManager to set
	 */
	@Autowired
	public void setRecordManager(RecordManager recordManager) {
		this.recordManager = recordManager;
	}

	private List<Year> getYears() {

		List<Year> years = new ArrayList<Year>();
		for (int i = startYear; i < endYear; i++) {
			Year year = new Year();
			year.setId(i);
			year.setName(String.valueOf(i));
			years.add(year);
		}
		return years;
	}

	public PropertyFormController() {
		setCancelView("redirect:property");
		setSuccessView("redirect:property");
	}

	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	public Property showForm(HttpServletRequest request, ModelMap map)
			throws Exception {
		String id = request.getParameter("id");

		List<Year> years = getYears();
		List<State> states = stateManager.getAll();
		List<Book> books = bookManager.getAll();
		List<Parroquia> parroquias = parroquiaManager.getAll();
		List<Record> records = recordManager.getAll();
		map.addAttribute("yearList", years);
		map.addAttribute("stateList", states);
		map.addAttribute("bookList", books);
		map.addAttribute("recordList", records);
		map.addAttribute("parroquiaList", parroquias);

		if (!StringUtils.isBlank(id)) {
			return propertyManager.get(new Integer(id));
		}

		return new Property();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Property property, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getParameter("cancel") != null) {
			return getCancelView();
		}

		if (getValidator() != null) { // validator is null during testing
			getValidator().validate(property, errors);

			if (errors.hasErrors() && request.getParameter("delete") == null) { // don't
																				// validate
																				// when
																				// deleting
				Logger.getLogger(PropertyFormController.class.getName()).log(
						Level.ERROR, "Erros: " + errors.toString());

				return "registering/propertyform";
			}
		}

		log.debug("entering 'onSubmit' method...");

		boolean isNew = (property.getId() == null);
		String success = getSuccessView();
		Locale locale = request.getLocale();
		
		if (request.getParameter("delete") != null) {
			propertyManager.remove(property.getId());
			saveMessage(request, getText("property.deleted", locale));
		} else {
			propertyManager.save(property);
			String key = (isNew) ? "property.added" : "property.updated";
			saveMessage(request, getText(key, locale));

			if (!isNew) {
				success = "redirect:propertyform?id=" + property.getId();
			}
		}

		return success;
	}

}
