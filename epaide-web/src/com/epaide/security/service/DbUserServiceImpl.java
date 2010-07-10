package com.epaide.security.service;

import org.springframework.dao.DataAccessException;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;

import com.epaide.security.dao.UserDaoImpl;
import com.epaide.security.model.Role;
import com.epaide.security.model.UserDO;

public class DbUserServiceImpl implements UserDetailsService {
	private UserDaoImpl userDao;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		UserDO user = userDao.getUser(username);
		UserDetails details = convert2UserDetails(user);
		return details;
	}

	private UserDetails convert2UserDetails(UserDO user) {
		if (user == null) {
			return null;
		}
		// create authorities
		GrantedAuthority[] authorities = new GrantedAuthority[user.getRoles()
				.size()];
		int i = 0;
		for (Role role : user.getRoles()) {
			authorities[i++] = new GrantedAuthorityImpl(role.getName());
		}
		return null;
	}

	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

}
