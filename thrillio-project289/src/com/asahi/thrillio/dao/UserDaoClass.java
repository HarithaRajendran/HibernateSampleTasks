package com.asahi.thrillio.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asahi.thrillio.entity.Book;
import com.asahi.thrillio.entity.User;

@Repository
public class UserDaoClass implements UserDao {

	@Autowired
	private SessionFactory factory;

	@Override
	public User getUser(String email,String password) {
		
		User currentUser = null;
		Session session = factory.getCurrentSession();

		Query<User> theQuery = session.createQuery("from User where email =:email and password =:password", User.class);
		theQuery.setParameter("email", email);
		theQuery.setParameter("password", password);
		
		List<User> theUser = theQuery.getResultList();
		
		//User theUser = session.get(User.class, 1);
		
		for(User user:theUser) {
			currentUser = user;
		}
		
		return currentUser;
		
	}

	@Override
	public void createUser(User theUser) {
		Session session = factory.getCurrentSession();
		
		session.save(theUser);
	}


}
