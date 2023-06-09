package com.labs.java.demo;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class CollectionSet {

	public static void main(String[] args) {

		// factoryMethods();
		// treeSet();
		// hashSet();
		linkedHashSet();

	}

	public static void factoryMethods() {

		// unmodifiable sets returned

		Set<String> of = Set.of("a", "b", "c");
		Set<String> copy = Set.copyOf(of);

		of.add("d"); // UnsupportedOperationException
		copy.add("d"); // UnsupportedOperationException

		of.remove("a"); // UnsupportedOperationException

	}

	public static void treeSet() {

		// SUU - Sets are Unique and Unordered

		Set<String> names = new TreeSet<>();

		names.add("John");
		names.add("John");
		names.add("Helen");
		names.add("Anne");

		// No Duplicate, elements are sorted alphabetically

		names.forEach(System.out::println); // Anne, Helen, John

		Set<Integer> numbers = new TreeSet<>();

		numbers.add(23);
		numbers.add(Integer.valueOf("21"));
		numbers.add(Integer.valueOf("11"));
		numbers.add(99);

		// No Duplicate, elements are sorted numerically

		numbers.forEach(System.out::println); // 11, 21, 23, 99

	}

	public static void hashSet() {

		// HashSet

		Set<Contact> contactHS = new HashSet<>();

		contactHS.add(new Contact("zoe", 45));
		contactHS.add(new Contact("zoe", 45)); // "zoe" only added once (Set)
		contactHS.add(new Contact("alice", 34));
		contactHS.add(new Contact("andrew", 35));
		contactHS.add(new Contact("brian", 36));
		contactHS.add(new Contact("carol", 37));

		/*
		 * Output : brian,36 andrew,35 carol,37 alice,34 zoe,45
		 */

		for (Contact contact : contactHS) {
			System.out.println(contact);
		}

		System.out.println();

	}

	public static void linkedHashSet() {

		// LinkedHashSet
		// API : This implementation differs from HashSet in that it maintains
		// a doubly-linked list running through all of its entries. The linked list
		// defines the iteration ordering, which is the order in which elements were
		// inserted into the set (insertion-order).
		// This implementation spare its client from the unspecified, generally
		// chaotic ordering provided by HashSet, without incurring the increased cost
		// associated with TreeSet.

		Set<Contact> contactLHS = new LinkedHashSet<>();

		contactLHS.add(new Contact("zoe", 45));
		contactLHS.add(new Contact("zoe", 45)); // "zoe" only added once (Set)
		contactLHS.add(new Contact("alice", 34));
		contactLHS.add(new Contact("andrew", 35));
		contactLHS.add(new Contact("brian", 36));
		contactLHS.add(new Contact("carol", 37));
		
		/* Output :
		 * 	zoe,45
			alice,34
			andrew,35
			brian,36
			carol,37
		 */

		contactLHS.forEach(System.out::println);

	}

}

class Contact {

	private int age;
	private String name;

	public Contact(String name, int age) {
		super();
		this.age = age;
		this.name = name;
	}

	@Override
	public int hashCode() { // both instance variable 'age' and 'name' are used

		int hash = 7;
		hash = 89 * hash + this.age;
		hash = 89 * hash + this.name.length(); // a week hash algorithm - demo purposes

		return hash;

	}

	public boolean equals(Object obj) { // same instance variables used as is equals()

		if (obj instanceof Contact) {
			Contact otherConact = (Contact) obj;
			return this.name.equals(otherConact.name) && this.age == otherConact.age;
		}

		return false;

	}

	public String toString() {

		return name + "," + age;
	}

}
