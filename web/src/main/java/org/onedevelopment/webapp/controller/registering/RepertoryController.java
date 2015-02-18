package org.onedevelopment.webapp.controller.registering;

import java.util.List;

import org.onedevelopment.manager.api.RepertoryManager;
import org.onedevelopment.model.Repertory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("registering/repertory*")
public class RepertoryController {

	private RepertoryManager repertoryManager = null;

	@Autowired
	public void setRepertoryManager(RepertoryManager repertoryManager) {
		this.repertoryManager = repertoryManager;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception {

		List<Repertory> repertorys = repertoryManager.getAll();

		return new ModelAndView().addObject(repertorys);
	}

}
