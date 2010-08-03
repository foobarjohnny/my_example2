package org.auction.entity;

import java.sql.Timestamp;

/**
 * TsBingcur entity. @author MyEclipse Persistence Tools
 */

public class TsBingcur implements java.io.Serializable {

	// Fields

	private String id;
	private TsCommodity tsCommodity;
	private TsUser tsUser;
	private Timestamp binddate;
	private Long price;
	private Integer amount;

	// Constructors

	/** default constructor */
	public TsBingcur() {
	}

	/** minimal constructor */
	public TsBingcur(Timestamp binddate) {
		this.binddate = binddate;
	}

	/** full constructor */
	public TsBingcur(TsCommodity tsCommodity, TsUser tsUser,
			Timestamp binddate, Long price, Integer amount) {
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

	public Timestamp getBinddate() {
		return this.binddate;
	}

	public void setBinddate(Timestamp binddate) {
		this.binddate = binddate;
	}

	public Long getPrice() {
		return this.price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}