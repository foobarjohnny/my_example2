package org.auction.module.admin.commodity.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mobile.common.action.GeneralData;

public class BidingData extends GeneralData {

	private String id;
	private BigDecimal price;
	private Date biddate;
	private String isbid;
	private String userId;
	private String username;
	private String commpityId;
	private String displayTime;
	public String isFinish;

	private int time;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@SuppressWarnings("unchecked")
	private List list = new ArrayList();

	@SuppressWarnings("unchecked")
	public List getList() {
		return list;
	}

	@SuppressWarnings("unchecked")
	public void setList(List list) {
		this.list = list;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getBiddate() {
		return biddate;
	}

	public void setBiddate(Date biddate) {
		this.biddate = biddate;
	}

	public String getIsbid() {
		return isbid;
	}

	public void setIsbid(String isbid) {
		this.isbid = isbid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCommpityId() {
		return commpityId;
	}

	public void setCommpityId(String commpityId) {
		this.commpityId = commpityId;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getDisplayTime() {
		return displayTime;
	}

	public void setDisplayTime(String displayTime) {
		this.displayTime = displayTime;
	}

}
