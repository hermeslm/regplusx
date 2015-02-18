package org.onedevelopment.webapp.controller.registering;

import java.util.List;

import org.onedevelopment.manager.api.RecordTypeManager;
import org.onedevelopment.model.RecordType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("registering/recordtype*")
public class RecordTypeController {

	private RecordTypeManager recordTypeManager = null;

	@Autowired
	public void setRecordTypeManager(RecordTypeManager recordTypeManager) {
		this.recordTypeManager = recordTypeManager;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception {

		List<RecordType> recordTypes = recordTypeManager.getAll();

		return new ModelAndView().addObject(recordTypes);
	}

}
