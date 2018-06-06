package com.asahi.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.asahi.demo1.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;

			session.beginTransaction();

			Student theCurrentStudent = session.get(Student.class, studentId);

			theCurrentStudent.setFirstName("Latha");

			theCurrentStudent.setEmail("latha@gmail.com");

			session.createQuery("update Student set email = 'haritha@gmail.com' where id = 2").executeUpdate();

			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
