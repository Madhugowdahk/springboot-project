package com.example.springbootproject.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String home() {
		System.out.println("this is our home page");
		return "home";
	}
	
	@RequestMapping("/contact")
	public String homeContact() {
		System.out.println("this is our contact");
		return "contact";
	}

}
