package ilife.user.dao.impl;

import ilife.common.dao.impl.GenericDaoImpl;
import ilife.user.dao.UserDao;
import ilife.user.model.User;
import ilife.user.service.impl.UserServiceImpl;

import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class interacts with Spring's HibernateTemplate to save/delete and
 * retrieve User objects.
 * 
 */
@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao,
		UserDetailsService {
	private static final Logger logger = LoggerFactory
			.getLogger(UserDaoImpl.class);

	/**
	 * Constructor that sets the entity to User.class.
	 */
	public UserDaoImpl() {
		super(User.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		Query q = getEntityManager().createQuery(
				"select u from User u order by upper(u.username)");
		return q.getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public User loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Query q = getEntityManager().createNamedQuery("findUserByName",
				User.class);
		q.setParameter("username", username);
		List<User> users = q.getResultList();
		if (users == null || users.isEmpty()) {
			throw new UsernameNotFoundException("user '" + username
					+ "' not found...");
		} else {
			return users.get(0);
		}
	}

	/**
	 * @param user
	 *            the user to save
	 * @return the updated user
	 */
	public User saveUser(User user) {
		User u = super.save(user);
		getEntityManager().flush();
		return u;
	}

	@Override
	public String getUserPassword(String username) {
		return getEntityManager()
				.createNamedQuery("findPasswordByName", String.class)
				.setParameter("username", username).getSingleResult();
	}

	@Override
	public boolean activateUser(String activationCode) {

		List<User> users = getEntityManager().createNamedQuery("findUserByCode").setParameter("code", activationCode).getResultList();
		if (users.size() == 1) {
			User u = users.get(0);
			u.setAccountLocked(false);
			this.save(u);
			logger.info("activate user successfully by code {}", activationCode);
			return true;
		}
		logger.error("activate user failed by code {}", activationCode);
		return false;
	}

}