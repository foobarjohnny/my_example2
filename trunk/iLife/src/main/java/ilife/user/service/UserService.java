package ilife.user.service;

import ilife.user.model.User;

/**
 * 
 * @author liujijun
 * 
 */
public interface UserService {
	/**
	 * 根据激活码激活用户
	 * 
	 * @param activationCode
	 * @return
	 */
	public boolean activateUser(String activationCode);

	/**
	 * 注册新用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean registerNewUser(User user);

	/**
	 * 检查邮箱和用户名是否存在
	 * 
	 * @return
	 */
	public boolean isUserExists(User user);

}
