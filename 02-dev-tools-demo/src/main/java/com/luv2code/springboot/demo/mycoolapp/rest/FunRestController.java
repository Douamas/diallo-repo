package com.luv2code.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	
	// expose "/" that return "Hello World"
	@GetMapping("/")
	public String SayHello() {
		
		return "Hello BOuba  ... Time on server is "+ LocalDateTime.now();
	}
	
	// expose a new endpoint for "workout"
	@GetMapping("/workout")
	public String getDailyWorkout() {
		
		return "OKey Run a hard 5K ... ";
	}
	
	// expose a new endpoint for "fortune"
		@GetMapping("/fortune")
		public String getDailyfortune() {
			
			return "Okey Today is your lucky day  ... ";
		}
	

}
