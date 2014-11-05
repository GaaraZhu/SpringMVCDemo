package com.easys.webtest.service;

import com.easys.webtest.domain.entity.security.User;

public interface UserService {

	public User login(String name, String password);  

}
