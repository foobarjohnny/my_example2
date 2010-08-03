package org.auction.entity;

/**
 * TsAccount entity. @author MyEclipse Persistence Tools
 */
public class TsAccount implements java.io.Serializable {

	// Fields

	private String id;
	private Long money;

	// Constructors

	/** default constructor */
	public TsAccount() {
	}

	/** full constructor */
	public TsAccount(Long money) {
		this.money = money;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getMoney() {
		return this.money;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

}