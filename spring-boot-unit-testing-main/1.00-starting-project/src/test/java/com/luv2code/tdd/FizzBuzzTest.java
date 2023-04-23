package com.luv2code.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class FizzBuzzTest {

	// if number is divisible by 3, print Fizz
	@Test
	@Order(1)
	@DisplayName("Divisible by Three")
	void testForDivisibleByThree() {

		// fail("fail");

		String expected = "Fizz";

		assertEquals(expected, FizzBuzz.compute(3), "Should return Fizz");
	}

	// if number is divisible by 5, print Buzz
	@Test
	@Order(2)
	@DisplayName("Divisible by Five")
	void testForDivisibleByFive() {

		String expected = "Buzz";

		assertEquals(expected, FizzBuzz.compute(5), "Should return Buzzz");
	}

	// if number is divisible by 3 and 5 , print FizzBuzz
	@Test
	@Order(3)
	@DisplayName("Divisible by Three And Five")
	void testForDivisibleByFThreeAndive() {

		String expected = "FizzBuzz";

		assertEquals(expected, FizzBuzz.compute(15), "Should return FizzBuzzz");
	}

	// if number is NOT divisible by 3 or 5, then print the number
	@Test
	@Order(4)
	@DisplayName("NOT Divisible by Three And Five")
	void testForNotDivisibleByFThreeAndive() {

		String expected = "1";

		assertEquals(expected, FizzBuzz.compute(1), "Should return 1");
	}

	// Parametrized test with resources file
	@DisplayName("Testing with Small data file")
	@ParameterizedTest(name="value={0}, expected={1}")
	@CsvFileSource(resources="/small-test-data.csv")
	@Order(5)

	void testSmallDataFile(int value, String expected) {


		assertEquals(expected, FizzBuzz.compute(value));
	}

}
