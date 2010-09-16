package org.auction.module.admin.commodity.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mobile.common.action.GeneralData;

public class ShowcomData extends GeneralData {

	private String id;
	private String tradename;
	private String tradeId;
	private String userID;
	private String username;
	private String title;
	private String remark;
	private String aut;
	private Date creattime;
	private String bidId;
	private BigDecimal price = new BigDecimal(0);
	private Integer count;

	private BigDecimal mprice = new BigDecimal(0);

	private BigDecimal js = new BigDecimal(0);

	private List<ShowcomData> dataList = new ArrayList<ShowcomData>();

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

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAut() {
		return aut;
	}

	public void setAut(String aut) {
		this.aut = aut;
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public List<ShowcomData> getDataList() {
		return dataList;
	}

	public void setDataList(List<ShowcomData> dataList) {
		this.dataList = dataList;
	}

	public String getBidId() {
		return bidId;
	}

	public void setBidId(String bidId) {
		this.bidId = bidId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public BigDecimal getMprice() {
		return mprice;
	}

	public void setMprice(BigDecimal mprice) {
		this.mprice = mprice;
	}

	public BigDecimal getJs() {
		return js;
	}

	public void setJs(BigDecimal js) {
		this.js = js;
	}
}
