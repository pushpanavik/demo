package com.bridge.service;

import com.bridge.model.Login;
import com.bridge.model.User;

public interface IUserService {
	int register(User user);
	User login(Login login);
	User getByEmail(String name);
}
