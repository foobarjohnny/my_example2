package org.auction.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TsUser entity. @author MyEclipse Persistence Tools
 */

public class TsUser implements java.io.Serializable {

	// Fields

	private String id;
	private String username;
	private String password;
	private String realname;
	private String nickname;
	private String sex;
	private Date birthdate;
	private String telphone;
	private String safetycode;
	private String problem;
	private String answer;
	private String qq;
	private String email;
	private String address;
	private Date houroflogon;
	private Date lasttimelogon;
	private Date lasttimeip;
	private Integer paycur;
	private Integer freecur;
	private Set tsBingcurs = new HashSet(0);
	private Set tsBiddings = new HashSet(0);
	private Set tsBuies = new HashSet(0);
	private Set tsConsumes = new HashSet(0);
	private Set tsOrders = new HashSet(0);
	private Set tsAids = new HashSet(0);

	// Constructors

	/** default constructor */
	public TsUser() {
	}

	/** full constructor */
	public TsUser(String username, String password, String realname,
			String nickname, String sex, Date birthdate, String telphone,
			String safetycode, String problem, String answer, String qq,
			String email, String address, Date houroflogon, Date lasttimelogon,
			Date lasttimeip, Integer paycur, Integer freecur, Set tsBingcurs,
			Set tsBiddings, Set tsBuies) {
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.nickname = nickname;
		this.sex = sex;
		this.birthdate = birthdate;
		this.telphone = telphone;
		this.safetycode = safetycode;
		this.problem = problem;
		this.answer = answer;
		this.qq = qq;
		this.email = email;
		this.address = address;
		this.houroflogon = houroflogon;
		this.lasttimelogon = lasttimelogon;
		this.lasttimeip = lasttimeip;
		this.paycur = paycur;
		this.freecur = freecur;
		this.tsBingcurs = tsBingcurs;
		this.tsBiddings = tsBiddings;
		this.tsBuies = tsBuies;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getTelphone() {
		return this.telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getSafetycode() {
		return this.safetycode;
	}

	public void setSafetycode(String safetycode) {
		this.safetycode = safetycode;
	}

	public String getProblem() {
		return this.problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getHouroflogon() {
		return this.houroflogon;
	}

	public void setHouroflogon(Date houroflogon) {
		this.houroflogon = houroflogon;
	}

	public Date getLasttimelogon() {
		return this.lasttimelogon;
	}

	public void setLasttimelogon(Date lasttimelogon) {
		this.lasttimelogon = lasttimelogon;
	}

	public Date getLasttimeip() {
		return this.lasttimeip;
	}

	public void setLasttimeip(Date lasttimeip) {
		this.lasttimeip = lasttimeip;
	}

	public Integer getPaycur() {
		return this.paycur;
	}

	public void setPaycur(Integer paycur) {
		this.paycur = paycur;
	}

	public Integer getFreecur() {
		return this.freecur;
	}

	public void setFreecur(Integer freecur) {
		this.freecur = freecur;
	}

	public Set getTsBingcurs() {
		return this.tsBingcurs;
	}

	public void setTsBingcurs(Set tsBingcurs) {
		this.tsBingcurs = tsBingcurs;
	}

	public Set getTsBiddings() {
		return this.tsBiddings;
	}

	public void setTsBiddings(Set tsBiddings) {
		this.tsBiddings = tsBiddings;
	}

	public Set getTsBuies() {
		return this.tsBuies;
	}

	public void setTsBuies(Set tsBuies) {
		this.tsBuies = tsBuies;
	}

	public Set getTsConsumes() {
		return tsConsumes;
	}

	public void setTsConsumes(Set tsConsumes) {
		this.tsConsumes = tsConsumes;
	}

	public Set getTsOrders() {
		return tsOrders;
	}

	public void setTsOrders(Set tsOrders) {
		this.tsOrders = tsOrders;
	}

	/**
	 * @return the tsAids
	 */
	public Set getTsAids() {
		return tsAids;
	}

	/**
	 * @param tsAids the tsAids to set
	 */
	public void setTsAids(Set tsAids) {
		this.tsAids = tsAids;
	}
}