package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	
	// define a private field for the dependancy
		private FortuneService fortuneService;
		
	// define a constructor for dependancy injection

		public TrackCoach(FortuneService fortuneService) {
			super();
			this.fortuneService = fortuneService;
		}	
		
		


	public TrackCoach() {
			super();
			// TODO Auto-generated constructor stub
		}




	@Override
	public String getDailyWorkout() {

		return "Run a hard 5k";
	}


	@Override
	public String getDailyFortune() {
		
		return "Just Do it : "+ fortuneService.getFortune();
	}
	
	
	// add an init method
	
	public void doMyStartupStuff(){
		System.out.println("TrackCoach : inside method doMyStartupStuff");
	}	
	
	
	// add an destroy method
	public void doMyCleanupStuff(){
		System.out.println("TrackCoach : inside method doMyCleanupStuff");
	}	
	

}
