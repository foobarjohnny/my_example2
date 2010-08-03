package org.auction.entity;

/**
 * TsEcurr entity. @author MyEclipse Persistence Tools
 */

public class TsEcurr implements java.io.Serializable {

	// Fields

	private String id;
	private Integer amount;
	private Long paymoney;
	private Integer freecount;
	private String remark;

	// Constructors

	/** default constructor */
	public TsEcurr() {
	}

	/** full constructor */
	public TsEcurr(Integer amount, Long paymoney, Integer freecount,
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

	public Long getPaymoney() {
		return this.paymoney;
	}

	public void setPaymoney(Long paymoney) {
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