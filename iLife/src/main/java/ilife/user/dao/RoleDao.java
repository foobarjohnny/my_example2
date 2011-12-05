package ilife.user.dao;

import ilife.common.dao.GenericDao;
import ilife.user.model.Role;

/**
 * Role Data Access Object (DAO) interface.
 *
 */
public interface RoleDao extends GenericDao<Role, Long> {
    /**
     * @param rolename the rolename
     * @return populated role object
     */
    Role getRoleByName(String rolename);

    /**
     * Removes a role from the database by name
     * @param rolename the role's rolename
     */
    void removeRole(String rolename);
}
