package org.auction.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TsSort entity. @author MyEclipse Persistence Tools
 */

public class TsSort implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;

	private String id;
	private String sortname;
	private String isValid;
	private Set tsCommodities = new HashSet(0);

	// Constructors

	/** default constructor */
	public TsSort() {
	}

	/** full constructor */
	public TsSort(String sortname, Set tsCommodities) {
		this.sortname = sortname;
		this.tsCommodities = tsCommodities;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSortname() {
		return this.sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public Set getTsCommodities() {
		return this.tsCommodities;
	}

	public void setTsCommodities(Set tsCommodities) {
		this.tsCommodities = tsCommodities;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

}