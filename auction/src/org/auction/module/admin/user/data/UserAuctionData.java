package org.auction.module.admin.user.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mobile.common.action.GeneralData;

public class UserAuctionData extends GeneralData {

	private String id;
	private String tradename;
	private Date binddate;
	private Long price;
	private Integer amount;

	private List<UserAuctionData> dataList = new ArrayList<UserAuctionData>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTradename() {
		return tradename;
	}

	public void setTradename(String tradename) {
		this.tradename = tradename;
	}

	public Date getBinddate() {
		return binddate;
	}

	public void setBinddate(Date binddate) {
		this.binddate = binddate;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public List<UserAuctionData> getDataList() {
		return dataList;
	}

	public void setDataList(List<UserAuctionData> dataList) {
		this.dataList = dataList;
	}

}
