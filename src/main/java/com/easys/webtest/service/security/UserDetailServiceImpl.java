package com.easys.webtest.service.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.easys.webtest.domain.dao.UserDao;
import com.easys.webtest.domain.entity.security.Resource;
import com.easys.webtest.domain.entity.security.Role;
import com.easys.webtest.domain.entity.security.User;

@Component
@SuppressWarnings("deprecation")
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		User user = getUserDao().findByName(username);
		if (null == user) {
			throw new UsernameNotFoundException(username);
		}
		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(user);

		boolean enables = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		org.springframework.security.core.userdetails.User userdetail = new org.springframework.security.core.userdetails.User(
				user.getName(), user.getPassword(), enables, accountNonExpired,
				credentialsNonExpired, accountNonLocked, grantedAuths);
		return userdetail;
	}

	private Set<GrantedAuthority> obtionGrantedAuthorities(User user) {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		Set<Role> roles = user.getRoles();

		for (Role role : roles) {
			Set<Resource> tempRes = role.getResources();
			for (Resource res : tempRes) {
				authSet.add(new GrantedAuthorityImpl(res.getName()));
			}
		}
		return authSet;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
