package org.auction.entity;

/**
 * TsNum entity. @author MyEclipse Persistence Tools
 */

public class TsNum implements java.io.Serializable {

	// Fields

	private Long id;
	private String tablename;
	private Long sequ;

	// Constructors

	/** default constructor */
	public TsNum() {
	}

	/** full constructor */
	public TsNum(String tablename, Long sequ) {
		this.tablename = tablename;
		this.sequ = sequ;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTablename() {
		return this.tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public Long getSequ() {
		return this.sequ;
	}

	public void setSequ(Long sequ) {
		this.sequ = sequ;
	}

}