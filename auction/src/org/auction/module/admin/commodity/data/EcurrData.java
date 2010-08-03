package org.auction.module.admin.commodity.data;

import java.util.ArrayList;
import java.util.List;

import org.mobile.common.action.GeneralData;

public class EcurrData extends GeneralData {

	private String id;
	private Integer amount;
	private Long paymoney;
	private Integer freecount;
	private String remark;
	
	private List<EcurrData> dataList = new ArrayList<EcurrData>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Long getPaymoney() {
		return paymoney;
	}

	public void setPaymoney(Long paymoney) {
		this.paymoney = paymoney;
	}

	public Integer getFreecount() {
		return freecount;
	}

	public void setFreecount(Integer freecount) {
		this.freecount = freecount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<EcurrData> getDataList() {
		return dataList;
	}

	public void setDataList(List<EcurrData> dataList) {
		this.dataList = dataList;
	}

}
