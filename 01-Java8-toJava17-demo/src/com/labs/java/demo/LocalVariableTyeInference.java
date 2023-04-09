package com.labs.java.demo;

public class LocalVariableTyeInference {

	public static void main(String[] args) {
		// 1. where they can be used :
		// 		- constructors, methods, or init blocks
		// 2. where they CANNOT be used 
		// 		- constructors/methods parameters or static/class variables
		// 		- caveat (mean attention): lambdas where the parameter type can be inferred
		// 3. a var is always initialised on the same statement where it is declareds
		//		e.g. var w=8;
		// 4. The value of var can change but the type cannot
		// 5. var cannot be simply initialised to null; cast the null to a type first.
		// 6. var not allowed in multi-variable declaration.
		// 7. var is a reserved name but not a reserved word.
		// 		- var var = 8; //ok
		// 		- identifiers can be called var but not type messages e.g. classes, interfaces, enums.
	}

}
