package org.onedevelopment.webapp.controller.main;

import org.onedevelopment.manager.api.ClientManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("main/client*")
public class ClientController {

	private ClientManager clientManager = null;

	@Autowired
	public void setClientManager(ClientManager clientManager) {
		this.clientManager = clientManager;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception {
		return new ModelAndView().addObject(clientManager.getAll());
	}

}
