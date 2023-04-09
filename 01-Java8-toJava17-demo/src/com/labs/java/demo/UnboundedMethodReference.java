package com.labs.java.demo;

import java.util.function.BiFunction;
import java.util.function.Function;

public class UnboundedMethodReference {

	public static void main(String[] args) {
		
		// Function<T, R>
		// R apply(T)
		
		Function<String, String> upperL = s -> s.toUpperCase(); // lambda
		Function<String, String> upperMR = String::toUpperCase; // method reference
		
		// No need to say which instance to call it on - the supplier is bound to name
		System.out.println(upperL.apply("sean")); // SEAN
		System.out.println(upperMR.apply("sean")); // SEAN
		
		
		// Function<T, U, R>
		// R apply ( T t, U, u)
		// String apply(String, String)

		BiFunction<String, String, String> concatL = (s1, s2) -> s1.concat(s2);
		BiFunction<String, String, String> concatMR = String::concat;

		
		System.out.println(concatL.apply("Sean ", "Kennedy")); 
		
		// 1st parameter is used for executing the instance method
		// "Sean ".concat("Kennedy")
		System.out.println(concatMR.apply("Sean ", "Kennedy")); 



		

	}

}
