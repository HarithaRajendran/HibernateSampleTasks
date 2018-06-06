package com.asahi.demo1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.asahi.demo1.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			// both column name and field name are applicable
			List<Student> theStudent = session.createQuery("from Student where firstName = 'achu'").getResultList();

			for (Student some : theStudent) {
				System.out.println("Some Students: " + some);
			}
			System.out.println("-------------------------------------");
			theStudent = session.createQuery("from Student where firstName LIKE 'a%'").getResultList();

			for (Student some : theStudent) {
				System.out.println("Some Students: " + some);
			}

			session.getTransaction().commit();
		} finally {

			factory.close();
		}

	}

}
