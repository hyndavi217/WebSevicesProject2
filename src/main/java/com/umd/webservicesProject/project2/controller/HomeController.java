package com.umd.webservicesProject.project2.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.umd.webservicesProject.project2.model.User;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String showHomePage(Model model) {
		User user= new User();
		List<String> arrayList= Arrays.asList("service 1","service 2");
		List<String> services= new ArrayList();
		services.addAll(arrayList);
		
		 model.addAttribute("user", user);
		    model.addAttribute("services", services);
		return "form";
	}

}
