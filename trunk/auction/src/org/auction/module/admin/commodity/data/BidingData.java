package org.auction.module.admin.commodity.data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.mobile.common.action.GeneralData;

public class BidingData extends GeneralData {

	private String id;
	private Long price;
	private Timestamp biddate;
	private String isbid;
	private String userId;
	private String username;
	private String commpityId;

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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Timestamp getBiddate() {
		return biddate;
	}

	public void setBiddate(Timestamp biddate) {
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

}
