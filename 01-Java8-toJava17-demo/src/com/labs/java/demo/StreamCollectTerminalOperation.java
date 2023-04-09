package com.labs.java.demo;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectTerminalOperation {

	public static void main(String[] args) {

		/* Collectors.toMap() */

		// lab-1

		// StringBuilder collect ( Supplier<StringBuilder> supplier,
		// BiConsumer<StringBuilder, String> accumulator
		// BiConsumer<StringBuilder, StringBuilder> combiner)
		// This version is used when you want complete control over how collecting
		// should work.
		// The accumulator add an element to the collection e.g. the next String to the
		// StringBuilder.
		// The combiner takes two collections and merge them. It is useful in parallel
		// processing

		StringBuilder word = Stream.of("ad", "jud", "i", "cate").collect(() -> new StringBuilder(), // StringBuilder::new
				(sb, str) -> sb.append(str), // StringBuilder::append
				(sb1, sb2) -> sb1.append(sb2)); // StringBuilder::append
		// With Method References
		/*
		 * StringBuilder word = Stream.of("ad", "jud", "i","cate")
		 * .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		 */

		System.out.println(word);

		// lab-2
		String str = Stream.of("cake", "biscuits", "apple tart").collect(Collectors.joining(", "));
		System.out.println(str); // cake, biscuits, apple tart

		Double avg = Stream.of("cake", "biscuits", "apple tart").collect(Collectors.averagingInt(a -> a.length()));
		System.out.println(avg); // 7.333333333333333

		// lab-3

		// We want a map: dessert name -> number of characters in dessert name
		// Output : { biscuits=8, cake=4, apple tart=10}

		Map<String, Integer> map = Stream.of("biscuits", "cake", "apple tart").collect(Collectors.toMap(m -> m, // Function
																												// for
																												// the
																												// key
				m -> m.length())); // Function for the value

		System.out.println(map); // {biscuits=8, cake=4, apple tart=10}

		// lab-4

		// We want a map: number of characters in dessert name -> dessert name
		// However, 2 of the desserts have the same length (cake and tart) and as
		// length is our key and we can't have duplicate keys, this lead to an
		// exception as Java does not know what to do ...
		// IllegalStateException: Duplicate key 4 (attempted merging values cake and
		// tart)
		// To get around this, we can supply a merge function whereby we append
		// colliding keys values together.

		Map<Integer, String> map2 = Stream.of("biscuits", "cake", "tart").collect(Collectors.toMap(s -> s.length(), // key
																													// is
																													// the
																													// length
				s -> s, // value is the String
				(s1, s2) -> s1 + ", " + s2)); // Merge function - what to do if we have duplicate keys
												// - appends the values

		System.out.println(map2); // {4=cake, tart, 8=biscuits}

		// lab-5

		// The maps returned are HashMaps but this is not guaranteed.
		// What if we wanted a TreeMap implementation so our keys would be sorted.
		// The last argument caters for this

		TreeMap<String, Integer> map3 = Stream.of("cake", "biscuits", "apple tart", "cake")
				.collect(Collectors.toMap(s -> s, // key is the String
						s -> s.length(), // value is the length of the String
						(len1, len2) -> len1 + len2, // what to do if we have duplicate keys
														// - add the values

						() -> new TreeMap<>())); // TreeMap::new works also

		System.out.println(map3); // {apple tart=10, biscuits=8, cake=8} Note: cake maps to 8
		System.out.println(map3.getClass()); // class java.util.TreeMap

		/* Collectors.groupingBy() */

		// lab-1

		Stream<String> names = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
		Map<Integer, List<String>> map4 = names.collect(
				// Passing in a Function that determines the key in the Map
				Collectors.groupingBy(String::length) // s -> s.length()
		);

		System.out.println(map4); // {3=[Joe, Tom, Tom], 4=[Alan], 5=[Peter]}

		// lab-2
		// what if we want a Set instead of List ?
		Stream<String> names1 = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
		Map<Integer, Set<String>> map5 = names1.collect(
				// Passing in a Function that determines the key in the Map
				Collectors.groupingBy(String::length, // key Function
						Collectors.toSet()) // What to do with the values
		);

		System.out.println(map5); // {3=[Joe, Tom], 4=[Alan], 5=[Peter]}

		// lab-3
		// what if we wanted to ensure we got back a TreeMap but leave the values as a
		// List ?

		Stream<String> names2 = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
		TreeMap<Integer, List<String>> map6 = names2.collect(Collectors.groupingBy(String::length, // Key Function
				TreeMap::new, // map type Supplier
				Collectors.toList()) // downstream collector
		);

		System.out.println(map6); // {3=[Joe, Tom, Tom], 4=[Alan], 5=[Peter]}
		System.out.println(map6.getClass()); // class java.util.TreeMap

		/* Collectors.partitioningBy() */
		// Partitioning is a special case of grouping where there are only two possible
		// groups
		// - true and false
		// The keys will be the booleans true and false

		// lab-1

		Stream<String> names3 = Stream.of("Thomas", "Teresa", "Mike", "Alan", "Peter");

		Map<Boolean, List<String>> map7 = names3.collect(
				// pass in a Predicate
				Collectors.partitioningBy(s -> s.startsWith("T")));

		System.out.println(map7); // {false=[Mike, Alan, Peter], true=[Thomas, Teresa]}

		// lab-2
		// As with groupingBy(), we can change the values type from List to Set

		Stream<String> names4 = Stream.of("Alan", "Teresa", "Mike", "Alan", "Peter");

		Map<Boolean, Set<String>> map8 = names4.collect(
				// pass in a Predicate
				Collectors.partitioningBy(s -> s.length() > 4, Collectors.toSet()));

		System.out.println(map8); // {false=[Mike, Alan], true=[Teresa, Peter]}

	}

}
