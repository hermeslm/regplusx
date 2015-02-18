package org.onedevelopment.webapp.controller.main;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.onedevelopment.manager.api.ProvinceManager;
import org.onedevelopment.model.Province;
import org.onedevelopment.webapp.controller.BaseFormController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("main/provinceform*")
public class ProvinceFormController extends BaseFormController {

	private ProvinceManager provinceManager = null;

	@Autowired
	public void setProvinceManager(ProvinceManager provinceManager) {
		this.provinceManager = provinceManager;
	}

	public ProvinceFormController() {
		setCancelView("redirect:province");
		setSuccessView("redirect:province");
	}

	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	public Province showForm(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");

		if (!StringUtils.isBlank(id)) {
			return provinceManager.get(new Integer(id));
		}

		return new Province();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Province province, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getParameter("cancel") != null) {
			return getCancelView();
		}

		if (getValidator() != null) { // validator is null during testing
			getValidator().validate(province, errors);

			if (errors.hasErrors() && request.getParameter("delete") == null) { // don't
																				// validate
																				// when
																				// deleting
				return "provinceform";
			}
		}

		log.debug("entering 'onSubmit' method...");

		boolean isNew = (province.getId() == null);
		String success = getSuccessView();
		Locale locale = request.getLocale();

		if (request.getParameter("delete") != null) {
			provinceManager.remove(province.getId());
			saveMessage(request, getText("province.deleted", locale));
		} else {
			provinceManager.save(province);
			String key = (isNew) ? "province.added" : "province.updated";
			saveMessage(request, getText(key, locale));

			if (!isNew) {
				success = "redirect:provinceform?id=" + province.getId();
			}
		}

		return success;
	}

}
