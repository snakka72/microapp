package com.git.gitapp;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.git.*")
@SpringBootApplication
@EnableAutoConfiguration
public class GitappApplication extends  SpringBootServletInitializer{
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GitappApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(GitappApplication.class, args);
		
		 Map<String, String> env = System.getenv();
	        for (String envName : env.keySet()) {
	            //System.out.format("%s=%s%n", envName, env.get(envName));
	            //System.out.println("************************************************************************ " );
	            //String testSchedule = System.getenv("SCHEDULERTEST");
	    		//System.out.println("testSchedule from manifest: " +testSchedule);
	        }
	}
}
