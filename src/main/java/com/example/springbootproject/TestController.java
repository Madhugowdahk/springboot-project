package com.example.springbootproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
public class TestController {
	
	@RequestMapping("/test")
	public String firstHandler() {
		return "Hii world I can see you from here only.......................";
	}

}
