package com.luv2code.springdemo;

/**
 * application pour montrer l'intêret de l'IOC
 * L'application nous permet d'avoir le programme d'entrainnement quotidien fournit par un coach
 * ==> Exigences :
 * 1-) L'application doit permettre de facilement changer de coach pour un autre sport : résolu avec l'interface coach
 * 2-) l'application doit être configurable
 * @author douamas
 *
 */

public class MyApp {

	public static void main(String[] args) {
		
		// create the object
		//Coach theCoach = new BaseballCoach();
		Coach theCoach = new TrackCoach();
		
		
		//use the object
		System.out.println(theCoach.getDailyWorkout());
	}

}
