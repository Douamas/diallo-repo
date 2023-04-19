package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class CreateDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// ,create session

		Session session = factory.getCurrentSession();

		try {

			// create the objects

			Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");

			InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 Code ");

			// associate the objects
			instructor.setInstructorDetail(instructorDetail);

			// start a transaction
			session.beginTransaction();

			// save the instructor
			// Note : this will ALSO save the details object
			// because of CascadeType.ALL

			System.out.println("Saving instructor: " + instructor);
			session.save(instructor);

			// commit transaction

			session.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
