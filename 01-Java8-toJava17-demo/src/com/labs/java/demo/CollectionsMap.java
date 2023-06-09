package com.labs.java.demo;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class CollectionsMap {

	public static void main(String[] args) {

		Map<String, Integer> map = new TreeMap<>(); // sorted by keys

		map.put("John", 18);
		map.put("Mary", 21);
		map.put("Chris", 33);

		System.out.println(map.containsKey("John")); // true
		System.out.println(map.containsValue(18)); // true
		System.out.println(map.isEmpty()); // false
		System.out.println(map.get("John")); // 18

		for (String name : map.keySet()) {

			System.out.println(name); // Chris, John, Mary
		}

		for (Integer age : map.values()) {

			System.out.println(age); // 33, 18, 21
		}

		System.out.println(map.containsKey("Paul")); // false
		System.out.println(map.containsValue(21)); // true
		System.out.println(map.size()); // 3
		map.clear();
		System.out.println(map.size()); // 0

		// forEach()
		map.put("John", 18);
		map.put("Mary", 21);
		map.put("Chris", 33);

		// forEach(BiConsumer)
		/// BiConsummer (T, U) void accept(T t, U u)

		// BiConsumer <String, Integer> bC = (k, v) -> System.out.println(k + " map to
		// "+ v);
		// Chris map to 33
		// John map to 18
		// Mary map to 21
		map.forEach((k, v) -> System.out.println(k + " map to " + v));
		// map.forEach(bC); // or

		// Set<Map.Enty<K,V> entySey() - Map.Entry encapsulate a key-value pair.
		// go from a Map to a set (an official Collection)
		// Chris -> 33
		// John -> 18
		// Mary -> 21
		map.entrySet().forEach(entry -> // forEach(Consumer)
		System.out.println(entry.getKey() + " -> " + entry.getValue()));

		Set<String> keys = map.keySet();

		keys.forEach(c -> System.out.print(c + " "));// Chris John Mary

		// putIfAbsent()
		// values re not replaced if they are present
		map.put("Mike", null);
		map.putIfAbsent("Chris", 99);
		map.putIfAbsent("Mike", 55);
		map.putIfAbsent("Luke", 31);

		// replace () and replaceAll()
		Integer original = map.replace("Chris", 81);
		System.out.println(map); // {Chris=81, John=18, Luke=31, Mary=21, Mike=55}
		System.out.println(original); //

		// BiFunction <T, U, R>
		// R apply(T t, U u) - 2 inputs and outputs; all of which can be different types
		// replaceAll(BiFunction <K, V, V> fn) - note the return type is of type V also
		map.replaceAll((name, age) -> name.length());
		System.out.println(map); // {Chris=5, John=4, Luke=4, Mary=4, Mike=4}

		// remove()
		map.remove("Mike"); //
		System.out.println(map); // {Chris=5, John=4, Luke=4, Mary=4}

	}
}
