package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //il hérite de @component ==> sera dons détecté lors du scan du package
public class HomeController {
	
	@RequestMapping("/")
	public String showPage() {
		
		return "main-menu";
	}
	

}
