package org.mobile.common.bean;

/**
 * 排序
 * 
 * @author 孙树林
 * 
 */
public class OrderByBean {

	/** 显示名称 */
	private String displayName;
	/** 字段名称 */
	private String fieldName;
	/** 排序 */
	private String sigln;

	public OrderByBean() {
		super();
	}

	public OrderByBean(String displayName, String fieldName, String sigln) {
		super();
		this.displayName = displayName;
		this.fieldName = fieldName;
		this.sigln = sigln;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getSigln() {
		return sigln;
	}

	public void setSigln(String sigln) {
		this.sigln = sigln;
	}
}
