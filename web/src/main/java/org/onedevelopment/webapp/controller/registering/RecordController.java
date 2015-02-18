package org.onedevelopment.webapp.controller.registering;

import java.util.List;

import org.onedevelopment.manager.api.RecordManager;
import org.onedevelopment.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("registering/record*")
public class RecordController {

	private RecordManager recordManager = null;

	@Autowired
	public void setRecordManager(RecordManager recordManager) {
		this.recordManager = recordManager;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception {

		List<Record> records = recordManager.getAll();

		return new ModelAndView().addObject(records);
	}

}
