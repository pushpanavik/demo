package com.bridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridge.dao.IUserDao;
import com.bridge.model.Login;
import com.bridge.model.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDao userDao;

	@Override
	public int register(User user) {
		int status = 0;
		if(user!=null) {
			User usercheck = userDao.getByEmail(user.getEmail());
			if(usercheck==null) {
				status = userDao.insert(user);
			}else {
				status = 0;
			}
		}
		
		return status;
	}

	@Override
	public User login(Login login) {
		User user = null;
		System.out.println("check for null");
		System.out.println(login.getEmail() +" " +login.getPassword());
		userDao.print();
		try {
			if (login!=null) {
				
				System.out.println("if not null than takes email and password from the form");
				user = userDao.select(login.getEmail(), login.getPassword());		
			}
		} catch (Exception e) {
			System.out.println("No user found");
		}
		return user ;
	}

	@Override
	public User getByEmail(String email) {
		
		return userDao.getByEmail(email);
	}

}
