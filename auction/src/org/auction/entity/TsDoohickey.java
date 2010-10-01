package org.auction.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * TsDoohickey entity. @author MyEclipse Persistence Tools
 */

public class TsDoohickey implements java.io.Serializable {

	// Fields

	private String id;
	private TsUser tsUser;
	private Date addtime;
	private String remark;
	private String title;

	// Constructors

	/** default constructor */
	public TsDoohickey() {
	}

	/** minimal constructor */
	public TsDoohickey(Timestamp addtime) {
		this.addtime = addtime;
	}

	/** full constructor */
	public TsDoohickey(TsUser tsUser, Timestamp addtime, String remark,
			String title) {
		this.tsUser = tsUser;
		this.addtime = addtime;
		this.remark = remark;
		this.title = title;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TsUser getTsUser() {
		return this.tsUser;
	}

	public void setTsUser(TsUser tsUser) {
		this.tsUser = tsUser;
	}

	public Date getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}