package org.auction.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * TsBidding entity. @author MyEclipse Persistence Tools
 */

public class TsBidding implements java.io.Serializable {

	// Fields

	private String id;
	private TsCommodity tsCommodity;
	private TsUser tsUser;
	private BigDecimal price;
	private Date biddate;
	private String isbid;
	private String bidtype;

	// Constructors

	/** default constructor */
	public TsBidding() {
	}

	/** minimal constructor */
	public TsBidding(Date biddate) {
		this.biddate = biddate;
	}

	/** full constructor */
	public TsBidding(TsCommodity tsCommodity, TsUser tsUser, BigDecimal price,
			Date biddate, String isbid) {
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

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getBiddate() {
		return this.biddate;
	}

	public void setBiddate(Date biddate) {
		this.biddate = biddate;
	}

	public String getIsbid() {
		return this.isbid;
	}

	public void setIsbid(String isbid) {
		this.isbid = isbid;
	}

	public String getBidtype() {
		return bidtype;
	}

	public void setBidtype(String bidtype) {
		this.bidtype = bidtype;
	}

}