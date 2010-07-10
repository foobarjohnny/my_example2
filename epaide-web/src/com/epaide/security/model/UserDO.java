package com.epaide.security.model;

import java.util.Date;
import java.util.Set;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.userdetails.User;

/**
 * 
 * @author paragon
 * 
 */
public class UserDO  {

	private String email;

	private String activationCode;

	private Date registeredAt;
	
	private Set<Role> roles;

	public Set<Role> getRoles() {
		return roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public Date getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(Date registeredAt) {
		this.registeredAt = registeredAt;
	}

}
