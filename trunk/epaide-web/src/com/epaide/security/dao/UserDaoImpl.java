package com.epaide.security.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.epaide.security.model.UserDO;

public class UserDaoImpl extends SqlMapClientDaoSupport implements UserDao {
	public UserDO getUser(String username) {
		UserDO user = (UserDO) getSqlMapClientTemplate().queryForObject(
				"User.loadUserByName", username);
		return user;
	}

	@Override
	public boolean activateUser(String activationCode) {
		return false;
	}

	@Override
	public List<UserDO> getUsers(UserDO user) {
		return null;
	}

	@Override
	public void saveUser(UserDO user) {

	}

}
