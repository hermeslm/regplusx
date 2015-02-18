package org.onedevelopment.webapp.controller.registering;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.onedevelopment.manager.api.BookManager;
import org.onedevelopment.manager.api.RecordManager;
import org.onedevelopment.manager.api.StateManager;
import org.onedevelopment.manager.api.VolumeManager;
import org.onedevelopment.model.Book;
import org.onedevelopment.model.Record;
import org.onedevelopment.model.State;
import org.onedevelopment.model.Volume;
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
@RequestMapping("registering/recordform*")
public class RecordFormController extends BaseFormController {

	public static Integer startYear = Integer.parseInt(ResourceBundle
			.getBundle("yearsconfig").getString("startYear"));
	public static Integer endYear = Integer.parseInt(ResourceBundle.getBundle(
			"yearsconfig").getString("endYear"));

	private RecordManager recordManager = null;
	private StateManager stateManager = null;
	private BookManager bookManager = null;
	private VolumeManager volumeManager = null;

	@Autowired
	public void setRecordManager(RecordManager recordManager) {
		this.recordManager = recordManager;
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
	 * @param volumeManager
	 *            the volumeManager to set
	 */
	@Autowired
	public void setVolumeManager(VolumeManager volumeManager) {
		this.volumeManager = volumeManager;
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

	public RecordFormController() {
		setCancelView("redirect:record");
		setSuccessView("redirect:record");
	}

	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	public Record showForm(HttpServletRequest request, ModelMap map)
			throws Exception {
		String id = request.getParameter("id");

		List<Year> years = getYears();
		List<State> states = stateManager.getAll();
		List<Book> books = bookManager.getAll();
		List<Volume> volumes = volumeManager.getAll();
		map.addAttribute("yearList", years);
		map.addAttribute("stateList", states);
		map.addAttribute("bookList", books);
		map.addAttribute("volumeList", volumes);

		if (!StringUtils.isBlank(id)) {
			return recordManager.get(new Integer(id));
		}

		return new Record();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Record record, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getParameter("cancel") != null) {
			return getCancelView();
		}

		if (getValidator() != null) { // validator is null during testing
			getValidator().validate(record, errors);

			if (errors.hasErrors() && request.getParameter("delete") == null) { // don't
																				// validate
																				// when
																				// deleting
				return "recordform";
			}
		}

		log.debug("entering 'onSubmit' method...");

		boolean isNew = (record.getId() == null);
		String success = getSuccessView();
		Locale locale = request.getLocale();

		if (request.getParameter("delete") != null) {
			recordManager.remove(record.getId());
			saveMessage(request, getText("record.deleted", locale));
		} else {
			recordManager.save(record);
			String key = (isNew) ? "record.added" : "record.updated";
			saveMessage(request, getText(key, locale));

			if (!isNew) {
				success = "redirect:recordform?id=" + record.getId();
			}
		}

		return success;
	}

}
