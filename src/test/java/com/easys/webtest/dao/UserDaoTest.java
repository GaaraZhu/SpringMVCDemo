package com.easys.webtest.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.easys.webtest.domain.dao.UserDao;
import com.easys.webtest.domain.entity.User;
import com.easys.webtest.domain.entity.security.Resource;
import com.easys.webtest.domain.entity.security.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class UserDaoTest {

	@Autowired
	private UserDao userDao;

	@Test
	public void createUser() {
		Resource res_internal = new Resource("../../jsp/internal/*", 1, 1,
				"res_internal", "");
		Role role_internal = new Role(1, "role_internal");
		role_internal.addResource(res_internal);

		Resource res_external = new Resource("../../jsp/external/*", 1, 1,
				"res_external", "");
		Role role_external = new Role(1, "role_external");
		role_external.addResource(res_external);

		Role role_admin = new Role(1, "role_admin");
		role_admin.addResource(res_internal);
		role_admin.addResource(res_external);

		User user_admin = new User("gaara", "26", "123");
		user_admin.addRole(role_admin);
		
		User user_internal = new User("IUser1", "18", "123");
		user_internal.addRole(role_internal);
		User user_external = new User("EUser1", "28", "123");
		user_internal.addRole(role_external);
		
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
