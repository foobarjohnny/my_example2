package com.epaide.security.dao;

import com.epaide.security.model.Role;

public interface RoleDao {
	public abstract Role getRoleByName(String name);

	public abstract void removeRole(String name);
}
