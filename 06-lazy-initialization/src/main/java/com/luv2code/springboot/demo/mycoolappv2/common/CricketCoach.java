package com.luv2code.springboot.demo.mycoolappv2.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
	
	public CricketCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}



	@Override
	public String getDailyWorkout() {

		return "Practice fast bowling for 15 minutes";

	}

}
