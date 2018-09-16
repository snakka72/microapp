package com.git.gitapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Value("${SCHEDULERTEST}")
	String schedularTest;
	
	@Value("${sourcesite}")
	String sourcesite;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap model) {
		
		System.out.println("SCHEDULERTEST inside HomeController");
		
	
				model.put("SCHEDULERTEST", schedularTest);
				model.put("sourcesite", sourcesite);
				
		System.out.println("root..." +schedularTest);
		System.out.println("root..." +sourcesite);
		return "index";
	}
}
