package com.asahi.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.asahi.demo.entity.Course;
import com.asahi.demo.entity.Instructor;
import com.asahi.demo.entity.InstructorDetail;
import com.asahi.demo.entity.Review;

public class CreateDemo {
	
	public static void main(String args[]) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {

			Course courses = new Course();
			courses.setTitle("Classical dance");
			
			Review review = new Review();
			review.setComment("good to learn");
			System.out.println("created...");
			
			Review review2 = new Review();
			review2.setComment("good physical ");
			
			courses.add(review);
			courses.add(review2);
			
			session.beginTransaction();
			session.save(courses);
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
			factory.close();
		}
		
	}
}
