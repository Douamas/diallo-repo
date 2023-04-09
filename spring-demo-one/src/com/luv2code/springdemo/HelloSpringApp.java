package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		//1-) load the spring configuration file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2-) retrieve bean from spring container
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach theCoachB = context.getBean("myCoachB", Coach.class);
		
		//3-) call methods on the bean
		
		System.out.println("The Trackcoach says : " +theCoach.getDailyWorkout());
		System.out.println("The Baseballcoach says : " +theCoachB.getDailyWorkout());
		
		
		// let's call our new method for fortune
		System.out.println("The Baseballcoach says : " +theCoachB.getDailyFortune());
		System.out.println("The Trackcoach says : " +theCoach.getDailyFortune());
		
		
		//4-) close the context
		context.close();

	}

}
