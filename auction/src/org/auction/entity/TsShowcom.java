package org.auction.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * TsShowcom entity. @author MyEclipse Persistence Tools
 */

public class TsShowcom implements java.io.Serializable {

	// Fields

	private String id;
	private TsCommodity tsCommodity;
	private TsUser tsUser;
	private String title;
	private String remark;
	private String aut;
	private Date creattime;
	private Integer adde;

	// Constructors

	/** default constructor */
	public TsShowcom() {
	}

	/** minimal constructor */
	public TsShowcom(Timestamp creattime) {
		this.creattime = creattime;
	}

	/** full constructor */
	public TsShowcom(TsCommodity tsCommodity, TsUser tsUser, String title,
			String remark, String aut, Timestamp creattime) {
		this.tsCommodity = tsCommodity;
		this.tsUser = tsUser;
		this.title = title;
		this.remark = remark;
		this.aut = aut;
		this.creattime = creattime;
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAut() {
		return this.aut;
	}

	public void setAut(String aut) {
		this.aut = aut;
	}

	public Date getCreattime() {
		return this.creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public Integer getAdde() {
		return adde;
	}

	public void setAdde(Integer adde) {
		this.adde = adde;
	}

}