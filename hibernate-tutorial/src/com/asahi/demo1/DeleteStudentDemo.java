package com.asahi.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.asahi.demo1.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			
			int studentId = 1;
			
			session.beginTransaction();
			
			Student removeStudent = session.get(Student.class, studentId);
			
			session.delete(removeStudent);
			
			session.createQuery("delete from Student where id = 2").executeUpdate();
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
