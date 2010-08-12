package org.auction.module.admin.commodity.data;

import java.util.ArrayList;
import java.util.List;

import org.mobile.common.action.GeneralData;

public class SortData extends GeneralData {

	private String id;
	private String sortname;

	private List<SortData> dataList = new ArrayList<SortData>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public List<SortData> getDataList() {
		return dataList;
	}

	public void setDataList(List<SortData> dataList) {
		this.dataList = dataList;
	}
}
