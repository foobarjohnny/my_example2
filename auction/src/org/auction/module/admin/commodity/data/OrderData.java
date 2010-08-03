package org.auction.module.admin.commodity.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mobile.common.action.GeneralData;

public class OrderData extends GeneralData {

	private String id;
	private String ordernum;
	private Date ordertime;
	private String commodityName;
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
	
	private String methodName;

	private List<OrderData> dataList = new ArrayList<OrderData>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemard() {
		return remard;
	}

	public void setRemard(String remard) {
		this.remard = remard;
	}

	public Long getFare() {
		return fare;
	}

	public void setFare(Long fare) {
		this.fare = fare;
	}

	public Long getTotalPrices() {
		return totalPrices;
	}

	public void setTotalPrices(Long totalPrices) {
		this.totalPrices = totalPrices;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public List<OrderData> getDataList() {
		return dataList;
	}

	public void setDataList(List<OrderData> dataList) {
		this.dataList = dataList;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
}
