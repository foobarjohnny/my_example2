package org.auction.module.admin.commodity.data;

import java.math.BigDecimal;
import java.util.Date;

import org.mobile.common.action.GeneralData;

public class AuctionData extends GeneralData {

	private String userId;
	private String comptyId;
	private BigDecimal price = new BigDecimal(0);
	private Date data;

	private boolean isAdd = false;
	
	private int time;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getComptyId() {
		return comptyId;
	}

	public void setComptyId(String comptyId) {
		this.comptyId = comptyId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isAdd() {
		return isAdd;
	}

	public void setAdd(boolean isAdd) {
		this.isAdd = isAdd;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

}
