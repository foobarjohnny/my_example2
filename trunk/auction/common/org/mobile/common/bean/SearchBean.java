package org.mobile.common.bean;

/**
 * 查询Bean
 * 
 * @author 孙树林
 * 
 */
public class SearchBean {

	/** 显示名称 */
	private String displayName;

	/** 字段名称 */
	private String fieldName;

	/** 判断符号 */
	private String signl;

	/** 值类型 */
	private String type;

	/** 值 */
	private String value;

	public SearchBean() {
		super();
	}

	public SearchBean(String fieldName, String signl, String type, String value) {
		super();
		this.fieldName = fieldName;
		this.signl = signl;
		this.type = type;
		this.value = value;
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

	public String getSignl() {
		return signl;
	}

	public void setSignl(String signl) {
		this.signl = signl;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
