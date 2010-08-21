package org.auction.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TsCommodity entity. @author MyEclipse Persistence Tools
 */

public class TsCommodity implements java.io.Serializable {

	// Fields

	private String id;
	private TsSort tsSort;
	private String tradename;
	private BigDecimal marketPrice = new BigDecimal(0);
	private BigDecimal purchasePrice = new BigDecimal(0);
	private BigDecimal markUp = new BigDecimal(0);
	private BigDecimal prices = new BigDecimal(0);
	private Long consume;
	private String restricts;
	private Date starttime;
	private Date overtime;
	private Integer endtime;
	private String state;
	private Integer addtimes;
	private String summary;
	private String deleteif;
	private Set tsBingcurs = new HashSet(0);
	private Set tsOrders = new HashSet(0);
	private Set tsRebotcoms = new HashSet(0);
	private Set tsBiddings = new HashSet(0);

	// Constructors

	/** default constructor */
	public TsCommodity() {
	}

	/** minimal constructor */
	public TsCommodity(Date starttime) {
		this.starttime = starttime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TsSort getTsSort() {
		return this.tsSort;
	}

	public void setTsSort(TsSort tsSort) {
		this.tsSort = tsSort;
	}

	public String getTradename() {
		return this.tradename;
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
		return this.consume;
	}

	public void setConsume(Long consume) {
		this.consume = consume;
	}

	public String getRestricts() {
		return this.restricts;
	}

	public void setRestricts(String restricts) {
		this.restricts = restricts;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Integer getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Integer endtime) {
		this.endtime = endtime;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getAddtimes() {
		return this.addtimes;
	}

	public void setAddtimes(Integer addtimes) {
		this.addtimes = addtimes;
	}

	public String getSummary() {
		return this.summary;
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

	public Set getTsBingcurs() {
		return this.tsBingcurs;
	}

	public void setTsBingcurs(Set tsBingcurs) {
		this.tsBingcurs = tsBingcurs;
	}

	public Set getTsOrders() {
		return this.tsOrders;
	}

	public void setTsOrders(Set tsOrders) {
		this.tsOrders = tsOrders;
	}

	public Set getTsRebotcoms() {
		return this.tsRebotcoms;
	}

	public void setTsRebotcoms(Set tsRebotcoms) {
		this.tsRebotcoms = tsRebotcoms;
	}

	public Set getTsBiddings() {
		return this.tsBiddings;
	}

	public void setTsBiddings(Set tsBiddings) {
		this.tsBiddings = tsBiddings;
	}

	public Date getOvertime() {
		return overtime;
	}

	public void setOvertime(Date overtime) {
		this.overtime = overtime;
	}

	public BigDecimal getPrices() {
		return prices;
	}

	public void setPrices(BigDecimal prices) {
		this.prices = prices;
	}

}