package com.epaide.security.dao;

import java.sql.SQLException;
import java.util.List;

import com.epaide.security.model.UserDO;

/**
 * 
 * @author paragon
 * 
 */
public interface UserDao {
	/**
	 * 根据用户名取得用户，用户名是唯一的
	 * 
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public UserDO getUser(String username) throws SQLException;

	/**
	 * 根据UserDO取得用户，如果UserDO==null,将取得所有用户
	 * 
	 * @param user
	 * @return
	 */
	public List<UserDO> getUsers(UserDO user);

	/**
	 * 保存用户
	 * 
	 * @param user
	 */
	public void saveUser(UserDO user);

	/**
	 * 根据激活码激活用户
	 * 
	 * @param activationCode
	 * @return
	 */
	public boolean activateUser(String activationCode);

}
