package org.auction.module.admin.commodity.data;

import java.sql.Timestamp;

import org.mobile.common.action.GeneralData;

public class BingcurData extends GeneralData {

	private String id;
	private Timestamp binddate;
	private Long price;
	private Integer amount;
	private String user;
	private String comityName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getBinddate() {
		return binddate;
	}

	public void setBinddate(Timestamp binddate) {
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getComityName() {
		return comityName;
	}

	public void setComityName(String comityName) {
		this.comityName = comityName;
	}
}
