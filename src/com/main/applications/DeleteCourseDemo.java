package com.main.applications;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tables.entities.Course;
import com.tables.entities.Instructor;
import com.tables.entities.InstructorDetail;
import com.tables.entities.Review;
import com.tables.entities.Student;

public class DeleteCourseDemo {
	
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
	
	int courseId = 13;
	Course course = session.get(Course.class, courseId);
	
	// Deleting Course
	System.out.println("Deleting Course");
	session.delete(course);
	
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
