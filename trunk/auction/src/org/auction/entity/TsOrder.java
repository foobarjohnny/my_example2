package org.auction.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * TsOrder entity. @author MyEclipse Persistence Tools
 */

public class TsOrder implements java.io.Serializable {

	// Fields

	private String id;
	private TsCommodity tsCommodity;
	private String ordernum;
	private Date ordertime;
	private String pay;
	private BigDecimal amount;
	private String receiver;
	private String telphone;
	private String address;
	private String remard;
	private BigDecimal fare;
	private BigDecimal totalPrices;
	private String state;
	private String ordertype;
	private TsUser tsUser;
	private Integer ecount;

	// Constructors

	/** default constructor */
	public TsOrder() {
	}

	/** minimal constructor */
	public TsOrder(TsCommodity tsCommodity, Date ordertime) {
		this.tsCommodity = tsCommodity;
		this.ordertime = ordertime;
	}

	/** full constructor */
	public TsOrder(TsCommodity tsCommodity, String ordernum, Date ordertime,
			String pay, BigDecimal amount, String receiver, String telphone,
			String address, String remard, BigDecimal fare,
			BigDecimal totalPrices, String state, String ordertype) {
		this.tsCommodity = tsCommodity;
		this.ordernum = ordernum;
		this.ordertime = ordertime;
		this.pay = pay;
		this.amount = amount;
		this.receiver = receiver;
		this.telphone = telphone;
		this.address = address;
		this.remard = remard;
		this.fare = fare;
		this.totalPrices = totalPrices;
		this.state = state;
		this.ordertype = ordertype;
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

	public String getOrdernum() {
		return this.ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public Date getOrdertime() {
		return this.ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public String getPay() {
		return this.pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getTelphone() {
		return this.telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemard() {
		return this.remard;
	}

	public void setRemard(String remard) {
		this.remard = remard;
	}

	public BigDecimal getFare() {
		return this.fare;
	}

	public void setFare(BigDecimal fare) {
		this.fare = fare;
	}

	public BigDecimal getTotalPrices() {
		return this.totalPrices;
	}

	public void setTotalPrices(BigDecimal totalPrices) {
		this.totalPrices = totalPrices;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOrdertype() {
		return this.ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public TsUser getTsUser() {
		return tsUser;
	}

	public void setTsUser(TsUser tsUser) {
		this.tsUser = tsUser;
	}

	public Integer getEcount() {
		return ecount;
	}

	public void setEcount(Integer ecount) {
		this.ecount = ecount;
	}

}