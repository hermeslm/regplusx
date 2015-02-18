package org.onedevelopment.webapp.controller.main;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.onedevelopment.manager.api.AreaManager;
import org.onedevelopment.model.Area;
import org.onedevelopment.webapp.controller.BaseFormController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("main/areaform*")
public class AreaFormController extends BaseFormController {

	private AreaManager areaManager = null;

	@Autowired
	public void setAreaManager(AreaManager areaManager) {
		this.areaManager = areaManager;
	}

	public AreaFormController() {
		setCancelView("redirect:area");
		setSuccessView("redirect:area");
	}

	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	public Area showForm(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");

		if (!StringUtils.isBlank(id)) {
			return areaManager.get(new Integer(id));
		}

		return new Area();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Area area, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getParameter("cancel") != null) {
			return getCancelView();
		}

		if (getValidator() != null) { // validator is null during testing
			getValidator().validate(area, errors);

			if (errors.hasErrors() && request.getParameter("delete") == null) { // don't
																				// validate
																				// when
																				// deleting
				return "areaform";
			}
		}

		log.debug("entering 'onSubmit' method...");

		boolean isNew = (area.getId() == null);
		String success = getSuccessView();
		Locale locale = request.getLocale();

		if (request.getParameter("delete") != null) {
			areaManager.remove(area.getId());
			saveMessage(request, getText("area.deleted", locale));
		} else {
			areaManager.save(area);
			String key = (isNew) ? "area.added" : "area.updated";
			saveMessage(request, getText(key, locale));

			if (!isNew) {
				success = "redirect:areaform?id=" + area.getId();
			}
		}

		return success;
	}

}
