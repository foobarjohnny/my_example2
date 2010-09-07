package org.auction.module.admin.commodity.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mobile.common.action.GeneralData;

public class OrderData extends GeneralData {

	private String id;
	private String ordernum;
	private Date ordertime;
	private String commodityName;
	private String comId;
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
	private BigDecimal comprice;
	private String selectType;
	private String summary;
	private String bidId;
	private String methodName;
	
	private String url;

	private List<OrderData> dataList = new ArrayList<OrderData>();

	public String getComId() {
		return comId;
	}

	public void setComId(String comId) {
		this.comId = comId;
	}

	public String getBidId() {
		return bidId;
	}

	public void setBidId(String bidId) {
		this.bidId = bidId;
	}

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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
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

	public BigDecimal getFare() {
		return fare;
	}

	public void setFare(BigDecimal fare) {
		this.fare = fare;
	}

	public BigDecimal getTotalPrices() {
		return totalPrices;
	}

	public void setTotalPrices(BigDecimal totalPrices) {
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

	public BigDecimal getComprice() {
		return comprice;
	}

	public void setComprice(BigDecimal comprice) {
		this.comprice = comprice;
	}

	public String getSelectType() {
		return selectType;
	}

	public void setSelectType(String selectType) {
		this.selectType = selectType;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
