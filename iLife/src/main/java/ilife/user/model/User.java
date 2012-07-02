package ilife.user.model;

import ilife.common.model.LabelValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * This class represents the basic "user" object in AppFuse that allows for
 * authentication and user management. It implements Acegi Security's
 * UserDetails interface.
 * 
 */
@Entity
@Table(name = "t_user")
@NamedQueries({
		@NamedQuery(name = "findUserByName", query = "select obj from User obj where obj.username=:username"),
		@NamedQuery(name = "findPasswordByName", query = "select obj.password from User obj where obj.username=:username"),
		@NamedQuery(name = "findUserByCode", query = "select obj from User obj where obj.activationCode=:code"),
})
public class User implements UserDetails {

	private static final long serialVersionUID = 1586548162553407141L;
	
	private Long id;
	private String username; // required
	private String password; // required
	private String confirmPassword;
	private String passwordHint;
	private String firstName; // required
	private String lastName; // required
	private String email; // required; unique
	private String phoneNumber;
	private String website;
	private Set<Role> roles = new HashSet<Role>();
	private boolean enabled;
	private boolean accountExpired;
	private boolean accountLocked;
	private boolean credentialsExpired;
    private String  activationCode;

	private Set<Group> groups = new HashSet<Group>();
	
	/**
	 * Default constructor - creates a new instance with no values set.
	 */
	public User() {
	}

    public User(String username, String password, boolean enabled, boolean accountExpired,
            boolean credentialsExpired, boolean accountLocked, Set<? extends Role> authorities) {

        if (((username == null) || "".equals(username)) || (password == null)) {
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
        }

        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.accountExpired = accountExpired;
        this.credentialsExpired = credentialsExpired;
        this.accountLocked = accountLocked;
        this.roles = Collections.unmodifiableSet(authorities);
    }
	/**
	 * Create a new instance and set the username.
	 * 
	 * @param username
	 *            login name for user.
	 */
	public User(final String username) {
		this.username = username;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(nullable = false, length = 50, unique = true)
	public String getUsername() {
		return username;
	}

	@Column(nullable = false)
	public String getPassword() {
		return password;
	}

	@Transient
	public String getConfirmPassword() {
		return confirmPassword;
	}

	@Column(name = "password_hint")
	public String getPasswordHint() {
		return passwordHint;
	}

	@Column(name = "first_name", nullable = false, length = 50)
	public String getFirstName() {
		return firstName;
	}

	@Column(name = "last_name", nullable = false, length = 50)
	public String getLastName() {
		return lastName;
	}

	@Column(nullable = false, unique = true)
	public String getEmail() {
		return email;
	}

	@Column(name = "phone_number")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getWebsite() {
		return website;
	}

	/**
	 * Returns the full name.
	 * 
	 * @return firstName + ' ' + lastName
	 */
	@Transient
	public String getFullName() {
		return firstName + ' ' + lastName;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = @JoinColumn(name = "role_id"))
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * Convert user roles to LabelValue objects for convenience.
	 * 
	 * @return a list of LabelValue objects with role information
	 */
	@Transient
	public List<LabelValue> getRoleList() {
		List<LabelValue> userRoles = new ArrayList<LabelValue>();

		if (this.roles != null) {
			for (Role role : roles) {
				// convert the user's roles to LabelValue Objects
				userRoles.add(new LabelValue(role.getName(), role.getName()));
			}
		}

		return userRoles;
	}

	/**
	 * Adds a role for the user
	 * 
	 * @param role
	 *            the fully instantiated role
	 */
	public void addRole(Role role) {
		getRoles().add(role);
	}

	/**
	 * @return GrantedAuthority[] an array of roles.
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	@Transient
	public Set<GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new LinkedHashSet<GrantedAuthority>();
		authorities.addAll(roles);
		return authorities;
	}

	@Column(name = "account_enabled")
	public boolean isEnabled() {
		return enabled;
	}

	@Column(name = "account_expired", nullable = false)
	public boolean isAccountExpired() {
		return accountExpired;
	}

	/**
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 * @return true if account is still active
	 */
	@Transient
	public boolean isAccountNonExpired() {
		return !isAccountExpired();
	}

	@Column(name = "account_locked", nullable = false)
	public boolean isAccountLocked() {
		return accountLocked;
	}

	/**
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	 * @return false if account is locked
	 */
	@Transient
	public boolean isAccountNonLocked() {
		return !isAccountLocked();
	}

	@Column(name = "credentials_expired", nullable = false)
	public boolean isCredentialsExpired() {
		return credentialsExpired;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_group", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = @JoinColumn(name = "group_id"))
	public Set<Group> getGroups() {
		return groups;
	}
	@Column(name="activation_code",nullable=false,length=32)
	public String getActivationCode() {
		return activationCode;
	}

	/**
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
	 * @return true if credentials haven't expired
	 */
	@Transient
	public boolean isCredentialsNonExpired() {
		return !credentialsExpired;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setAccountExpired(boolean accountExpired) {
		this.accountExpired = accountExpired;
	}

	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	public void setCredentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}


	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}


	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof User)) {
			return false;
		}

		final User user = (User) o;

		return !(username != null ? !username.equals(user.getUsername())
				: user.getUsername() != null);

	}

	/**
	 * {@inheritDoc}
	 */
	public int hashCode() {
		return (username != null ? username.hashCode() : 0);
	}

}
