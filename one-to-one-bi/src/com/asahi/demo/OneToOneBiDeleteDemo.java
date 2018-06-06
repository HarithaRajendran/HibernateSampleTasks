package com.asahi.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.asahi.demo.entity.Instructor;
import com.asahi.demo.entity.InstructorDetail;

public class OneToOneBiDeleteDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
		
			//InstructorDetail instructorDetailObject = new InstructorDetail();
			
			session.beginTransaction();
			
			
			InstructorDetail i = session.get(InstructorDetail.class, 5);
			
			i.getInstructor().setInstructorDetail(null);		
			
			System.out.println(i.getInstructor());
			
			session.delete(i);
					
			session.getTransaction().commit();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
