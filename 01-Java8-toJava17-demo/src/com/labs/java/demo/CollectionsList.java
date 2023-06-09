package com.labs.java.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CollectionsList {

	public static void main(String[] args) {

		// factoryMethods();
		// arrayList();
		linkedList();

	}

	// lab -1
	public static void factoryMethods() {

		String[] array = new String[] { "Alpha", "Beta", "Charlie" };

		List<String> asList = Arrays.asList(array); // 'array' and 'asList' are now 'backed'
		List<String> of = List.of(array);
		List<String> copy = List.copyOf(asList);

		array[0] = "Delta"; // changes to the array 'write through' to the list
		System.out.println(Arrays.toString(array)); // [Delta, Beta, Charlie]
		System.out.println(asList); // [Delta, Beta, Charlie]

		asList.set(1, "Echo"); // // changes to the List 'write through' to the array
		System.out.println(Arrays.toString(array)); // [Delta, Echo, Charlie]
		System.out.println(asList); // [Delta, Echo, Charlie]

		// of.add("Foxtrot"); // UnsupportedOperationException
		// copy.add("Foxtrot"); // UnsupportedOperationException
		// asList.add("Foxtrot"); // UnsupportedOperationException

	}

	// lab -2

	public static void arrayList() {
		// LOD = Lord Of the Dance
		// = Lists maintain Order (index) and allow Duplicates

		List<String> list = new ArrayList<>();
		list.add("Alan");
		list.add("Alan");
		list.add(1, "Sean");
		list.add("Mary");
		list.add("Mary");

		System.out.println(list); // [Alan, Sean, Alan, Mary, Mary]
		System.out.println(list.get(1)); // Sean
		list.remove(0); // [Sean, Alan, Mary, Mary]
		list.remove("Mary"); // Only first Mary is removed : [Sean, Alan, Mary]
		System.out.println(list); // [Sean, Alan, Mary]
		list.set(0, "Jack"); // [Jack, Alan, Mary]

		// replaceAll(UnaryOperator<E> op) - UnaryOperator is a Function<T,T> where
		// input and output are the same type

		list.replaceAll(name -> name + " Kennedy");
		System.out.println(list); // [Jack Kennedy, Alan Kennedy, Mary Kennedy]

	}

	// lab -3
	public static void linkedList() {

		// A doubly-linked list. We can manipulate both ends.

		LinkedList<String> names = new LinkedList<>();

		names.add("Colin"); // [Colin]
		names.add("David"); // [Colin, David]
		names.addFirst("Brian"); // [Brian, Colin, David]
		names.addLast("Edward"); // [Brian, Colin, David, Edward]
		System.out.println(names); // [Brian, Colin, David, Edward]

		names.remove("David"); // [Brian, Colin, Edward]
		names.removeFirst(); // [Colin, Edward]
		names.removeLast(); // [Colin]
		System.out.println(names); // [Colin]

	}

}
