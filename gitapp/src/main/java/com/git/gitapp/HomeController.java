package com.git.gitapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@Value("${SCHEDULERTEST}")
	String schedularTest;
	
	@Value("${sourcesite}")
	String sourcesite;
	
	@Value("${cloudsite}")
	String cloudsite;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap model) {
		
		System.out.println("SCHEDULERTEST inside HomeController");
		System.out.println("first Client");
		
		System.out.println("Server");
	
		model.put("SCHEDULERTEST", schedularTest);
		model.put("sourcesite", sourcesite);
		model.put("cloudsite", cloudsite);
				
		System.out.println("root..." +schedularTest);
		System.out.println("root..." +sourcesite);
		System.out.println("root..." +cloudsite);
		System.out.println("second Client");
		
		return "index";
	}
}
