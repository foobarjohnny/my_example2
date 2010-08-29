package org.auction.entity;

import java.util.Date;

/**
 * TsBuy entity. @author MyEclipse Persistence Tools
 */

public class TsConsume implements java.io.Serializable {

	// Fields

	private String id;
	private TsUser tsUser;
	private Date buytime;
	private String remark;
	private String buytype;
	private Integer amount;
	private TsCommodity tsCommodity;

	// Constructors

	/** default constructor */
	public TsConsume() {
	}

	/** minimal constructor */
	public TsConsume(Date buytime) {
		this.buytime = buytime;
	}

	/** full constructor */
	public TsConsume(TsUser tsUser, Date buytime, String remark,
			String buytype, Integer amount) {
		this.tsUser = tsUser;
		this.buytime = buytime;
		this.remark = remark;
		this.buytype = buytype;
		this.amount = amount;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TsUser getTsUser() {
		return this.tsUser;
	}

	public void setTsUser(TsUser tsUser) {
		this.tsUser = tsUser;
	}

	public Date getBuytime() {
		return this.buytime;
	}

	public void setBuytime(Date buytime) {
		this.buytime = buytime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBuytype() {
		return this.buytype;
	}

	public void setBuytype(String buytype) {
		this.buytype = buytype;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public TsCommodity getTsCommodity() {
		return tsCommodity;
	}

	public void setTsCommodity(TsCommodity tsCommodity) {
		this.tsCommodity = tsCommodity;
	}

}