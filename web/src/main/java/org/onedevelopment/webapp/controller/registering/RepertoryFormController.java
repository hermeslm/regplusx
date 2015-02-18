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
import org.onedevelopment.manager.api.ClientManager;
import org.onedevelopment.manager.api.RecordManager;
import org.onedevelopment.manager.api.RepertoryManager;
import org.onedevelopment.manager.api.VolumeManager;
import org.onedevelopment.model.Book;
import org.onedevelopment.model.Client;
import org.onedevelopment.model.Record;
import org.onedevelopment.model.Repertory;
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
@RequestMapping("registering/repertoryform*")
public class RepertoryFormController extends BaseFormController {

	public static Integer startYear = Integer.parseInt(ResourceBundle
			.getBundle("yearsconfig").getString("startYear"));
	public static Integer endYear = Integer.parseInt(ResourceBundle.getBundle(
			"yearsconfig").getString("endYear"));

	private RepertoryManager repertoryManager = null;
	private ClientManager clientManager = null;
	private RecordManager recordManager = null;

	@Autowired
	public void setRepertoryManager(RepertoryManager repertoryManager) {
		this.repertoryManager = repertoryManager;
	}

	/**
	 * @param stateManager
	 *            the stateManager to set
	 */
	@Autowired
	public void setClientManager(ClientManager clientManager) {
		this.clientManager = clientManager;
	}

	/**
	 * @param bookManager
	 *            the bookManager to set
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

	public RepertoryFormController() {
		setCancelView("redirect:repertory");
		setSuccessView("redirect:repertory");
	}

	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	public Repertory showForm(HttpServletRequest request, ModelMap map)
			throws Exception {
		String id = request.getParameter("id");

		List<Year> years = getYears();
		List<Client> clients = clientManager.getAll();
		List<Record> records = recordManager.getAll();
		map.addAttribute("yearList", years);
		map.addAttribute("clientList", clients);
		map.addAttribute("recordList", records);

		if (!StringUtils.isBlank(id)) {
			return repertoryManager.get(new Integer(id));
		}

		return new Repertory();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Repertory repertory, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getParameter("cancel") != null) {
			return getCancelView();
		}

		if (getValidator() != null) { // validator is null during testing
			getValidator().validate(repertory, errors);

			if (errors.hasErrors() && request.getParameter("delete") == null) { // don't
																				// validate
																				// when
																				// deleting
				Logger.getLogger(RepertoryFormController.class.getName()).log(
						Level.ERROR, "Erros: " + errors.toString());

				return "registering/repertoryform";
			}
		}

		log.debug("entering 'onSubmit' method...");

		boolean isNew = (repertory.getId() == null);
		String success = getSuccessView();
		Locale locale = request.getLocale();

		// TODO Ponemos aqui este codigo para que funcione, pero tenemos que
		// borrarlo luego
		Record record = new Record();
		record.setId(1);
		repertory.setRecord(record);

		if (request.getParameter("delete") != null) {
			repertoryManager.remove(repertory.getId());
			saveMessage(request, getText("repertory.deleted", locale));
		} else {
			repertoryManager.save(repertory);
			String key = (isNew) ? "repertory.added" : "repertory.updated";
			saveMessage(request, getText(key, locale));

			if (!isNew) {
				success = "redirect:repertoryform?id=" + repertory.getId();
			}
		}

		return success;
	}

}
