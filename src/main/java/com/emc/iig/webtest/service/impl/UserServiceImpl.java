package com.emc.iig.webtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.iig.webtest.domain.dao.UserDao;
import com.emc.iig.webtest.domain.entity.User;
import com.emc.iig.webtest.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User login(String name, String password) {

		return getUserDao().findByNameAndPassword(name, password);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
