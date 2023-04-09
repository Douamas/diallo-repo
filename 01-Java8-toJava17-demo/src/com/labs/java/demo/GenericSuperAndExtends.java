package com.labs.java.demo;

import java.util.ArrayList;
import java.util.List;

public class GenericSuperAndExtends {

	public static void main(String[] args) {
		// lab-1 : Polymorphic assignments.

		// Generics come in java 5. Type erasure required to support legacy code.
		// Thus, generics offer compile time protection.
		// Array have similar issues (polymorphic assignment) but the difference is
		// in how the complier and JVM behave. Due to type erasure with generics.
		// the JVM does not know the types; with arrays the JVM does.

		// First, let's lokk at arrays
		Dog[] dogs0 = { new Dog(), new Dog() };
		// addAnimal(dogs0);

		// polymorphism ok for the base type; Lits -> ArrayList
		List<Cat> cats1 = new ArrayList<Cat>();

		// polymorphism not ok for the generic type; Animal -> Cat
		// List<Animal> animals = new ArrayList<Cat>();
		List<Cat> cats2 = new ArrayList<Cat>(); // generic types of both sides must match
		List<Cat> cats3 = new ArrayList<>(); // or use type inference

		// As the JVM does not know the type (stripped out during type erasure), the
		// compiler has to step in.
		// addAnimal(cats2);

		// lab-2 : extends - Polymorphic assignments.
		// 'extends' is read-only
		List<? extends Animal> animals1 = new ArrayList<Animal>();
		// animals1.add(new Animal()); // read-only so we can't add anything

		List<? extends Animal> animals2 = new ArrayList<Dog>(); // this is valid if Animal was an interface also
		List<? extends Animal> animals3 = new ArrayList<Terrier>(); // this is valid if Animal was an interface also
		List<? extends Animal> animals4 = new ArrayList<Cat>(); // this is valid if Animal was an interface also
		List<? extends Animal> animals5 = new ArrayList<Manx>(); // this is valid if Animal was an interface also

		// List<? extends Animal> animals6 = new ArrayList<Object>();

		// lab-3 super : Polymorphic assignments.
		// super is read-add
		List<? super Dog> dogs1 = new ArrayList<Dog>();
		dogs1.add(new Dog()); // now, can add to the list

		List<? super Dog> dogs2 = new ArrayList<Animal>();
		List<? super Dog> dogs3 = new ArrayList<Object>();
		// List<? super Dog> dogs4 = new ArrayList<Terrier>();

		// Declaration for 'extends' and 'super' examples
		List<Object> objects = new ArrayList<>();
		objects.add(new Object());
		List<Animal> animals = new ArrayList<>();
		animals.add(new Animal());
		List<Cat> cats = new ArrayList<>();
		cats.add(new Cat());
		List<Manx> manxCats = new ArrayList<>();
		manxCats.add(new Manx());
		List<Dog> dogs = new ArrayList<>();
		dogs.add(new Dog());
		List<Terrier> terriers = new ArrayList<>();
		terriers.add(new Terrier());

		// 'extends'
		// ext(List<? extends Animal> list) - read-only
		ext(animals); // OK - Animal is a Animal
		ext(cats); // OK - Cat is a Animal
		ext(manxCats); // OK - Manx is a Animal
		ext(dogs); // OK - Dog is a Animal
		ext(terriers); // OK - Terrier is a Animal
		// ext(objects); // not OK - Objects is not an animal

		// 'Super'

		// spr(List<? super Cat> list) ==> modificable
		spr(cats); // cat is a Cat - OK
		spr(animals); // Animal is a supertype of Cat - OK
		spr(objects); // Object is a supertype of Cat - OK

		// spr(dogs); // compiler error: Dog is not a Cat or a supertype of Cat - not OK
		// spr(terriers); // compiler error: Terrier is not a Cat or a supertype of Cat
		// - not OK
		// spr(manxCats); // compiler error: Manx is not a Cat or a supertype of Cat -
		// not OK

	}

	public static void addAnimal(Animal[] animals) {

		animals[0] = new Dog();
		animals[1] = new Cat(); // ArraysStoreException - JVM knows the type
	}

	public static void addAnimal(List<Animal> animals) {

		animals.add(new Dog());
	}

	public static void ext(List<? extends Animal> list) {  // "upper-bounded" is Animal
		// 'extends' implies read-only
		// IN: List<Animal>, List<Cat>, List<Dog>, List<Manx>, List<Terrier>
		// if 'extends' allowed us to add to 'list', then we could take in
		// a List of Cats and add a Dog to it - thereby breaking type safety
		// list.add(new Cat()); // compiler error if we try to modify 'list'
		// list.add(new Dog()); // compiler error if we try to modify 'list'
		// list.add(new Animal()); // compiler error if we try to modify 'list'

		// for(Dog dog:list){ // compiler errors reading - 'list' could be a list vof
		// Cat's
		// System.out.print(dog);

		// }

		// No compiler errors reading once we treat them as Animal; whether this method
		// receives
		// in a list of Animal, Cat, Manx, Dog, or Terrier; they are all Animal

		for (Animal animal : list) {
			System.out.println(animal);

		}

	}

	public static void spr(List<? super Cat> list) { // The "lower-bound" is Cat

		// IN : Cat, Animal, Object
		// The only objects that can safely be added are any type of Cat (including
		// subtype)
		// because the method could getting in a list of Animals or Objects (or Cats)

		list.add(new Cat()); // Cat is-a Cat (Cat is-an Animal, Cat is-anObject)
		list.add(new Manx()); // Manx is-an Cat (Manx is-an Animal, Manx is-an Object)

		// list.add(new Dog()); // compiler error - Dog is not a cat
		// list.add(new Animal()); // compiler error - Animal is not a Cat (Cat is an
		// Animal)
		// list.add(new Object()); // compiler error - Object is not a Cat (Cat is an
		// Object)

		// for (Cat cat : list) { // compiler error when reading - 'list' passed in
		// could be Animal
		// System.out.println(cat);

		// }

//		for (Animal a : list) {		// compiler error when reading - 'list' passed in could be Object
//			System.out.println(a);
//
//		}
		
		for (Object o : list) {		// OK - the only thing we can safely say is that the 'list'
			System.out.println(o);	// coming in can all be treated as Object
									// Cat is-an Object, Animal is-an Object, Object is-an Object
		}

	}

}

class Animal {

}

class Dog extends Animal {

}

class Terrier extends Dog {

}

class Cat extends Animal {

}

class Manx extends Cat {

}
