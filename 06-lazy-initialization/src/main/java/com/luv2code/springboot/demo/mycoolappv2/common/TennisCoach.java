package com.luv2code.springboot.demo.mycoolappv2.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	public TennisCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {

		return "TennisCoach: Practice your backhand volley";
	}

}
