package org.auction.module.admin.base.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mobile.common.action.GeneralData;

public class DoohickeyData extends GeneralData {

	private String id;
	private String userid;
	private String username;
	private Date addtime;
	private String remark;
	private String title;

	private List<DoohickeyData> dataList = new ArrayList<DoohickeyData>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<DoohickeyData> getDataList() {
		return dataList;
	}

	public void setDataList(List<DoohickeyData> dataList) {
		this.dataList = dataList;
	}
}
