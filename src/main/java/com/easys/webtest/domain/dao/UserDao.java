package com.easys.webtest.domain.dao;

import org.springframework.data.repository.Repository;

import com.easys.webtest.domain.entity.security.User;

public interface UserDao extends Repository<User, Long> {

	public User save(User user);

	public User findById(Long id);

	public User findByName(String name);

	public User findByNameAndPassword(String name, String password);

}
