package com.asahi.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.asahi.demo.entity.Course;
import com.asahi.demo.entity.Instructor;
import com.asahi.demo.entity.InstructorDetail;

public class DeleteCourse {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int theId =18;
			
			Course ins = session.get(Course.class, theId);
			
			session.delete(ins);
			
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
