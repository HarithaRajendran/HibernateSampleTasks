package com.asahi.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.asahi.demo.entity.Course;
import com.asahi.demo.entity.Instructor;
import com.asahi.demo.entity.InstructorDetail;
import com.asahi.demo.entity.Review;

public class DeleteDemo {
	
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

			
			
			
			
			session.beginTransaction();
			//Review review = session.get(Review.class, 1);
			Course course = session.get(Course.class, 10);
			session.delete(course);
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
			factory.close();
		}
		
	}
}
