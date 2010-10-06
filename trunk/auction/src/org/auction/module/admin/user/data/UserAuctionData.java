package org.auction.module.admin.user.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.auction.module.admin.commodity.data.BidingData;
import org.auction.module.admin.view.data.ViewData;
import org.mobile.common.action.GeneralData;

public class UserAuctionData extends GeneralData {

	private String id;
	private String tradename;
	private Date binddate;
	private BigDecimal price = new BigDecimal(0);;
	private Integer amount;
	private String user;
	private String comityName;
	private String summary;
	private Integer addtime;
	private BigDecimal markup = new BigDecimal(0);
	private BigDecimal prices = new BigDecimal(0);
	private BigDecimal percents = new BigDecimal(0);
	private BigDecimal markprices = new BigDecimal(0);
	private String state;
	private String orderId;
	private String bidId;
	private String[] image;
	private String type;
	private Long remaining;
	private String tradeState;
	private BigDecimal buyprices = new BigDecimal(0);
	@SuppressWarnings("unchecked")
	private List imagesPath;

	private List<UserAuctionData> dataList = new ArrayList<UserAuctionData>();

	private List<ViewData> tradeData = new ArrayList<ViewData>();

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

	public Date getBinddate() {
		return binddate;
	}

	public void setBinddate(Date binddate) {
		this.binddate = binddate;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public List<UserAuctionData> getDataList() {
		return dataList;
	}

	public void setDataList(List<UserAuctionData> dataList) {
		this.dataList = dataList;
	}

	public List<ViewData> getTradeData() {
		return tradeData;
	}

	public void setTradeData(List<ViewData> tradeData) {
		this.tradeData = tradeData;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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

	public BigDecimal getMarkprices() {
		return markprices;
	}

	public void setMarkprices(BigDecimal markprices) {
		this.markprices = markprices;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getBidId() {
		return bidId;
	}

	public void setBidId(String bidId) {
		this.bidId = bidId;
	}

	public BigDecimal getMarkup() {
		return markup;
	}

	public void setMarkup(BigDecimal markup) {
		this.markup = markup;
	}

	public Integer getAddtime() {
		return addtime;
	}

	public void setAddtime(Integer addtime) {
		this.addtime = addtime;
	}

	public String[] getImage() {
		return image;
	}

	public void setImage(String[] image) {
		this.image = image;
	}

	public List<BidingData> getBidingList() {
		return bidingList;
	}

	public void setBidingList(List<BidingData> bidingList) {
		this.bidingList = bidingList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getBuyprices() {
		return buyprices;
	}

	public void setBuyprices(BigDecimal buyprices) {
		this.buyprices = buyprices;
	}

	public Long getRemaining() {
		return remaining;
	}

	public void setRemaining(Long remaining) {
		this.remaining = remaining;
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

}
