package org.auction.module.admin.user.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mobile.common.action.GeneralData;

public class UserAccountData extends GeneralData {

	private Integer paycur;
	private Integer freecur;

	private String id;
	private Date buytime;
	private String remark;
	private String buytype;
	private Integer amount;

	private List<UserAccountData> dataList = new ArrayList<UserAccountData>();

	public Integer getPaycur() {
		return paycur;
	}

	public void setPaycur(Integer paycur) {
		this.paycur = paycur;
	}

	public Integer getFreecur() {
		return freecur;
	}

	public void setFreecur(Integer freecur) {
		this.freecur = freecur;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getBuytime() {
		return buytime;
	}

	public void setBuytime(Date buytime) {
		this.buytime = buytime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBuytype() {
		return buytype;
	}

	public void setBuytype(String buytype) {
		this.buytype = buytype;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public List<UserAccountData> getDataList() {
		return dataList;
	}

	public void setDataList(List<UserAccountData> dataList) {
		this.dataList = dataList;
	}
}
