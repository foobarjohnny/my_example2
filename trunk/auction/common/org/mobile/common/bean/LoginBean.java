package org.mobile.common.bean;

public class LoginBean {

	private String id;
	private String workNo;
	private String password;
	private Integer paycur;
	private Integer freecur;
	private Integer amount;

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWorkNo() {
		return workNo;
	}

	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPaycur() {
		return paycur;
	}

	public void setPaycur(Integer paycur) {
		this.paycur = paycur;
	}

	public Integer getFreecur() {
		return freecur;
	}

	public void setFreecur(Integer freecur) {
		this.freecur = freecur;
	}
}
