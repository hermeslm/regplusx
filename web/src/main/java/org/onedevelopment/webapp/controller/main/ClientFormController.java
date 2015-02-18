package org.onedevelopment.webapp.controller.main;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.onedevelopment.manager.api.CantonManager;
import org.onedevelopment.manager.api.ClientManager;
import org.onedevelopment.manager.api.ParroquiaManager;
import org.onedevelopment.manager.api.ProvinceManager;
import org.onedevelopment.model.Canton;
import org.onedevelopment.model.Client;
import org.onedevelopment.model.Parroquia;
import org.onedevelopment.model.Province;
import org.onedevelopment.webapp.controller.BaseFormController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/main/clientform*")
public class ClientFormController extends BaseFormController {

	private CantonManager cantonManager = null;
	private ParroquiaManager parroquiaManager = null;
	private ClientManager clientManager = null;
	private ProvinceManager provinceManager = null;

	@Autowired
	public void setCantonManager(CantonManager cantonManager) {
		this.cantonManager = cantonManager;
	}

	@Autowired
	public void setParroquiaManager(ParroquiaManager parroquiaManager) {
		this.parroquiaManager = parroquiaManager;
	}

	@Autowired
	public void setClientManager(ClientManager clientManager) {
		this.clientManager = clientManager;
	}

	@Autowired
	public void setProvinceManager(ProvinceManager provinceManager) {
		this.provinceManager = provinceManager;
	}

	public ClientFormController() {
		setCancelView("redirect:client");
		setSuccessView("redirect:client");
	}

	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	protected Client showForm(HttpServletRequest request, ModelMap map)
			throws Exception {
		String id = request.getParameter("id");

		List<Province> provinces = provinceManager.getAll();
		map.addAttribute("provinceList", provinces);
		// List<Province> provinces = new Array;
		// map.addAttribute("provinceList", provinces);

		if (!StringUtils.isBlank(id)) {
			return clientManager.get(new Integer(id));
		}

		return new Client();
	}

	@RequestMapping(value = "/cantonsByProvince*", method = RequestMethod.GET)
	public @ResponseBody List<Canton> getCantons(
			@RequestParam(value = "provinceId", required = true) int provinceId) {

		List<Canton> cantons = cantonManager.findByProvinceId(provinceId);

		return cantons;
	}

	@RequestMapping(value = "/parroquiasByCanton*", method = RequestMethod.GET)
	public @ResponseBody List<Parroquia> getParroquias(
			@RequestParam(value = "cantonId", required = true) int cantonId) {

		List<Parroquia> parroquias = parroquiaManager.findByCantonId(cantonId);

		return parroquias;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Client client, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getParameter("cancel") != null) {
			return getCancelView();
		}

		if (getValidator() != null) { // validator is null during testing
			getValidator().validate(client, errors);

			if (errors.hasErrors() && request.getParameter("delete") == null) { // don't
																				// validate
																				// when
																				// deleting
				return "clientform";
			}
		}

		log.debug("entering 'onSubmit' method...");

		boolean isNew = (client.getId() == null);
		String success = getSuccessView();
		Locale locale = request.getLocale();

		if (request.getParameter("delete") != null) {
			clientManager.remove(client.getId());
			saveMessage(request, getText("client.deleted", locale));
		} else {
			// Province province = new Province();
			// province.setId(Integer.parseInt(request.getParameter("province.id")));
			// canton.setProvince(province);
			clientManager.save(client);
			String key = (isNew) ? "canton.added" : "canton.updated";
			saveMessage(request, getText(key, locale));

			if (!isNew) {
				success = "redirect:clientform?id=" + client.getId();
			}
		}

		return success;
	}

}
