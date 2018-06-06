package com.asahi.thrillio.service;

import com.asahi.thrillio.entity.User;

public interface UserService {
	public User getUser(String email,String password);

	public void createUser(User theUser);
}
