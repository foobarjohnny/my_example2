package org.auction.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * TsProblem entity. @author MyEclipse Persistence Tools
 */

public class TsProblem implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private String id;
	private String substance;
	private String title;
	private Date releasedate;
	private String details;

	// Constructors

	/** default constructor */
	public TsProblem() {
	}

	/** minimal constructor */
	public TsProblem(Date releasedate) {
		this.releasedate = releasedate;
	}

	/** full constructor */
	public TsProblem(String substance, String title, Timestamp releasedate,
			String details) {
		this.substance = substance;
		this.title = title;
		this.releasedate = releasedate;
		this.details = details;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubstance() {
		return this.substance;
	}

	public void setSubstance(String substance) {
		this.substance = substance;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleasedate() {
		return this.releasedate;
	}

	public void setReleasedate(Timestamp releasedate) {
		this.releasedate = releasedate;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}