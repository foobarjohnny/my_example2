package ilife.user.dao.impl;

import ilife.common.dao.impl.GenericDaoImpl;
import ilife.user.dao.UserDao;
import ilife.user.model.User;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.Table;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
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
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao, UserDetailsService {
    @Autowired
    private DataSource dataSource;

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
        Query q = getEntityManager().createQuery("select u from User u order by upper(u.username)");
        return q.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Query q = getEntityManager().createQuery("select u from User u where username=?");
        q.setParameter(1, username);
        List<User> users = q.getResultList();
        if (users == null || users.isEmpty()) {
            throw new UsernameNotFoundException("user '" + username + "' not found...");
        } else {
            return users.get(0);
        }
    }

    /**
     * @param user the user to save
     * @return the updated user
     */
    public User saveUser(User user) {
        User u = super.save(user);
        getEntityManager().flush();
        return u;
    }

    /**
     * {@inheritDoc}
     */
    public String getUserPassword(String username) {
        SimpleJdbcTemplate jdbcTemplate = new SimpleJdbcTemplate(dataSource);
        Table table = AnnotationUtils.findAnnotation(User.class, Table.class);
        return jdbcTemplate.queryForObject(
                "select password from " + table.name() + " where username=?", String.class, username);
    }
}
