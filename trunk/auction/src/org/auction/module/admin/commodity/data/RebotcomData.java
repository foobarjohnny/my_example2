package org.auction.module.admin.commodity.data;

import org.mobile.common.action.GeneralData;

public class RebotcomData extends GeneralData {

	private String id;
	private Long startprice;
	private Long endprice;
	private Integer auctiontime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

}
