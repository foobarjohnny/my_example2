package org.auction.entity;

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
	private Long amount;
	private String receiver;
	private String telphone;
	private String address;
	private String remard;
	private Long fare;
	private Long totalPrices;
	private String state;
	private String ordertype;

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
	public TsOrder(TsCommodity tsCommodity, String ordernum,
			Date ordertime, String pay, Long amount, String receiver,
			String telphone, String address, String remard, Long fare,
			Long totalPrices, String state, String ordertype) {
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

	public Long getAmount() {
		return this.amount;
	}

	public void setAmount(Long amount) {
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

	public Long getFare() {
		return this.fare;
	}

	public void setFare(Long fare) {
		this.fare = fare;
	}

	public Long getTotalPrices() {
		return this.totalPrices;
	}

	public void setTotalPrices(Long totalPrices) {
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

}