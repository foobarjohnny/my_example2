package org.auction.module.manager.data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 上架竞拍商品，数据保存在缓存中
 * 
 * @author ThinkPad
 * 
 */
public class TradeData  {
	// 商品信息
	private String id;
	private String tradename;
	private BigDecimal marketPrice = new BigDecimal(0);
	private BigDecimal purchasePrice = new BigDecimal(0);
	private BigDecimal markUp = new BigDecimal(0);
	private Long consume;
	private String restricts;
	private Date starttime;
	private Date overtime;
	private Integer endtime;
	private String state;
	private Integer addtimes;
	private String summary;
	private String deleteif;
	// 当前竞拍信息
	private String bid;
	private BigDecimal price = new BigDecimal(0);
	private Date biddate;
	private String isbid;
	// 当前竞拍用户信息
	private String uid;
	private String username;

	// 增加时间
	private boolean isAdd;
	// 竞拍结束
	private boolean finshed = false;

	// 是否生成订单
	private boolean order = false;

	private boolean over = false;

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

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getMarkUp() {
		return markUp;
	}

	public void setMarkUp(BigDecimal markUp) {
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

	public Date getOvertime() {
		return overtime;
	}

	public void setOvertime(Date overtime) {
		this.overtime = overtime;
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

	public String getDeleteif() {
		return deleteif;
	}

	public void setDeleteif(String deleteif) {
		this.deleteif = deleteif;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getBiddate() {
		return biddate;
	}

	public void setBiddate(Date biddate) {
		this.biddate = biddate;
	}

	public String getIsbid() {
		return isbid;
	}

	public void setIsbid(String isbid) {
		this.isbid = isbid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isAdd() {
		return isAdd;
	}

	public void setAdd(boolean isAdd) {
		this.isAdd = isAdd;
	}

	public boolean isOver() {
		return over;
	}

	public void setOver(boolean over) {
		this.over = over;
	}

	public boolean isFinshed() {
		return finshed;
	}

	public void setFinshed(boolean finshed) {
		this.finshed = finshed;
	}

	public boolean isOrder() {
		return order;
	}

	public void setOrder(boolean order) {
		this.order = order;
	}

}
