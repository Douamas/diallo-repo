
package com.labs.java.demo;

import java.util.function.Predicate;



public class TestPredicate {

	public static void main(String[] args) {

		// Predicate<T> is a FI ==> one SAM
		// boolean test (T t) is the SAM
		// lab-1
		Predicate<Integer> predicate = i -> i < 0;
		System.out.println("Predicate: " + predicate.test(-1)); // print true
		System.out.println("Predicate: " + predicate.test(1)); // print false
		// lab-2 with method check
		
		int x=4;
		System.out.println("Is "+x+" even? "+ check(x, n -> n % 2 == 0)); // print true
		x=7;
		System.out.println("Is "+x+" even? "+ check(x, y -> y % 2 == 0)); // print false
		
		String name="Mr. Joe Bloggs";
		System.out.println("Does "+name+" Start with Mr. ? "+check(name, s -> s.startsWith("Mr."))); // print true
		
		name="Ms. Ann Bloggs";
		System.out.println("Does "+name+" Start with Mr. ? "+check(name, s -> s.startsWith("Mr."))); // print false

		

	}
	
	
	// check method
	public static <T> boolean check (T t, Predicate<T> lambda) {
		
		return lambda.test(t);
		
	}

}
