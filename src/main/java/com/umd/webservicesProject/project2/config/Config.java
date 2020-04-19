package com.umd.webservicesProject.project2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.umd.webservicesProject.project2.constants.ConstantsClass;
import com.umd.webservicesProject.project2.model.FinalResponeObject;
import com.umd.webservicesProject.project2.model.UserAcceptRequestObject;

@Configuration
public class Config {
	
	@Bean
	public UserAcceptRequestObject userAcceptRequestObject() {
		return new UserAcceptRequestObject();
	}
	

	@Bean
	public FinalResponeObject finalResponeObject() {
		return new FinalResponeObject();
	}
	
	
}
