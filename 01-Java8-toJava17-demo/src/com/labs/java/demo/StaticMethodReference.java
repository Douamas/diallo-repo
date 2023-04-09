package com.labs.java.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class StaticMethodReference {

	public static void main(String[] args) {

		// Static method references are considered UNBOUNDED also. An example static
		// method
		// is Collections.sort(List)

		// Consumer<T>
		// void accept(T t)
		// void accept(List<Integer>)
		// NB : Consumer takes one parameter ==> sort(List) is used as opposed to
		// sort(List, Comparator)
		Consumer<List<Integer>> sortL = (list) -> Collections.sort(list);
		Consumer<List<Integer>> sortMR = Collections::sort;

		List<Integer> listOfNumbers = Arrays.asList(2, 5, 3, 1); // [1, 2, 3, 5]
		sortL.accept(listOfNumbers);
		System.out.println(listOfNumbers);

		listOfNumbers = Arrays.asList(21, 5, 31, 1); // [1, 5, 21, 31]
		sortMR.accept(listOfNumbers);
		System.out.println(listOfNumbers);

	}

}
