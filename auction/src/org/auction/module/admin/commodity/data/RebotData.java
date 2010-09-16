package org.auction.module.admin.commodity.data;

import java.util.ArrayList;
import java.util.List;

import org.mobile.common.action.GeneralData;

public class RebotData extends GeneralData {

	private String id;
	private String rebotname;
	private String email;
	private String telphone;
	private Long startprice;
	private Long endprice;
	private Integer auctiontime;
	private String methodName;

	private List<RebotData> dataList = new ArrayList<RebotData>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRebotname() {
		return rebotname;
	}

	public void setRebotname(String rebotname) {
		this.rebotname = rebotname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public Long getStartprice() {
		return startprice;
	}

	public void setStartprice(Long startprice) {
		this.startprice = startprice;
	}

	public Long getEndprice() {
		return endprice;
	}

	public void setEndprice(Long endprice) {
		this.endprice = endprice;
	}

	public Integer getAuctiontime() {
		return auctiontime;
	}

	public void setAuctiontime(Integer auctiontime) {
		this.auctiontime = auctiontime;
	}

	public List<RebotData> getDataList() {
		return dataList;
	}

	public void setDataList(List<RebotData> dataList) {
		this.dataList = dataList;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

}
