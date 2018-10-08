package com.git.gitapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan("com.git.*")
@SpringBootApplication

@EnableAutoConfiguration
public class GitappApplication extends  SpringBootServletInitializer  {

	
	
	public static void main(String[] args) {
		SpringApplication.run(GitappApplication.class, args);
		
		/*String testSchedule = System.getenv("SCHEDULERTEST");
		String testSchedule1 = System.getProperty("SCHEDULERTEST");
		System.out.println("testSchedule from manifest: " +testSchedule);
		System.out.println("testSchedule from app.properties: " +testSchedule1);
		
		String javaHome = System.getenv("PATH");
		System.out.println("testSchedule from JAVA_HOME: " +javaHome);*/
	}
}
