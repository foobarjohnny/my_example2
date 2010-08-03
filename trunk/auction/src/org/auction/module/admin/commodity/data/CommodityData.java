package org.auction.module.admin.commodity.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mobile.common.action.GeneralData;

public class CommodityData extends GeneralData {

	private String id;
	private String tradename;
	private Long marketPrice;
	private Long purchasePrice;
	private Long markUp;
	private Long consume;
	private String restricts;
	private Date starttime;
	private Integer endtime;
	private String state;
	private Integer addtimes;
	private String summary;
	private String methodName;
	private String sortId;
	private String sortName;
	private String searchName;

	private List<CommodityData> dataList = new ArrayList<CommodityData>();
	private List<SortData> sortList = new ArrayList<SortData>();

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

	public Long getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(Long marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Long getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Long purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Long getMarkUp() {
		return markUp;
	}

	public void setMarkUp(Long markUp) {
		this.markUp = markUp;
	}

	public Long getConsume() {
		return consume;
	}

	public void setConsume(Long consume) {
		this.consume = consume;
	}

	public String getRestricts() {
		return restricts;
	}

	public void setRestricts(String restricts) {
		this.restricts = restricts;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Integer getEndtime() {
		return endtime;
	}

	public void setEndtime(Integer endtime) {
		this.endtime = endtime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getAddtimes() {
		return addtimes;
	}

	public void setAddtimes(Integer addtimes) {
		this.addtimes = addtimes;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getSortId() {
		return sortId;
	}

	public void setSortId(String sortId) {
		this.sortId = sortId;
	}

	public List<CommodityData> getDataList() {
		return dataList;
	}

	public void setDataList(List<CommodityData> dataList) {
		this.dataList = dataList;
	}

	public List<SortData> getSortList() {
		return sortList;
	}

	public void setSortList(List<SortData> sortList) {
		this.sortList = sortList;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
}
