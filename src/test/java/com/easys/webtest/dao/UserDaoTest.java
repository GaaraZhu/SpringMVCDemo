package com.easys.webtest.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.easys.webtest.controller.LoginController;
import com.easys.webtest.domain.dao.UserDao;
import com.easys.webtest.domain.entity.security.Resource;
import com.easys.webtest.domain.entity.security.Role;
import com.easys.webtest.domain.entity.security.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class UserDaoTest {

	@Autowired
	private UserDao userDao;

	@Autowired
	private LoginController loginController;
	
	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

	@Test
	public void createUser() {
		/*
		 * 1. Create basic resources
		 */
		Resource res_internal_jsp = new Resource("/internal/*.jsp", 1, 1,
				"res_internal_jsp", "");
		Resource res_external = new Resource("/external/*.jsp", 1, 1,
				"res_external_jsp", "");
		/*
		 * 2. Create basic roles
		 */
		Role role_admin = new Role(1, "role_admin");
		role_admin.addResource(res_internal_jsp);
		role_admin.addResource(res_external);
		
		Role role_internal = new Role(1, "role_internal");
		role_internal.addResource(res_internal_jsp);
		
		Role role_external = new Role(1, "role_external");
		role_external.addResource(res_external);

		/*
		 * 3. Create users
		 */
		User user_admin = new User("garyzhu", "26", "123");
		user_admin.addRole(role_admin);
		
		User user_internal = new User("IUser1", "18", "123");
		user_internal.addRole(role_internal);
		
		User user_external = new User("EUser1", "28", "123");
		user_external.addRole(role_external);
		
		getUserDao().save(user_admin);
		getUserDao().save(user_internal);
		getUserDao().save(user_external);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
