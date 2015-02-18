package org.onedevelopment.webapp.controller.main;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.appfuse.service.GenericManager;
import org.onedevelopment.model.Canton;
import org.onedevelopment.model.Parroquia;
import org.onedevelopment.webapp.controller.BaseFormController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("main/parroquiaform*")
public class ParroquiaFormController extends BaseFormController {

	private GenericManager<Canton, Integer> cantonManager = null;
	private GenericManager<Parroquia, Integer> parroquiaManager = null;

	@Autowired
	public void setCantonManager(
			@Qualifier("cantonManager") GenericManager<Canton, Integer> cantonManager) {
		this.cantonManager = cantonManager;
	}

	@Autowired
	public void setParroquiaManager(
			@Qualifier("parroquiaManager") GenericManager<Parroquia, Integer> parroquiaManager) {
		this.parroquiaManager = parroquiaManager;
	}

	public ParroquiaFormController() {
		setCancelView("redirect:parroquia");
		setSuccessView("redirect:parroquia");
	}

	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	protected Parroquia showForm(HttpServletRequest request, ModelMap map)
			throws Exception {
		String id = request.getParameter("id");

		List<Canton> cantons = cantonManager.getAll();
		// map.addAttribute("employee", new EmployeeEntity());
		map.addAttribute("cantonList", cantons);

		if (!StringUtils.isBlank(id)) {
			return parroquiaManager.get(new Integer(id));
		}

		return new Parroquia();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Parroquia parroquia, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getParameter("cancel") != null) {
			return getCancelView();
		}

		if (getValidator() != null) { // validator is null during testing
			getValidator().validate(parroquia, errors);

			if (errors.hasErrors() && request.getParameter("delete") == null) { // don't
																				// validate
																				// when
																				// deleting
				return "parroquiaform";
			}
		}

		log.debug("entering 'onSubmit' method...");

		boolean isNew = (parroquia.getId() == null);
		String success = getSuccessView();
		Locale locale = request.getLocale();

		if (request.getParameter("delete") != null) {
			parroquiaManager.remove(parroquia.getId());
			saveMessage(request, getText("parroquia.deleted", locale));
		} else {
			// Province province = new Province();
			// province.setId(Integer.parseInt(request.getParameter("province.id")));
			// canton.setProvince(province);
			parroquiaManager.save(parroquia);
			String key = (isNew) ? "canton.added" : "canton.updated";
			saveMessage(request, getText(key, locale));

			if (!isNew) {
				success = "redirect:parroquiaform?id=" + parroquia.getId();
			}
		}

		return success;
	}

}
