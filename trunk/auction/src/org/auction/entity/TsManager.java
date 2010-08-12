package org.auction.entity;

/**
 * TsManager entity. @author MyEclipse Persistence Tools
 */

public class TsManager implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private String id;
	private String account;
	private String password;
	private String realname;
	private String telphone;
	private String managerFun;

	// Constructors

	/** default constructor */
	public TsManager() {
	}

	/** full constructor */
	public TsManager(String account, String password, String realname,
			String telphone, String managerFun) {
		this.account = account;
		this.password = password;
		this.realname = realname;
		this.telphone = telphone;
		this.managerFun = managerFun;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getTelphone() {
		return this.telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getManagerFun() {
		return this.managerFun;
	}

	public void setManagerFun(String managerFun) {
		this.managerFun = managerFun;
	}

}