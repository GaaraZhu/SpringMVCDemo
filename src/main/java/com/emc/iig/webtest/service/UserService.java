package com.emc.iig.webtest.service;

import com.emc.iig.webtest.domain.entity.User;

public interface UserService {

	public User login(String name, String password);

}
