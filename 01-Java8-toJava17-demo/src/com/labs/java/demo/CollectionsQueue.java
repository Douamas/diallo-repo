package com.labs.java.demo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CollectionsQueue {

	public static void main(String[] args) {

		// linkedListQueue();
		// arrayDeque();
		priorityQueueNaturalOrdering();

	}

	public static void linkedListQueue() {

		// A FIFO queue
		Queue<Integer> queue = new LinkedList<>();

		// add() inserts into queue (throws exception if no space exists - if capacity
		// restricted)
		// offers() inserts into queue (returns false if no space exists - capacity
		// restricted)
		queue.add(1); // Head -> [1]
		queue.offer(2); // Head -> [1, 2]
		queue.add(3); // Head -> [1, 2, 3]
		queue.offer(4); // Head -> [1, 2, 3, 4]

		// elements() retrieve but does not remove the head of the queue (throws
		// exception if queue empty)
		// peek() retrieve but does not remove the head of the queue (return null if
		// queue empty)

		System.out.println(queue.element()); // 1
		System.out.println(queue.peek()); // 1
		System.out.println(queue); // [1, 2, 3, 4]
		// queue.forEach(System.out::println);

		// remove() - Retrieves and removes the head of this queue (throws exception if
		// queue empty)
		// poll() - Retrieves and removes the head of this queue (return null if queue
		// empty)

		System.out.println(queue.remove()); // 1
		System.out.println(queue.poll()); // 2
		System.out.println(queue); // [ 3, 4]

		// offer()/poll() and peek() are the preferred methods as they do not throw
		// exception (P.o.P)

	}

	public static void arrayDeque() {

		// Deque = "doubly ended queue". Supports element insertion/removal at both ends
		// ArrayDequeue - resizeable -array implementation of the Deque interface (no
		// capacity restriction)

		Deque<Integer> numbers = new ArrayDeque<>();

		// "arg"
		// Deque methods that begin with "a", "r", or "g" e.g.
		// addFirst(), addLast(), removeFirst(), removeLast(), getFirst(), getLast() all
		// throw
		// exception if the deque is both capacity-constrained and full.
		// The other methods (POP): peekFirst(), peekLast(), offerFirst(), offerLast(),
		// pollFirst()
		// pollLast() rather thasn throw exception in the same situation, they return
		// null/false

		// add at the front (the head)

		numbers.add(1); // 1
		numbers.addFirst(2); // 2, 1
		numbers.offerFirst(3); // 3, 2, 1
		System.out.println("Head: " + numbers.getFirst() + ". Head: " + numbers.peekFirst()); // Head: 3. Head: 3

		// add at the end (the tail)

		numbers.addLast(4); // 3, 2, 1, 4
		numbers.offerLast(3); // 3, 2, 1, 4, 5

		// remove from both ends
		numbers.removeFirst(); // 2, 1, 4, 5
		numbers.pollFirst(); // 1, 4, 5
		numbers.removeLast(); // 1, 4
		numbers.pollLast(); // 1

		System.out.print(numbers); // [1]
	}

	public static void priorityQueueNaturalOrdering() {
		// Natural Ordering
		Queue<String> names = new PriorityQueue<>(); // alphabetic ordering 
		names.add("V");
		names.add("P");
		names.add("A");

		Iterator<String> itNames = names.iterator();

		while (itNames.hasNext()) {
			System.out.println(names.poll()); // A, P, V
		}

	}

}
