package com.easys.webtest.service;

import com.easys.webtest.domain.entity.User;

public interface UserService {

	public User login(String name, String password); 

}
