package org.auction.entity;

import java.math.BigDecimal;

/**
 * TsAid entity. @author MyEclipse Persistence Tools
 */

public class TsAid implements java.io.Serializable {

	// Fields

	private String id;
	private String comid;
	private String userid;
	private String etype;
	private BigDecimal startPirce = new BigDecimal(0);
	private BigDecimal endPrice = new BigDecimal(0);
	private String state;
	private Integer ecount;
	private Integer paycount;
	private TsUser tsUser;
	private TsCommodity tsCommodity;

	// Constructors

	/** default constructor */
	public TsAid() {
	}

	/** full constructor */
	public TsAid(String comid, String userid, String etype, BigDecimal startPirce, BigDecimal endPrice, String state) {
		this.comid = comid;
		this.userid = userid;
		this.etype = etype;
		this.startPirce = startPirce;
		this.endPrice = endPrice;
		this.state = state;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComid() {
		return this.comid;
	}

	public void setComid(String comid) {
		this.comid = comid;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getEtype() {
		return this.etype;
	}

	public void setEtype(String etype) {
		this.etype = etype;
	}

	public BigDecimal getStartPirce() {
		return this.startPirce;
	}

	public void setStartPirce(BigDecimal startPirce) {
		this.startPirce = startPirce;
	}

	public BigDecimal getEndPrice() {
		return this.endPrice;
	}

	public void setEndPrice(BigDecimal endPrice) {
		this.endPrice = endPrice;
	}

	/**
	 * @return the tsUser
	 */
	public TsUser getTsUser() {
		return tsUser;
	}

	/**
	 * @param tsUser the tsUser to set
	 */
	public void setTsUser(TsUser tsUser) {
		this.tsUser = tsUser;
	}

	/**
	 * @return the tsCommodity
	 */
	public TsCommodity getTsCommodity() {
		return tsCommodity;
	}

	/**
	 * @param tsCommodity the tsCommodity to set
	 */
	public void setTsCommodity(TsCommodity tsCommodity) {
		this.tsCommodity = tsCommodity;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the ecount
	 */
	public Integer getEcount() {
		return ecount;
	}

	/**
	 * @param ecount the ecount to set
	 */
	public void setEcount(Integer ecount) {
		this.ecount = ecount;
	}

	/**
	 * @return the paycount
	 */
	public Integer getPaycount() {
		return paycount;
	}

	/**
	 * @param paycount the paycount to set
	 */
	public void setPaycount(Integer paycount) {
		this.paycount = paycount;
	}

}