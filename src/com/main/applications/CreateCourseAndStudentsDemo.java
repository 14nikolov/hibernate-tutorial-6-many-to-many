package com.main.applications;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tables.entities.Course;
import com.tables.entities.Instructor;
import com.tables.entities.InstructorDetail;
import com.tables.entities.Review;
import com.tables.entities.Student;

public class CreateCourseAndStudentsDemo {
	
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
	
	// Creating a new Course
	Course course = new Course("Latino Dancing 6");
	// Creating a Student
	Student student = new Student("Josh", "Gates", "joshgates@email.com");
	// Adding that student to our course
	course.addStudent(student);
	// creating and adding students for our course
	course.addStudent(new Student("Emily", "Vaucher", "emily@gmail.com"));
	course.addStudent(new Student("Kevin", "Bowy", "kev@greatmail.com"));
	
	// Logging messages
	System.out.println("Saving course and students");
	// IMPORTANT:
	// here instead of using "session.save()",
	// we will use "session.persist()", because the cascade type is not set to IDENTITY,
	// but instead we specify only some actions to be cascaded
	session.persist(course);
	
	System.out.println("Printing out saved course and students: ");
	System.out.println(course);
	System.out.println(course.getStudents());
	
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
