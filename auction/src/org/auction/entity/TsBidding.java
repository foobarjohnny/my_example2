package org.auction.entity;

import java.sql.Timestamp;

/**
 * TsBidding entity. @author MyEclipse Persistence Tools
 */

public class TsBidding implements java.io.Serializable {

	// Fields

	private String id;
	private TsCommodity tsCommodity;
	private TsUser tsUser;
	private Long price;
	private Timestamp biddate;
	private String isbid;

	// Constructors

	/** default constructor */
	public TsBidding() {
	}

	/** minimal constructor */
	public TsBidding(Timestamp biddate) {
		this.biddate = biddate;
	}

	/** full constructor */
	public TsBidding(TsCommodity tsCommodity, TsUser tsUser, Long price,
			Timestamp biddate, String isbid) {
		this.tsCommodity = tsCommodity;
		this.tsUser = tsUser;
		this.price = price;
		this.biddate = biddate;
		this.isbid = isbid;
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

	public TsUser getTsUser() {
		return this.tsUser;
	}

	public void setTsUser(TsUser tsUser) {
		this.tsUser = tsUser;
	}

	public Long getPrice() {
		return this.price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Timestamp getBiddate() {
		return this.biddate;
	}

	public void setBiddate(Timestamp biddate) {
		this.biddate = biddate;
	}

	public String getIsbid() {
		return this.isbid;
	}

	public void setIsbid(String isbid) {
		this.isbid = isbid;
	}

}