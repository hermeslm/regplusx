package org.onedevelopment.webapp.controller.main;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.onedevelopment.manager.api.CantonManager;
import org.onedevelopment.manager.api.ProvinceManager;
import org.onedevelopment.model.Canton;
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
@RequestMapping("main/cantonform*")
public class CantonFormController extends BaseFormController {

	private CantonManager cantonManager = null;
	private ProvinceManager provinceManager = null;

	@Autowired
	public void setCantonManager(CantonManager cantonManager) {
		this.cantonManager = cantonManager;
	}

	@Autowired
	public void setProvinceManager(ProvinceManager provinceManager) {
		this.provinceManager = provinceManager;
	}

	public CantonFormController() {
		setCancelView("redirect:canton");
		setSuccessView("redirect:canton");
	}

	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	protected Canton showForm(HttpServletRequest request, ModelMap map)
			throws Exception {
		String id = request.getParameter("id");

		List<Province> provinces = provinceManager.getAll();
		// map.addAttribute("employee", new EmployeeEntity());
		map.addAttribute("provinceList", provinces);

		if (!StringUtils.isBlank(id)) {
			return cantonManager.get(new Integer(id));
		}

		return new Canton();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Canton canton, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getParameter("cancel") != null) {
			return getCancelView();
		}

		if (getValidator() != null) { // validator is null during testing
			getValidator().validate(canton, errors);

			if (errors.hasErrors() && request.getParameter("delete") == null) { // don't
																				// validate
																				// when
																				// deleting
				return "cantonform";
			}
		}

		log.debug("entering 'onSubmit' method...");

		boolean isNew = (canton.getId() == null);
		String success = getSuccessView();
		Locale locale = request.getLocale();

		if (request.getParameter("delete") != null) {
			cantonManager.remove(canton.getId());
			saveMessage(request, getText("canton.deleted", locale));
		} else {
			// Province province = new Province();
			// province.setId(Integer.parseInt(request.getParameter("province.id")));
			// canton.setProvince(province);
			cantonManager.save(canton);
			String key = (isNew) ? "canton.added" : "canton.updated";
			saveMessage(request, getText(key, locale));

			if (!isNew) {
				success = "redirect:cantonform?id=" + canton.getId();
			}
		}

		return success;
	}

}
