package org.auction.module.admin.view.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.auction.module.admin.commodity.data.PublisData;
import org.auction.module.manager.data.TradeData;
import org.mobile.common.action.GeneralData;

public class ViewData extends GeneralData {

	private String id;
	private String tradename;
	private Long remaining;
	private BigDecimal marketPrice = new BigDecimal(0);
	private String descript;

	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private int second;
	private long temp;
	
	@SuppressWarnings("unchecked")
	private List imagesPath;

	private List<ViewData> dataList = new ArrayList<ViewData>();
	
	private List<PublisData> publisList = new ArrayList<PublisData>();

	private List<TradeData> tradeList = new ArrayList<TradeData>();

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

	public List<ViewData> getDataList() {
		return dataList;
	}

	public void setDataList(List<ViewData> dataList) {
		this.dataList = dataList;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public long getTemp() {
		return temp;
	}

	public void setTemp(long temp) {
		this.temp = temp;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Long getRemaining() {
		return remaining;
	}

	public void setRemaining(Long remaining) {
		this.remaining = remaining;
	}

	public List<TradeData> getTradeList() {
		return tradeList;
	}

	public void setTradeList(List<TradeData> tradeList) {
		this.tradeList = tradeList;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	@SuppressWarnings("unchecked")
	public List getImagesPath() {
		return imagesPath;
	}

	@SuppressWarnings("unchecked")
	public void setImagesPath(List imagesPath) {
		this.imagesPath = imagesPath;
	}

	public List<PublisData> getPublisList() {
		return publisList;
	}

	public void setPublisList(List<PublisData> publisList) {
		this.publisList = publisList;
	}

}
