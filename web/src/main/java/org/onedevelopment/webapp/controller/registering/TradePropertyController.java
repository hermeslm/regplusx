package org.onedevelopment.webapp.controller.registering;

import java.util.List;

import org.onedevelopment.manager.api.TradePropertyManager;
import org.onedevelopment.model.TradeProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("registering/tradeproperty*")
public class TradePropertyController {

	private TradePropertyManager tradePropertyManager = null;

	@Autowired
	public void setTradePropertyManager(
			TradePropertyManager tradePropertyManager) {
		this.tradePropertyManager = tradePropertyManager;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception {

		List<TradeProperty> tradePropertys = tradePropertyManager.getAll();

		return new ModelAndView().addObject(tradePropertys);
	}

}
