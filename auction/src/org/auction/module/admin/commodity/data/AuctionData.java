package org.auction.module.admin.commodity.data;

import java.math.BigDecimal;

import org.mobile.common.action.GeneralData;

public class AuctionData extends GeneralData {

	private String userId;
	private String comptyId;
	private BigDecimal price = new BigDecimal(0);

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
}
