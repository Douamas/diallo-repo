/**
 * 
 */
package com.labs.java.demo;


 interface I { // FI
	
	void m(); // SAM

}


public class BasicLambdas {

	
	public static void main(String[] args) {
		
		// pre-Java 8
		I i = new I (){
			
			@Override
			public void m() {

				System.out.println("I::m()");
			}
			
		};
		
		i.m(); // print I::m()
		
		// Java 8 - Lambda Expression
		
		I lambdaI = ()-> {
			System.out.println("Lambda version");
		};
		
		I lambdaI2 = () -> System.out.println("Lambda version");

		lambdaI.m();  // print lambda version
		
		lambdaI2.m(); // print lambda version
		

	}

	
}
