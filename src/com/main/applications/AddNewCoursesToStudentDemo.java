package com.main.applications;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tables.entities.Course;
import com.tables.entities.Instructor;
import com.tables.entities.InstructorDetail;
import com.tables.entities.Review;
import com.tables.entities.Student;

public class AddNewCoursesToStudentDemo {
	
	public static void main(String[] args) {
	
	// creating and configuring session factory
	SessionFactory sessionFactory = new Configuration().
			configure("hibernate.cfg.xml").
			addAnnotatedClass(Instructor.class).
			addAnnotatedClass(InstructorDetail.class).
			addAnnotatedClass(Course.class).
			addAnnotatedClass(Review.class).
			addAnnotatedClass(Student.class).
			buildSessionFactory();
	
	// creating a new session
	Session session = sessionFactory.getCurrentSession();
	
	// try-catch block that will make sure to release unused resources,
	// in case the transaction fails
	// also it will print the cause of the fail in the console
	try {
	
	// begin a new transaction
	session.beginTransaction();
	
	// Retrieving a student from the database
	int studentId = 1;
	Student student = session.get(Student.class, studentId);
	// Creating new courses and adding them to our Student
	Course course1 = new Course("How to cook like a chef");
	Course course2 = new Course("Learn German in 24 weeks");
	Course course3 = new Course("Boxing for beginners");
	student.addCourse(course1);
	student.addCourse(course2);
	student.addCourse(course3);
	
	// Logging messages
	System.out.println("Saving the student and his new courses");
	// IMPORTANT:
	// here instead of using "session.save()",
	// we will use "session.persist()", because the cascade type is not set to IDENTITY,
	// but instead we specify only some actions to be cascaded
	session.persist(student);
	
	System.out.println("Printing out saved student and his new courses: ");
	System.out.println(student);
	System.out.println(student.getCourses());
	
	// save changes performed during transaction and end transaction
	session.getTransaction().commit();
	
	
	}catch(Exception e) {
		System.out.println("Transaction failed");
		System.out.println("Closing session");
		session.close();
		sessionFactory.close();
		e.printStackTrace();
	}
	
	
	}
}
