package org.auction.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * TsBingcur entity. @author MyEclipse Persistence Tools
 */

public class TsBingcur implements java.io.Serializable {

	// Fields

	private String id;
	private TsCommodity tsCommodity;
	private TsUser tsUser;
	private Date binddate;
	private BigDecimal price;
	private Integer amount;
	private Integer free;

	// Constructors

	/** default constructor */
	public TsBingcur() {
	}

	/** minimal constructor */
	public TsBingcur(Date binddate) {
		this.binddate = binddate;
	}

	/** full constructor */
	public TsBingcur(TsCommodity tsCommodity, TsUser tsUser, Date binddate,
			BigDecimal price, Integer amount) {
		this.tsCommodity = tsCommodity;
		this.tsUser = tsUser;
		this.binddate = binddate;
		this.price = price;
		this.amount = amount;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TsCommodity getTsCommodity() {
		return this.tsCommodity;
	}

	public void setTsCommodity(TsCommodity tsCommodity) {
		this.tsCommodity = tsCommodity;
	}

	public TsUser getTsUser() {
		return this.tsUser;
	}

	public void setTsUser(TsUser tsUser) {
		this.tsUser = tsUser;
	}

	public Date getBinddate() {
		return this.binddate;
	}

	public void setBinddate(Date binddate) {
		this.binddate = binddate;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getFree() {
		return free;
	}

	public void setFree(Integer free) {
		this.free = free;
	}

}