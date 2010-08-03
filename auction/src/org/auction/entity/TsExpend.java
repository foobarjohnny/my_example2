package org.auction.entity;

import java.sql.Timestamp;

/**
 * TsExpend entity. @author MyEclipse Persistence Tools
 */

public class TsExpend implements java.io.Serializable {

	// Fields

	private String id;
	private Long price;
	private Timestamp extdate;
	private String item;

	// Constructors

	/** default constructor */
	public TsExpend() {
	}

	/** full constructor */
	public TsExpend(Long price, Timestamp extdate, String item) {
		this.price = price;
		this.extdate = extdate;
		this.item = item;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getPrice() {
		return this.price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Timestamp getExtdate() {
		return this.extdate;
	}

	public void setExtdate(Timestamp extdate) {
		this.extdate = extdate;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

}