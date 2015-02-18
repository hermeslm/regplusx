package org.onedevelopment.webapp.controller.main;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.onedevelopment.manager.api.VolumeManager;
import org.onedevelopment.model.Volume;
import org.onedevelopment.webapp.controller.BaseFormController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("main/volumeform*")
public class VolumeFormController extends BaseFormController {

	private VolumeManager volumeManager = null;

	@Autowired
	public void setVolumeManager(VolumeManager volumeManager) {
		this.volumeManager = volumeManager;
	}

	public VolumeFormController() {
		setCancelView("redirect:volume");
		setSuccessView("redirect:volume");
	}

	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	public Volume showForm(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");

		if (!StringUtils.isBlank(id)) {
			return volumeManager.get(new Integer(id));
		}

		return new Volume();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Volume volume, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getParameter("cancel") != null) {
			return getCancelView();
		}

		if (getValidator() != null) { // validator is null during testing
			getValidator().validate(volume, errors);

			if (errors.hasErrors() && request.getParameter("delete") == null) { // don't
																				// validate
																				// when
																				// deleting
				return "volumeform";
			}
		}

		log.debug("entering 'onSubmit' method...");

		boolean isNew = (volume.getId() == null);
		String success = getSuccessView();
		Locale locale = request.getLocale();

		if (request.getParameter("delete") != null) {
			volumeManager.remove(volume.getId());
			saveMessage(request, getText("volume.deleted", locale));
		} else {
			volumeManager.save(volume);
			String key = (isNew) ? "volume.added" : "volume.updated";
			saveMessage(request, getText(key, locale));

			if (!isNew) {
				success = "redirect:volumeform?id=" + volume.getId();
			}
		}

		return success;
	}

}
