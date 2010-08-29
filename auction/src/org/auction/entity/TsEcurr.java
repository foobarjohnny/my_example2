package org.auction.entity;

import java.math.BigDecimal;

/**
 * TsEcurr entity. @author MyEclipse Persistence Tools
 */

public class TsEcurr implements java.io.Serializable {

	// Fields

	private String id;
	private Integer amount;
	private BigDecimal paymoney;
	private Integer freecount;
	private String remark;

	// Constructors

	/** default constructor */
	public TsEcurr() {
	}

	/** full constructor */
	public TsEcurr(Integer amount, BigDecimal paymoney, Integer freecount,
			String remark) {
		this.amount = amount;
		this.paymoney = paymoney;
		this.freecount = freecount;
		this.remark = remark;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public BigDecimal getPaymoney() {
		return this.paymoney;
	}

	public void setPaymoney(BigDecimal paymoney) {
		this.paymoney = paymoney;
	}

	public Integer getFreecount() {
		return this.freecount;
	}

	public void setFreecount(Integer freecount) {
		this.freecount = freecount;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}