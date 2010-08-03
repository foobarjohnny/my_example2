package org.auction.module.admin.commodity.data;

import java.sql.Timestamp;

import org.auction.entity.TsUser;
import org.mobile.common.action.GeneralData;

public class BidingData extends GeneralData {

	private String id;
	private TsUser tsUser;
	private Long price;
	private Timestamp biddate;
	private String isbid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TsUser getTsUser() {
		return tsUser;
	}

	public void setTsUser(TsUser tsUser) {
		this.tsUser = tsUser;
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

}
