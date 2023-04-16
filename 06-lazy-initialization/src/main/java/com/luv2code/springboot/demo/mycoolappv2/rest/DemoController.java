package com.luv2code.springboot.demo.mycoolappv2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.demo.mycoolappv2.common.Coach;

@RestController
//@RequestMapping("/test1")
public class DemoController {

	// define a private field for the dependency

	private Coach myCoach;

	@Autowired
	public DemoController(@Qualifier("cricketCoach")Coach theCoach) {
		
		System.out.println("In constructor: " + getClass().getSimpleName());

		myCoach = theCoach;
	}

	@GetMapping("dailyworkout")
	public String getDailyWorkout() {

		return myCoach.getDailyWorkout();
	}
}
