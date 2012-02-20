package ilife.user.dao.impl;

import ilife.common.dao.impl.GenericDaoImpl;
import ilife.user.dao.RoleDao;
import ilife.user.model.Role;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;


/**
 * This class interacts with Spring's HibernateTemplate to save/delete and
 * retrieve Role objects.
 *
 */
@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role, Long> implements RoleDao {

    public RoleDaoImpl() {
        super(Role.class);
    }

    /**
     * {@inheritDoc}
     */
    public Role getRoleByName(String rolename) {
        Query q = getEntityManager().createQuery("select r from Role r where r.name = ?");
        q.setParameter(1, rolename);
        List roles = q.getResultList();

        if (roles.isEmpty()) {
            return null;
        } else {
            return (Role) roles.get(0);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void removeRole(String rolename) {
        Object role = getRoleByName(rolename);
        getEntityManager().remove(role);
    }
}
