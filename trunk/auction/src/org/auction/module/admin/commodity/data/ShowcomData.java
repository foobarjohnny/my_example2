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
	private Integer adde;
	private String summary;
	/** 市场价 */
	private BigDecimal prices = new BigDecimal(0);
	/** 节省价格 */
	private BigDecimal percents = new BigDecimal(0);
	/** 成交价 */
	private BigDecimal markprices = new BigDecimal(0);
	/** 免费E币 */
	private Integer free;
	/** 付费E币 */
	private Integer pay;

	@SuppressWarnings("unchecked")
	private List imagesPath;

	private String tradeState;

	private BigDecimal mprice = new BigDecimal(0);

	private BigDecimal js = new BigDecimal(0);

	private List<ShowcomData> dataList = new ArrayList<ShowcomData>();
	
	private List<BidingData> bidingList = new ArrayList<BidingData>();

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

	public Integer getAdde() {
		return adde;
	}

	public void setAdde(Integer adde) {
		this.adde = adde;
	}

	@SuppressWarnings("unchecked")
	public List getImagesPath() {
		return imagesPath;
	}

	@SuppressWarnings("unchecked")
	public void setImagesPath(List imagesPath) {
		this.imagesPath = imagesPath;
	}

	public String getTradeState() {
		return tradeState;
	}

	public void setTradeState(String tradeState) {
		this.tradeState = tradeState;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<BidingData> getBidingList() {
		return bidingList;
	}

	public void setBidingList(List<BidingData> bidingList) {
		this.bidingList = bidingList;
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

	public BigDecimal getMarkprices() {
		return markprices;
	}

	public void setMarkprices(BigDecimal markprices) {
		this.markprices = markprices;
	}

	public Integer getFree() {
		return free;
	}

	public void setFree(Integer free) {
		this.free = free;
	}

	public Integer getPay() {
		return pay;
	}

	public void setPay(Integer pay) {
		this.pay = pay;
	}
}
