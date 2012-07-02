package ilife.user.service.impl;

import java.util.UUID;

import ilife.user.dao.UserDao;
import ilife.user.model.User;
import ilife.user.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;

	private boolean registrationAllowed = true;

	private boolean useAccountActivation = true;

	private PasswordEncoder passwordEncoder;

	@Override
	public boolean activateUser(String activationCode) {
		return userDao.activateUser(activationCode);
	}

	@Override
	public boolean registerNewUser(User user) {
		if (!registrationAllowed) {
			// throw new UserException("user ");
		}
		User u = userDao.loadUserByUsername(user.getUsername());

		user.setAccountLocked(true);
		user.setActivationCode(UUID.randomUUID().toString().replaceAll("-", ""));
		// TODO persistent user
		// User u = userDao.saveUser(user);
		// TODO send activation mail
		return false;
	}

	@Override
	public boolean isUserExists(User user) {
		return false;
	}

}
