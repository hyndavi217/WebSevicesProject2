package com.umd.webservicesProject.project2;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
@ComponentScan(value = "com.umd.webservicesProject.project2.*")
public class Project2Application extends SpringBootServletInitializer {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(Project2Application.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Project2Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Project2Application.class, args);
		logger.info("******application just started!***");
	}

}
