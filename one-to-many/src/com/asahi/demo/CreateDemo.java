package com.asahi.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.asahi.demo.entity.Course;
import com.asahi.demo.entity.Instructor;
import com.asahi.demo.entity.InstructorDetail;

public class CreateDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Instructor instructorObject = new Instructor();
			
			InstructorDetail instructorDetailObject = new InstructorDetail();
			
			instructorDetailObject.setYoutubeChannel("www.hari.com");
			
			instructorDetailObject.setHobby("singing");
			
			
			
			instructorObject.setFirstName("Hari");
			
			instructorObject.setLastName("Rajen");
			
			instructorObject.setEmail("haritharaj1811@gmail.com");
			
			instructorObject.setInstructorDetail(instructorDetailObject);
			
			session.beginTransaction();
			
			session.save(instructorObject);
					
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
