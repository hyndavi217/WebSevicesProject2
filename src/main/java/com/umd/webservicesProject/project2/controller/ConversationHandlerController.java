package com.umd.webservicesProject.project2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversationHandlerController {
	
	
	@GetMapping("/hello")
	public String sayHello() {
		return "form";
	}

}
