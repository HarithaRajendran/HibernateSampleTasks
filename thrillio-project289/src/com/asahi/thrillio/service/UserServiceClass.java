package com.asahi.thrillio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asahi.thrillio.dao.UserDao;
import com.asahi.thrillio.entity.User;

@Service
public class UserServiceClass implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional
	public User getUser(String email,String password) {
		
		User theUser = userDao.getUser(email,password);
		
		return theUser;
	}

	@Override
	@Transactional
	public void createUser(User theUser) {
		userDao.createUser(theUser);
	}
}
