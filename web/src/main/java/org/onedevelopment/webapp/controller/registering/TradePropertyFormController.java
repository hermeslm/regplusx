package org.onedevelopment.webapp.controller.registering;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.onedevelopment.manager.api.AgreementTypeManager;
import org.onedevelopment.manager.api.PurchaserTypeManager;
import org.onedevelopment.manager.api.StateManager;
import org.onedevelopment.manager.api.TradePropertyManager;
import org.onedevelopment.model.AgreementType;
import org.onedevelopment.model.PurchaserType;
import org.onedevelopment.model.State;
import org.onedevelopment.model.TradeProperty;
import org.onedevelopment.webapp.controller.BaseFormController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("registering/tradepropertyform*")
public class TradePropertyFormController extends BaseFormController {

	private TradePropertyManager tradePropertyManager = null;
	private StateManager stateManager = null;
	private AgreementTypeManager agreementTypeManager = null;
	private PurchaserTypeManager purchaserTypeManager = null;

	@Autowired
	public void setTradePropertyManager(
			TradePropertyManager tradePropertyManager) {
		this.tradePropertyManager = tradePropertyManager;
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
	 * @param agreementTypeManager
	 *            the agreementTypeManager to set
	 */
	@Autowired
	public void setAgreementTypeManager(
			AgreementTypeManager agreementTypeManager) {
		this.agreementTypeManager = agreementTypeManager;
	}

	/**
	 * @param purchaserTypeManager
	 *            the purchaserTypeManager to set
	 */
	@Autowired
	public void setPurchaserTypeManager(
			PurchaserTypeManager purchaserTypeManager) {
		this.purchaserTypeManager = purchaserTypeManager;
	}

	public TradePropertyFormController() {
		setCancelView("redirect:tradeproperty");
		setSuccessView("redirect:tradeproperty");
	}

	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	public TradeProperty showForm(HttpServletRequest request, ModelMap map)
			throws Exception {
		String id = request.getParameter("id");

		List<State> states = stateManager.getAll();
		List<AgreementType> agreementTypes = agreementTypeManager.getAll();
		List<PurchaserType> purchaserTypes = purchaserTypeManager.getAll();
		map.addAttribute("stateList", states);
		map.addAttribute("agreementTypeList", agreementTypes);
		map.addAttribute("purchaserTypeList", purchaserTypes);

		if (!StringUtils.isBlank(id)) {
			return tradePropertyManager.get(new Integer(id));
		}

		return new TradeProperty();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(TradeProperty tradeProperty, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getParameter("cancel") != null) {
			return getCancelView();
		}

		if (getValidator() != null) { // validator is null during testing
			getValidator().validate(tradeProperty, errors);

			if (errors.hasErrors() && request.getParameter("delete") == null) { // don't
																				// validate
																				// when
																				// deleting
				Logger.getLogger(TradePropertyFormController.class.getName())
						.log(Level.ERROR, "Erros: " + errors.toString());

				return "registering/tradepropertyform";
			}
		}

		log.debug("entering 'onSubmit' method...");

		boolean isNew = (tradeProperty.getId() == null);
		String success = getSuccessView();
		Locale locale = request.getLocale();

		if (request.getParameter("delete") != null) {
			tradePropertyManager.remove(tradeProperty.getId());
			saveMessage(request, getText("tradeProperty.deleted", locale));
		} else {
			tradePropertyManager.save(tradeProperty);
			String key = (isNew) ? "tradeProperty.added"
					: "tradeProperty.updated";
			saveMessage(request, getText(key, locale));

			if (!isNew) {
				success = "redirect:tradepropertyform?id="
						+ tradeProperty.getId();
			}
		}

		return success;
	}

}
