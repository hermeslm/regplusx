package org.onedevelopment.webapp.controller.main;

import java.util.List;

import org.onedevelopment.manager.api.VolumeManager;
import org.onedevelopment.model.Volume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("main/volume*")
public class VolumeController {

	private VolumeManager volumeManager = null;

	@Autowired
	public void setVolumeManager(VolumeManager volumeManager) {
		this.volumeManager = volumeManager;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception {

		List<Volume> volumes = volumeManager.getAll();

		return new ModelAndView().addObject(volumes);
	}

}
