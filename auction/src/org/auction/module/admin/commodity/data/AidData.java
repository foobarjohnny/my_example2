package org.auction.module.admin.commodity.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.mobile.common.action.GeneralData;

public class AidData extends GeneralData {

	private String id;
	private String comid;
	private String userid;
	private String etype;
	private BigDecimal startPirce = new BigDecimal(0);
	private BigDecimal endPrice = new BigDecimal(0);
	private String state;
	private String userId;
	private String comId;
	private String username;
	private String comname;
	private Integer ecount;
	private Integer paycount;

	private List<AidData> dataList = new ArrayList<AidData>();

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the comid
	 */
	public String getComid() {
		return comid;
	}

	/**
	 * @param comid
	 *            the comid to set
	 */
	public void setComid(String comid) {
		this.comid = comid;
	}

	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * @param userid
	 *            the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * @return the etype
	 */
	public String getEtype() {
		return etype;
	}

	/**
	 * @param etype
	 *            the etype to set
	 */
	public void setEtype(String etype) {
		this.etype = etype;
	}

	/**
	 * @return the startPirce
	 */
	public BigDecimal getStartPirce() {
		return startPirce;
	}

	/**
	 * @param startPirce
	 *            the startPirce to set
	 */
	public void setStartPirce(BigDecimal startPirce) {
		this.startPirce = startPirce;
	}

	/**
	 * @return the endPrice
	 */
	public BigDecimal getEndPrice() {
		return endPrice;
	}

	/**
	 * @param endPrice
	 *            the endPrice to set
	 */
	public void setEndPrice(BigDecimal endPrice) {
		this.endPrice = endPrice;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the comId
	 */
	public String getComId() {
		return comId;
	}

	/**
	 * @param comId
	 *            the comId to set
	 */
	public void setComId(String comId) {
		this.comId = comId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the comname
	 */
	public String getComname() {
		return comname;
	}

	/**
	 * @param comname
	 *            the comname to set
	 */
	public void setComname(String comname) {
		this.comname = comname;
	}

	/**
	 * @return the ecount
	 */
	public Integer getEcount() {
		return ecount;
	}

	/**
	 * @param ecount the ecount to set
	 */
	public void setEcount(Integer ecount) {
		this.ecount = ecount;
	}

	/**
	 * @return the paycount
	 */
	public Integer getPaycount() {
		return paycount;
	}

	/**
	 * @param paycount the paycount to set
	 */
	public void setPaycount(Integer paycount) {
		this.paycount = paycount;
	}

	/**
	 * @return the dataList
	 */
	public List<AidData> getDataList() {
		return dataList;
	}

	/**
	 * @param dataList
	 *            the dataList to set
	 */
	public void setDataList(List<AidData> dataList) {
		this.dataList = dataList;
	}
}
