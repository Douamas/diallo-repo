package com.labs.java.demo;

import java.util.Optional;

public class OptionalFeatures {

	public static void main(String[] args) {

		// lab -1

		Optional<Double> optAvg = calcAverage(50, 60, 70);

		// if you do get() and the Optional is empty you get :
		// NoSuchElementException: No value present
		// boolean isPresent() protects us from that

		if (optAvg.isPresent())
			System.out.println(optAvg.get()); // 60.0

		// void ifPresent(Consumer c)
		optAvg.ifPresent(System.out::println); // 60.0

		// T orElse( T t)
		System.out.println(optAvg.orElse(Double.NaN)); // 60.0

		Optional<Double> optAvg2 = calcAverage(); // will return an empty Optional
		System.out.println(optAvg2.orElse(Double.NaN)); // NaN

		// T orElseGet(Supplier<T> s)
		System.out.println(optAvg2.orElseGet(() -> Math.random())); // 0.9059382946347508

		// lab -2
		doOptionalNull();

	}

	// a long way to calculate average (just for showing Optional)

	public static Optional<Double> calcAverage(int... scores) {

		if (scores.length == 0)
			return Optional.empty();

		int sum = 0;
		for (int score : scores)
			sum += score;
		return Optional.of((double) sum / scores.length);
		
	}

	public static void doOptionalNull() {

		Optional<String> optSK = howToDealWithNull("SK"); // SK

		optSK.ifPresent(System.out::println);

		Optional<String> optNull = howToDealWithNull(null);

		System.out.println(optNull.orElseGet(() -> "Empty Optional")); // Empty Optional

	}

	public static Optional<String> howToDealWithNull(String param) {

		// Optional optReturn = param == null ? Optional.empty() : Optional.of(param);
		Optional<String> optReturn = Optional.ofNullable(param); // same as previous line

		return optReturn;
	}

}
