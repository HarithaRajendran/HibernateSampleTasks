package com.asahi.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.asahi.demo.entity.Course;
import com.asahi.demo.entity.Instructor;
import com.asahi.demo.entity.InstructorDetail;

public class SetCourseDemo {
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
			
			int theId =2;
			
			Instructor ins = session.get(Instructor.class, theId);
			
			System.out.println(ins);
			
		/*	Course c1 = new Course();
			c1.setTitle("dance");
			Course c2 = new Course();
			c2.setTitle("hdbgfhjdfkj");
			
			ins.add(c1);
			ins.add(c2);
			
			session.save(c1);
			session.save(c2);
			*/
			
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
