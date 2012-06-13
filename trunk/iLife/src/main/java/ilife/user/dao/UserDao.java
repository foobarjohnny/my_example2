package ilife.user.dao;

import ilife.common.dao.GenericDao;
import ilife.user.model.User;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * User Data Access Object (GenericDao) interface.
 * 
 * @author
 */
public interface UserDao extends GenericDao<User, Long> {

	/**
	 * 通过用户名取得用户信息.
	 * 
	 * @param username
	 *            the user's username
	 * @return userDetails populated userDetails object
	 * @throws org.springframework.security.core.userdetails.UsernameNotFoundException
	 *             thrown when user not found in database
	 */
	@Transactional
	User loadUserByUsername(String username) throws UsernameNotFoundException;

	/**
	 * Gets a list of users ordered by the uppercase version of their username.
	 * 
	 * @return List populated list of users
	 */
	List<User> getUsers();

	/**
	 * 
	 * 
	 * @param user
	 *            the object to be saved
	 * @return the persisted User object
	 */
	User saveUser(User user);

	/**
	 * 根据用户名取得密码
	 * 
	 * @param username
	 *            the user's username
	 * @return the password in DB, if the user is already persisted
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	String getUserPassword(String username);

	/**
	 * 根据激活码激活用户帐号
	 * @param activationCode
	 * @return
	 */
	public boolean activateUser(String activationCode);
}
