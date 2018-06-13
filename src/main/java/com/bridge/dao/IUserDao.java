package com.bridge.dao;

import com.bridge.model.User;

public interface IUserDao {

	User select(String email, String password);

	User getByEmail(String email);

	int insert(User user);
	
	void print();

}
