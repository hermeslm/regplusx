package org.onedevelopment.webapp.controller.registering;

import java.util.List;

import org.onedevelopment.manager.api.PropertyManager;
import org.onedevelopment.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("registering/property*")
public class PropertyController {

	private PropertyManager propertyManager = null;

	@Autowired
	public void setPropertyManager(PropertyManager propertyManager) {
		this.propertyManager = propertyManager;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception {

		List<Property> propertys = propertyManager.getAll();

		return new ModelAndView().addObject(propertys);
	}

}
