package org.mobile.common.bean;

/**
 * 
 * @author 孙树林
 * 
 */
public class SqlBean {

	public static final String INSERT = "insert";

	public static final String DLETE = "delete";

	public static final String UPDATE = "update";

	private String sql;

	private String id;

	private String property;

	private String parameter;

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
}
