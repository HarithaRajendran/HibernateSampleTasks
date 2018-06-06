package com.asahi.thrillio.dao;

import com.asahi.thrillio.entity.User;

public interface UserDao {
	public User getUser(String email,String password);

	public void createUser(User theUser);

}
