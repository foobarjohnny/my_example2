package org.auction.module.admin.base.data;

import java.util.ArrayList;
import java.util.List;

import org.mobile.common.action.GeneralData;

public class ManagerData extends GeneralData {

	private String id;
	private String account;
	private String password;
	private String realname;
	private String telphone;
	private String[] managerFuns;

	private Long[] values;

	private List<ManagerData> dataList = new ArrayList<ManagerData>();
	private List<FunData> funList = new ArrayList<FunData>();

	public ManagerData() {
		funList.add(new FunData(1, "商品管理"));
		funList.add(new FunData(2, "订单管理"));
		funList.add(new FunData(3, "用户管理"));
		funList.add(new FunData(4, "机器人管理 "));
		funList.add(new FunData(5, "广告管理"));
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String[] getManagerFuns() {
		return managerFuns;
	}

	public void setManagerFuns(String[] managerFuns) {
		this.managerFuns = managerFuns;
	}

	public List<ManagerData> getDataList() {
		return dataList;
	}

	public void setDataList(List<ManagerData> dataList) {
		this.dataList = dataList;
	}

	public List<FunData> getFunList() {
		return funList;
	}

	public void setFunList(List<FunData> funList) {
		this.funList = funList;
	}

	public Long[] getValues() {
		return values;
	}

	public void setValues(Long[] values) {
		this.values = values;
	}
}
