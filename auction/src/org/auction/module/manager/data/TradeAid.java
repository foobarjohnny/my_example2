package org.auction.module.manager.data;

import java.math.BigDecimal;

/**
 * 用户竞拍助理
 * 
 * @author ThinkPad
 * 
 */
public class TradeAid {

	/** 价格范围 */
	private BigDecimal start = new BigDecimal(0);
	private BigDecimal end = new BigDecimal(0);
	/** E拍币 */
	private Integer free = new Integer(0);
	private Integer pay = new Integer(0);
	/** 商品信息，用户信息 */
	private String cmId;
	private String uId;
	/** 助理ID */
	private String id;

	/**
	 * @return the start
	 */
	public BigDecimal getStart() {
		return start;
	}

	/**
	 * @param start
	 *            the start to set
	 */
	public void setStart(BigDecimal start) {
		this.start = start;
	}

	/**
	 * @return the end
	 */
	public BigDecimal getEnd() {
		return end;
	}

	/**
	 * @param end
	 *            the end to set
	 */
	public void setEnd(BigDecimal end) {
		this.end = end;
	}

	/**
	 * @return the free
	 */
	public Integer getFree() {
		return free;
	}

	/**
	 * @param free
	 *            the free to set
	 */
	public void setFree(Integer free) {
		this.free = free;
	}

	/**
	 * @return the pay
	 */
	public Integer getPay() {
		return pay;
	}

	/**
	 * @param pay
	 *            the pay to set
	 */
	public void setPay(Integer pay) {
		this.pay = pay;
	}

	/**
	 * @return the cmId
	 */
	public String getCmId() {
		return cmId;
	}

	/**
	 * @param cmId
	 *            the cmId to set
	 */
	public void setCmId(String cmId) {
		this.cmId = cmId;
	}

	/**
	 * @return the uId
	 */
	public String getUId() {
		return uId;
	}

	/**
	 * @param id
	 *            the uId to set
	 */
	public void setUId(String id) {
		uId = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
}
