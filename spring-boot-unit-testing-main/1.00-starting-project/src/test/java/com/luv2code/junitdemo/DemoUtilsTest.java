package com.luv2code.junitdemo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) ==>  method name must have _ separator
//@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
//@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(MethodOrderer.DisplayName.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class DemoUtilsTest {

	DemoUtils demoUtils;

	@BeforeEach
	void setupBeforeEach() {
		demoUtils = new DemoUtils();
		/*
		 * String textBlock = """
		 * 
		 * @BeforeEach execute before the execution of each test methods""";
		 * System.out.println(textBlock);
		 */

	}

	@Test
	// @DisplayName("Equals And Not Equal")
	@Order(1)
	void testEqualsAndNotEquals() {

		// System.out.println("Running test: testEqualsAndNotEquals");

		assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
		assertNotEquals(6, demoUtils.add(1, 9), "1+9 must be 6");

	}

	@Test
	// @DisplayName("Null And Not Null")
	@Order(0)
	void testNullAndNotNull() {

		// System.out.println("Running test: testNullAndNotNull");

		String str1 = null;
		String str2 = "luv2code";

		assertNull(demoUtils.checkNull(str1), "Object should be null");
		assertNotNull(demoUtils.checkNull(str2), "Object should not be null");

		assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
		assertNotEquals(6, demoUtils.add(1, 9), "1+9 must be 6");

	}

	@Test
	@DisplayName("Same And Not Same")
	void testSameAndNotSame() {

		String str = "luv2code";
		assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Objects should refer to same object");
		assertNotSame(str, demoUtils.getAcademy(), "Objects should not refer to same object");

	}

	@Test
	@DisplayName("True and False")
	@Order(3)
	void testTruesFalse() {

		int gradeOne = 10;
		int gradeTwo = 5;

		String str = "luv2code";
		assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");
		assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");

	}

	@Test
	@DisplayName("Array Equals")
	void testArrayEquals() {
		String[] stringArray = { "A", "B", "C" };

		assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays should be the same");

	}

	@Test
	@DisplayName("Iterable Equals")
	void testIterableEquals() {
		List<String> theList = List.of("luv", "2", "code");

		assertIterableEquals(theList, demoUtils.getAcademyInList(), "Expected list should be the same");

	}

	@Test
	@DisplayName("Lines match")
	void testLinesMatch() {
		List<String> theList = List.of("luv", "2", "code");

		assertLinesMatch(theList, demoUtils.getAcademyInList(), "Lines should match");

	}

	@Test
	@DisplayName("Throws and Does Not Throws")
	void testThrowsAndDoesNotThrow() {

		assertThrows(Exception.class, () -> {
			demoUtils.throwException(-1);
		}, "Should throw exception");
		assertDoesNotThrow(() -> {
			demoUtils.throwException(5);
		}, "Should not throw exception");

	}

	@Test
	@DisplayName("Multiply")
	void testMultiply() {

		assertEquals(12, demoUtils.multiply(4, 3), "4*3 must be 12");

	}

	@Test
	@DisplayName("Timeout")
	void testTimeout() {

		assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
			demoUtils.checkTimeout();
		});

	}

//	@BeforeAll
//	static void setupBeforeAllClass() {
//		
//		String textBlock = """
//				@BeforeAll execute only before all test methods execution in the class
//				""";
//		System.out.println(textBlock);
//		
//	}
//	
//	@AfterAll
//	static void setupAfterAllClass() {
//		
//		String textBlock = """
//				@AfterAll execute only after all test methods execution in the class
//				""";
//		System.out.println(textBlock);
//		
//	}
//	
//	@BeforeEach
//	void setupBeforeEach() {
//		demoUtils = new DemoUtils();
//		String textBlock = """
//				@BeforeEach execute before the execution of each test methods""";
//		System.out.println(textBlock);
//
//	}
//	
//	@AfterEach
//	void tearDownAfterEach() {
//		
//		String textBlock = """
//				Running @AfterEach				
//				""";
//		System.out.println(textBlock);
//		
//	}

}
