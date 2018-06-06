package com.asahi.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.asahi.demo1.entity.Student;

public class ReadStudentDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int studentId= 3;
			
			session.beginTransaction();
			
			Student currentStudent = session.get(Student.class,studentId);
			
			session.getTransaction().commit();
			
			System.out.println("The current Student is "+currentStudent);
		}finally {
			factory.close();
		}
		
	}
}
