package org.onedevelopment.webapp.controller.main;

import java.util.List;

import org.onedevelopment.manager.api.ProvinceManager;
import org.onedevelopment.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("main/province*")
public class ProvinceController {

	private ProvinceManager provinceManager = null;

	@Autowired
	public void setProvinceManager(ProvinceManager provinceManager) {
		this.provinceManager = provinceManager;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception {

		List<Province> provinces = provinceManager.getAll();

		return new ModelAndView().addObject(provinces);
	}

}
