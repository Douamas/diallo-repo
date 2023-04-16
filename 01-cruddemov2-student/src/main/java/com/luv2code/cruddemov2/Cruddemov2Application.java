package com.luv2code.cruddemov2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemov2.dao.StudentDAO;
import com.luv2code.cruddemov2.entity.Student;

@SpringBootApplication
public class Cruddemov2Application {

	public static void main(String[] args) {
		SpringApplication.run(Cruddemov2Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> createStudent(studentDAO);

	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student obect
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display the id of the student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());

	}

}
