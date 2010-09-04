package org.auction.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * TsPublis entity. @author MyEclipse Persistence Tools
 */

public class TsPublis implements java.io.Serializable {

	// Fields

	private String id;
	private String remark;
	private String state;
	private Long amount;
	private String tradename;
	private BigDecimal price;
	private Date starttime;

	// Constructors

	/** default constructor */
	public TsPublis() {
	}

	/** full constructor */
	public TsPublis(String remark, String state, Long amount, String tradename,
			BigDecimal price, Date starttime) {
		this.remark = remark;
		this.state = state;
		this.amount = amount;
		this.tradename = tradename;
		this.price = price;
		this.starttime = starttime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getAmount() {
		return this.amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getTradename() {
		return this.tradename;
	}

	public void setTradename(String tradename) {
		this.tradename = tradename;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

}