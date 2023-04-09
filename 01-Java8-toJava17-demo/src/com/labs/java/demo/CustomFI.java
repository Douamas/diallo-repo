
package com.labs.java.demo;

// my own custom FI

interface Evaluate<T> { // FI

	boolean isNegative(T t); // SAM

}

public class CustomFI {

	public static void main(String[] args) {

		// Evaluate <T> si a FI
		// boolean isNegative(T t) is a SAM // similar to java.util.function.Predicate

		Evaluate<Integer> lambda = i -> i < 0;

		System.out.println("Evaluate: " + lambda.isNegative(-1)); // print true
		System.out.println("Evaluate: " + lambda.isNegative(1)); // print false

		// Predicate<T> is a FI ==> one SAM
		// boolean test (T t) is the SAM
//		Predicate<Integer> predicate = i -> i < 0;
//		System.out.println("Predicate: " + predicate.test(-1)); // print true
//		System.out.println("Predicate: " + predicate.test(1)); // print false

	}
	


}
