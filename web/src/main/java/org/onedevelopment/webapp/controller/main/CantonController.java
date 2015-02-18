package org.onedevelopment.webapp.controller.main;

import org.onedevelopment.manager.api.CantonManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("main/canton*")
public class CantonController {

	private CantonManager cantonManager = null;

	@Autowired
	public void setCantonManager(CantonManager cantonManager) {
		this.cantonManager = cantonManager;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception {
		return new ModelAndView().addObject(cantonManager.getAll());
	}

}
