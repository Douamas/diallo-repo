package com.labs.java.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorMethodReference {

	public static void main(String[] args) {

		// Supplier <T>
		// T get()

		Supplier<StringBuilder> sbL = () -> new StringBuilder(); // lambda
		Supplier<StringBuilder> sbMR = StringBuilder::new; // MR

		StringBuilder sb1 = sbL.get();
		sb1.append("lambda version");
		System.out.println(sb1);
		
		StringBuilder sb2 = sbMR.get();
		sb2.append("method reference version");
		System.out.println(sb2);
		
		
		// Function<T, R>
		// R apply(T t)
		// List<String> apply(Integer)
		
		Function<Integer, List<String>> alL = x -> new ArrayList<>(x);
		Function<Integer, List<String>> alMR = ArrayList::new;
		
		List<String> ls1 = alL.apply(10); // size 10
		ls1.add("21");
		System.out.println(ls1); 
		
		List<String> ls2 = alMR.apply(5); // size 5
		ls2.add("88");
		System.out.println(ls2); 
		
		

		
		


	}

}
