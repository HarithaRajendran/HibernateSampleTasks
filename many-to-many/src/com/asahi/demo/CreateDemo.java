package com.asahi.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.asahi.demo.entity.Course;
import com.asahi.demo.entity.Instructor;
import com.asahi.demo.entity.InstructorDetail;
import com.asahi.demo.entity.Review;
import com.asahi.demo.entity.Student;

public class CreateDemo {
	
	public static void main(String args[]) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {

			Student student = new Student();
			student.setFirstName("fff");
			student.setLastName("lll");
			student.setEmail("eee");
			
			
			
			
			
			session.beginTransaction();
			
			Course course = session.get(Course.class, 14);
			session.save(student);
			course.addStudent(student);
			session.save(course);
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
			factory.close();
		}
		
	}
}
