package com.git.gitapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.git.*")
@SpringBootApplication
public class GitappApplication extends  SpringBootServletInitializer{
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GitappApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(GitappApplication.class, args);
	}
}
