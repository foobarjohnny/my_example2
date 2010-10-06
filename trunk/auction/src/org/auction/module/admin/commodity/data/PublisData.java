package org.auction.module.admin.commodity.data;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mobile.common.action.GeneralData;

public class PublisData extends GeneralData {

	private String id;
	private String remark;
	private String state;
	private Long amount;
	private String tradename;
	private BigDecimal price;
	private Date starttime;
	private String[] ids;
	private File[] files;
	private String[] filesFileName;
	
	@SuppressWarnings("unchecked")
	private List imagesPath;

	private List<PublisData> dataList = new ArrayList<PublisData>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getTradename() {
		return tradename;
	}

	public void setTradename(String tradename) {
		this.tradename = tradename;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}

	public List<PublisData> getDataList() {
		return dataList;
	}

	public void setDataList(List<PublisData> dataList) {
		this.dataList = dataList;
	}

	public String[] getFilesFileName() {
		return filesFileName;
	}

	public void setFilesFileName(String[] filesFileName) {
		this.filesFileName = filesFileName;
	}

	@SuppressWarnings("unchecked")
	public List getImagesPath() {
		return imagesPath;
	}

	@SuppressWarnings("unchecked")
	public void setImagesPath(List imagesPath) {
		this.imagesPath = imagesPath;
	}
}
