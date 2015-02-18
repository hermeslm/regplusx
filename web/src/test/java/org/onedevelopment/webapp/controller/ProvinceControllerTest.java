package org.onedevelopment.webapp.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.onedevelopment.webapp.controller.main.ProvinceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

public class ProvinceControllerTest extends BaseControllerTestCase {

	@Autowired
	private ProvinceController controller;

	@Test
	public void testHandleRequest() throws Exception {
		ModelAndView mav = controller.handleRequest();
		ModelMap m = mav.getModelMap();
		assertNotNull(m.get("provinceList"));
		assertTrue(((List) m.get("provinceList")).size() > 0);
	}

}
