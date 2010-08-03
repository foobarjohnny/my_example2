package org.auction.entity;

/**
 * TsImages entity. @author MyEclipse Persistence Tools
 */

public class TsImages implements java.io.Serializable {

	// Fields

	private String id;
	private String imageid;
	private String filepath;
	private String tablename;

	// Constructors

	/** default constructor */
	public TsImages() {
	}

	/** full constructor */
	public TsImages(String imageid, String filepath, String tablename) {
		this.imageid = imageid;
		this.filepath = filepath;
		this.tablename = tablename;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImageid() {
		return this.imageid;
	}

	public void setImageid(String imageid) {
		this.imageid = imageid;
	}

	public String getFilepath() {
		return this.filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getTablename() {
		return this.tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

}