package com.labs.java.demo;

import java.util.HashMap;
import java.util.Map;

public class Hashing {

	private static Map<Contacte, String> map = new HashMap<>();

	public static void main(String[] args) {

		Contacte john = new Contacte("john", 33);
		Contacte peter = new Contacte("john", 34);

		System.out.println("john.hashCode() is " + john.hashCode()); // 58388
		System.out.println("peter.hashCode() is " + peter.hashCode()); // 58477
		map.put(john, "Irish");
		map.put(peter, "American");
		System.out.println(map.get(john)); // Irish
		System.out.println(map.get(peter)); // American

		Contacte mary = new Contacte("mary", 21);
		System.out.println("mary.hashCode() is " + mary.hashCode()); // 57320

		map.put(mary, "engineer");
		otherScope();
		System.out.println("After otherScope(): " + map.get(mary)); // accountant
		
		testJane();
		// HashMaps do not maintain order
		map.forEach((k,v) -> System.out.print(" key : " + k + " value :" + v ));

	}

	public static void otherScope() {

		Contacte anotherMary = new Contacte("mary", 21); // reconstruct "anotherMary"
		System.out.println("anotherMary.hashCode() is " + anotherMary.hashCode()); // 57320
		// Separate object used as a key to access the Map
		System.out.println("In otherScope(): " + map.get(anotherMary)); // engineer

		// the next line overwrites mary with anotherMary as a key because:
		// a) their hashcodes are the same
		// b) they are both equal according to equals()

		map.put(anotherMary, "accountant");

	}

	public static void testJane() {
		// "Jane" will result in the same hashcode as "mary" or "anotherMary"
		// because their ages are the same and "mary" and "jane" each have 4 letters.
		// Thus, the hashing algorithm will find the same bucket.
		// The equals() method now however finds a different key because we are
		// searching based on "jane" within the bucket and not for "mary" as above.
		// As result, when we do the "get", we get "nurse" and not "accountant".

		Contacte jane = new Contacte("jane", 21);
		System.out.println("jane.hashCode() is " + jane.hashCode()); // 57320
		map.put(jane, "nurse");
		System.out.println(map.get(jane)); // nurse

	}

}

class Contacte {

	private int age;
	private String name;

	Contacte(String name, int age) {
		this.age = age;
		this.name = name;

	}

	public int hashCode() { // both instance variables 'age' and 'name' are used
		int hash = 7;
		hash = 89 * hash + this.age;
		hash = 89 * hash + this.name.length();

		return hash;
	}

	public boolean equals(Object obj) {

		if (obj instanceof Contacte) {
			Contacte otherContact = (Contacte) obj;
			return this.name.equals(otherContact.name) && this.age == otherContact.age;
		}
		return false;
	}
}