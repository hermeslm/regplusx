package org.onedevelopment.webapp.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.onedevelopment.model.Province;
import org.onedevelopment.webapp.controller.main.ProvinceFormController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

public class ProvinceFormControllerTest extends BaseControllerTestCase {

	@Autowired
	private ProvinceFormController form;
	private Province province;
	private MockHttpServletRequest request;

	@Test
	public void testEdit() throws Exception {
		log.debug("testing edit...");
		request = newGet("/provinceform");
		request.addParameter("id", "1");

		province = form.showForm(request);
		assertNotNull(province);
	}

	@Test
	public void testSave() throws Exception {
		request = newGet("/provinceform");
		request.addParameter("id", "1");

		province = form.showForm(request);
		assertNotNull(province);

		request = newPost("/provinceform");

		province = form.showForm(request);
		// update required fields
		province.setName("Homer");

		BindingResult errors = new DataBinder(province).getBindingResult();
		form.onSubmit(province, errors, request, new MockHttpServletResponse());
		assertFalse(errors.hasErrors());
		assertNotNull(request.getSession().getAttribute("successMessages"));
	}

	@Test
	public void testRemove() throws Exception {
		request = newPost("/provinceform");
		request.addParameter("delete", "");
		province = new Province();
		province.setId(1);

		BindingResult errors = new DataBinder(province).getBindingResult();
		form.onSubmit(province, errors, request, new MockHttpServletResponse());

		assertNotNull(request.getSession().getAttribute("successMessages"));
	}

}
