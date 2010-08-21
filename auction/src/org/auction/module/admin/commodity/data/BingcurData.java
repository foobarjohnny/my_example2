package org.auction.module.admin.commodity.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mobile.common.action.GeneralData;

public class BingcurData extends GeneralData {

	private String id;
	private Date binddate;
	private BigDecimal price = new BigDecimal(0);;
	private Integer amount;
	private String user;
	private String comityName;
	private String summary;
	private BigDecimal prices = new BigDecimal(0);
	private BigDecimal percents = new BigDecimal(0);
	private BigDecimal markprices = new BigDecimal(0);
	private List<BingcurData> dataList = new ArrayList<BingcurData>();
	private List<BidingData> bidingList = new ArrayList<BidingData>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getBinddate() {
		return binddate;
	}

	public void setBinddate(Date binddate) {
		this.binddate = binddate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
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

	public List<BingcurData> getDataList() {
		return dataList;
	}

	public void setDataList(List<BingcurData> dataList) {
		this.dataList = dataList;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public BigDecimal getPrices() {
		return prices;
	}

	public void setPrices(BigDecimal prices) {
		this.prices = prices;
	}

	public BigDecimal getPercents() {
		return percents;
	}

	public void setPercents(BigDecimal percents) {
		this.percents = percents;
	}

	public List<BidingData> getBidingList() {
		return bidingList;
	}

	public void setBidingList(List<BidingData> bidingList) {
		this.bidingList = bidingList;
	}

	public BigDecimal getMarkprices() {
		return markprices;
	}

	public void setMarkprices(BigDecimal markprices) {
		this.markprices = markprices;
	}
}
