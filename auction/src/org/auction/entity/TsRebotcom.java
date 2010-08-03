package org.auction.entity;

/**
 * TsRebotcom entity. @author MyEclipse Persistence Tools
 */

public class TsRebotcom implements java.io.Serializable {

	// Fields

	private String id;
	private TsCommodity tsCommodity;
	private TsRobot tsRobot;
	private Long startprice;
	private Long endprice;
	private Integer auctiontime;

	// Constructors

	/** default constructor */
	public TsRebotcom() {
	}

	/** full constructor */
	public TsRebotcom(TsCommodity tsCommodity, TsRobot tsRobot,
			Long startprice, Long endprice, Integer auctiontime) {
		this.tsCommodity = tsCommodity;
		this.tsRobot = tsRobot;
		this.startprice = startprice;
		this.endprice = endprice;
		this.auctiontime = auctiontime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TsCommodity getTsCommodity() {
		return this.tsCommodity;
	}

	public void setTsCommodity(TsCommodity tsCommodity) {
		this.tsCommodity = tsCommodity;
	}

	public TsRobot getTsRobot() {
		return this.tsRobot;
	}

	public void setTsRobot(TsRobot tsRobot) {
		this.tsRobot = tsRobot;
	}

	public Long getStartprice() {
		return this.startprice;
	}

	public void setStartprice(Long startprice) {
		this.startprice = startprice;
	}

	public Long getEndprice() {
		return this.endprice;
	}

	public void setEndprice(Long endprice) {
		this.endprice = endprice;
	}

	public Integer getAuctiontime() {
		return this.auctiontime;
	}

	public void setAuctiontime(Integer auctiontime) {
		this.auctiontime = auctiontime;
	}

}