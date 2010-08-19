package org.auction.module.admin.base.data;

import java.util.ArrayList;  
import java.sql.Date;
import java.util.List;

import org.mobile.common.action.GeneralData;

public class InfoData extends GeneralData {

	private String id;
	private String nettype;
	private String info;
	private String title;
	private Date releasedate;

	private List<InfoData> dataList = new ArrayList<InfoData>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNettype() {
		return nettype;
	}

	public void setNettype(String nettype) {
		this.nettype = nettype;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}

	public List<InfoData> getDataList() {
		return dataList;
	}

	public void setDataList(List<InfoData> dataList) {
		this.dataList = dataList;
	}
}
