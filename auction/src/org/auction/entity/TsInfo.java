package org.auction.entity;

import java.util.Date; 

/**
 * TsInfo entity. @author MyEclipse Persistence Tools
 */

public class TsInfo implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private String id;
	private String nettype;
	private String info;
	private String title;
	private Date releasedate;

	// Constructors

	/** default constructor */
	public TsInfo() {
	}

	/** minimal constructor */
	public TsInfo(Date releasedate) {
		this.releasedate = releasedate;
	}

	/** full constructor */
	public TsInfo(String nettype, String info, String title,
			Date releasedate) {
		this.nettype = nettype;
		this.info = info;
		this.title = title;
		this.releasedate = releasedate;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNettype() {
		return this.nettype;
	}

	public void setNettype(String nettype) {
		this.nettype = nettype;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleasedate() {
		return this.releasedate;
	}

	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}

}