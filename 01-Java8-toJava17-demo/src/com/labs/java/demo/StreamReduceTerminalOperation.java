package com.labs.java.demo;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class StreamReduceTerminalOperation {

	public static void main(String[] args) {

		// lab-1

		// The reduce() method combines a stream into a single object.
		// Is is a reduction, which means it processes all elements.
		// The most common way to doing a reduction is to start with
		// an initial value and keep merging it with the next value.

		// T reduce (T identity, BinaryOperator<T> accumulator)
		// BinaryOperator<T> functional method:
		// T apply(T, T)
		// The "identity" is the initial value of the reduction and also
		// what is returned if the stream is empty. This means that there
		// will always be a result and thus Optional is not the return type
		// (on this version of reduce()).
		// The "accumulator" combines the current result with the
		// current value in the stream

		String name = Stream.of("s", "e", "a", "n")/*
													 * .filter(s -> s.length() > 2).reduce("nothing", (x, y) -> x + y)
													 * happens in background
													 */
				.reduce("", (x, y) -> x + y);
		System.out.println(name); // sean

		Integer product = Stream.of(2, 3, 4).reduce(1, (x, y) -> x * y);

		System.out.println(product); // 24

		// lab-2

		// Optional<T> reduce(BinaryOperator<T> accumulator)
		// When you leave out the identity, an Optional is
		// returned because there may not be any data (all the
		// elements could have been filtered out earlier).
		// There are 3 possible results :
		// a) empty stream ==> empty Optional returned
		// b) one element in stream ==> that element is returned
		// c) multiple elements in stream => accumulator is applied

		BinaryOperator<Integer> op = (a, b) -> a + b;
		Stream<Integer> empty = Stream.empty();
		Stream<Integer> oneElement = Stream.of(6);
		Stream<Integer> multipleElements = Stream.of(3, 4, 5);

		empty.reduce(op).ifPresent(System.out::println); //
		oneElement.reduce(op).ifPresent(System.out::println); // 6
		multipleElements.reduce(op).ifPresent(System.out::println); // 12

		// lab-3

		// <U> U reduce ( U identity, BiFunction accumulator, BinaryOperator combiner)
		// We use this version when we are dealing with different types,
		// allowing us to create intermediate reductions and then combine
		// them at the end. This is useful when working with parallel stream - the
		// stream
		// can be decomposed and reassembled by separate thread. For example, if we
		// wanted to count
		// the length of four 1000-character strings, the first 2 values and the last 2
		// values
		// could be calculated independently. The intermediate results (2000) would then
		// be combined
		// into a final value (4000). Example: we want to count the number of characters
		// in each string
		
		Stream<String> stream = Stream.of("car","bus", "train", "aeroplane");
		int length = stream.reduce(0, // identity
								   (n, str) -> n + str.length(), // n is integer
								   (n1, n2) -> n1 + n2); // both are integers
		System.out.println(length); // 20

	}

}
