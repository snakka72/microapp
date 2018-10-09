package com.git.gitapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

	/*@Value("${SCHEDULERTEST}")
	String schedularTest;*/
	
	@Value("${sourcesite}")
	String sourcesite;
	
	@Value("${cloudsite}")
	String cloudsite;
	
	@Value("${spring.datasource.oracle.jdbc-url}")
	String dbsource;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap model) {
		
		//.getenv works for java SE
		String schedularTest = System.getenv("SCHEDULERTEST1"); 
		
		//.getProperty works for tomcat
		String schedularTest1 = System.getProperty("SCHEDULERTEST1");
		String schedularTest2 = System.getProperty("SCHEDULERTEST2");
		
		System.out.println("testSchedule from JAVA_HOME: " +schedularTest);
		
		System.out.println("test schedularTest1 from JAVA_HOME: " + schedularTest1);
		System.out.println("test schedularTest2 from JAVA_HOME: " + schedularTest2);
		
		
		System.out.println("SCHEDULERTEST inside HomeController");
		System.out.println("first Client");
		
		System.out.println("Server");
		/*System.out.println("second Client");
		System.out.println("second Client");
		System.out.println("second Client");*/
		
		//model.put("SCHEDULERTEST", schedularTest);
		
		model.put("SCHEDULERTEST1", schedularTest1);
		model.put("SCHEDULERTEST2", schedularTest2);
		
		model.put("sourcesite", sourcesite);
		model.put("cloudsite", cloudsite);
		model.put("dbsource", dbsource);

		model.put("JDBCURL", System.getenv("JDBCURL"));
		model.put("USERNAME", System.getenv("USERNAME"));
		model.put("PASSWORD", System.getenv("PASSWORD"));
		model.put("DRIVER", System.getenv("DRIVER"));	
		
	    System.out.println("JDBCURL: " + System.getenv("JDBCURL"));
	    System.out.println("USERNAME: " + System.getenv("USERNAME"));
	    System.out.println("PASSWORD: " + System.getenv("PASSWORD"));
	    System.out.println("DRIVER: " + System.getenv("DRIVER"));
	
				
		System.out.println("schedularTest..." +schedularTest);
	    
	    System.out.println("schedularTest 1..." +schedularTest1);
	    System.out.println("schedularTest 2..." +schedularTest2);
	    
		System.out.println("sourcesite..." +sourcesite);
		System.out.println("cloudsite..." +cloudsite);
		System.out.println("dbsource root..." +dbsource);
		/*System.out.println("second Client");
		System.out.println("second Client");
		System.out.println("second Client");*/
		
		
		
		return "index";
	}
}
