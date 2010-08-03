package org.auction.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TsRobot entity. @author MyEclipse Persistence Tools
 */

public class TsRobot implements java.io.Serializable {

	// Fields

	private String id;
	private String rebotname;
	private String email;
	private String telphone;
	private Long startprice;
	private Long endprice;
	private Integer auctiontime;
	private Set tsRebotcoms = new HashSet(0);

	// Constructors

	/** default constructor */
	public TsRobot() {
	}

	/** full constructor */
	public TsRobot(String rebotname, String email, String telphone,
			Long startprice, Long endprice, Integer auctiontime, Set tsRebotcoms) {
		this.rebotname = rebotname;
		this.email = email;
		this.telphone = telphone;
		this.startprice = startprice;
		this.endprice = endprice;
		this.auctiontime = auctiontime;
		this.tsRebotcoms = tsRebotcoms;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRebotname() {
		return this.rebotname;
	}

	public void setRebotname(String rebotname) {
		this.rebotname = rebotname;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelphone() {
		return this.telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
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

	public Set getTsRebotcoms() {
		return this.tsRebotcoms;
	}

	public void setTsRebotcoms(Set tsRebotcoms) {
		this.tsRebotcoms = tsRebotcoms;
	}

}