package org.auction.entity;

/**
 * TsEcu entity. @author MyEclipse Persistence Tools
 */

public class TsEcu implements java.io.Serializable {

	// Fields

	private String id;
	private TsEcurr tsEcurr;
	private TsUser tsUser;
	private String state;

	// Constructors

	/** default constructor */
	public TsEcu() {
	}

	/** full constructor */
	public TsEcu(TsEcurr tsEcurr, TsUser tsUser) {
		this.tsEcurr = tsEcurr;
		this.tsUser = tsUser;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TsEcurr getTsEcurr() {
		return this.tsEcurr;
	}

	public void setTsEcurr(TsEcurr tsEcurr) {
		this.tsEcurr = tsEcurr;
	}

	public TsUser getTsUser() {
		return this.tsUser;
	}

	public void setTsUser(TsUser tsUser) {
		this.tsUser = tsUser;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}