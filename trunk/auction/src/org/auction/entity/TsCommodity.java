package org.auction.entity;

import java.sql.Timestamp;
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

	/** full constructor */
	public TsCommodity(TsSort tsSort, String tradename, Long marketPrice,
			Long purchasePrice, Long markUp, Long consume, String restricts,
			Timestamp starttime, Integer endtime, String state,
			Integer addtimes, String summary, Set tsBingcurs, Set tsOrders,
			Set tsRebotcoms, Set tsBiddings) {
		this.tsSort = tsSort;
		this.tradename = tradename;
		this.marketPrice = marketPrice;
		this.purchasePrice = purchasePrice;
		this.markUp = markUp;
		this.consume = consume;
		this.restricts = restricts;
		this.starttime = starttime;
		this.endtime = endtime;
		this.state = state;
		this.addtimes = addtimes;
		this.summary = summary;
		this.tsBingcurs = tsBingcurs;
		this.tsOrders = tsOrders;
		this.tsRebotcoms = tsRebotcoms;
		this.tsBiddings = tsBiddings;
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

	public Long getMarketPrice() {
		return this.marketPrice;
	}

	public void setMarketPrice(Long marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Long getPurchasePrice() {
		return this.purchasePrice;
	}

	public void setPurchasePrice(Long purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Long getMarkUp() {
		return this.markUp;
	}

	public void setMarkUp(Long markUp) {
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

}