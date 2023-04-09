
package com.labs.java.demo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;



public class FI_from_API {

	public static void main(String[] args) {

		FI_from_API fiAPI = new FI_from_API();
		fiAPI.predicate();
		fiAPI.supplier();
		fiAPI.consumer();
		fiAPI.function();
		fiAPI.unaryBinaryOperator();

	}
	
	
	
	public void unaryBinaryOperator() {
		
		// UnaryOperator<T> extends Function<T, T> is a FI
		// T apply (T t)
		
		UnaryOperator<String> unaryOp = name -> "My name is "+ name;
		System.out.println("UnaryOpeartor : "+ unaryOp.apply("Sean")); // Sean
		
		// BinaryOperator<T> extends Function<T,T,T> is a FI
		// T apply(T t, T t)
		BinaryOperator <String> binaryOp = (s1, s2) -> s1.concat(s2);
		System.out.println("BinaryOpeartor : "+ binaryOp.apply("William ", "Shakespear")); // Willaim Shakespear


		
		
	}
	
	public void function () {
		
		// Function<T,R> is a FI
		// R apply(T t) 
		Function <String, Integer> fn2 = s -> s.length();
		System.out.println("Function: "+ fn2.apply("Moscow")); //6
		
		// BiFunction<T, U, R> is a FI
		// R apply(T t, U u)
		BiFunction<String, String, Integer> biFn = (s1, s2) -> s1.length() + s2.length();
		System.out.println("BiFunction: "+ biFn.apply("William", "Shakespeare")); // 18
		
		BiFunction<String, String, String> biFn2 = (s1, s2) -> s1.concat(s2);
		System.out.println("BiFunction: "+ biFn2.apply("William ", "Shakespeare")); // William Shakespeare


		
		
	}
	
	public void consumer() {
		
		// consumer<T> is a FI 
		// void accept(T t)
		
		Consumer<String> printC = s -> System.out.println(s);
		printC.accept("To be or not to be, that is the question");
		
		List<String> names = new ArrayList<>();
		names.add("John");
		names.add("Mary");
		names.forEach(printC); // print John, Mary
		
		// BiConsumer<T, U> is a FI
		// void accept(T t, U u)
		
		var mapCapitalCities = new HashMap<String, String>();
		// Note : The return value of put(k,v) is just ignored (and not returned from the lambda)
		BiConsumer<String, String> biCon = (key, value) -> mapCapitalCities.put(key,value);
		biCon.accept("Dublin", "Ireland");
		biCon.accept("Washington D.C.", "USA");
		System.out.println(mapCapitalCities);
		
		
		BiConsumer<String, String> maPrint = (key, value) -> System.out.println(key + " Is the capital of: "+ value);
		mapCapitalCities.forEach(maPrint);

	}
	
	
	
	public void predicate() {
		
		// Predicate<T> is a FI , one SAM
		// boolean test (T t)
		Predicate<String> pStr = s -> s.contains("City");
		System.out.println(pStr.test("Vatican City")); //true
		
		
		// BiPredicate<T, U> is a FI
		// boolean test (T t, U u)
		BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;
		System.out.println(checkLength.test("Vatican City",8)); // false length is 12
		
	}
	
	
	public void supplier () {
		
		
		// Supplier <T> is a FI
		// T get ()
		
		Supplier<StringBuilder> supSB = () -> new StringBuilder();
		System.out.println("Supplier SB: "+ supSB.get().append("SK")); // Supplier SB : SK
		
		Supplier<LocalTime> supTime = () -> LocalTime.now();
		System.out.println("Supplier Time: "+ supTime.get()); // Supplier Time: 18:39:01.045447
		
		Supplier<Double> sRandom = ()->Math.random();
		System.out.println("random : " + sRandom.get()); // random : 0.7846566749262981


		
	}

}
