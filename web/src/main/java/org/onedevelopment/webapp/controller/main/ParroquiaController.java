package org.onedevelopment.webapp.controller.main;

import org.onedevelopment.manager.api.ParroquiaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("main/parroquia*")
public class ParroquiaController {

	private ParroquiaManager parroquiaManager = null;

	@Autowired
	public void setParroquiaManager(ParroquiaManager parroquiaManager) {
		this.parroquiaManager = parroquiaManager;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception {
		return new ModelAndView().addObject(parroquiaManager.getAll());
	}

}
