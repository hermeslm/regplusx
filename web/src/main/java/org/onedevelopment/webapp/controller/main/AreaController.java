package org.onedevelopment.webapp.controller.main;

import java.util.List;

import org.onedevelopment.manager.api.AreaManager;
import org.onedevelopment.model.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("main/area*")
public class AreaController {

	private AreaManager areaManager = null;

	@Autowired
	public void setAreaManager(AreaManager areaManager) {
		this.areaManager = areaManager;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception {

		List<Area> areas = areaManager.getAll();

		return new ModelAndView().addObject(areas);
	}

}
