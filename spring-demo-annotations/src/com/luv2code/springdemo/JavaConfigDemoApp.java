package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		

		//  read Spring config java class
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(SportConfig.class);
		
		
		// get the bean from spring container
		//Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call the method to the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		
		// close the context
		context.close();
	}

}
