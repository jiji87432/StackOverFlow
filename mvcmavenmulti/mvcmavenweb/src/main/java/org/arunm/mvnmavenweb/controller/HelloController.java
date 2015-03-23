package org.arunm.mvnmavenweb.controller;

import org.arunm.mvcmavendao.service.MvcMavenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
@RequestMapping("/welcome")
public class HelloController {
 
	@Autowired
	private MvcMavenService mavenService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		
		System.out.println("Value is " + mavenService.getMvcproperty());
		
		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";
 
	}
 
}