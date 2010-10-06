package org.auction.module.admin.user.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mobile.common.action.GeneralData;

public class UserData extends GeneralData {

	private String id;
	private String username;
	private String password;
	private String realname;
	private String nickname;
	private String sex;
	private Date birthdate;
	private String telphone;
	private String safetycode;
	private String problem;
	private String answer;
	private String qq;
	private String email;
	private String address;
	private Date houroflogon;
	private Date lasttimelogon;
	private Date lasttimeip;
	private Integer paycur;
	private Integer freecur;
	// 邀请用户的ID
	private String regId;

	private String methodName;

	private String info;
	// 生成的URL
	private String url;
	// 收件人账户
	private String recAcout;
	// 

	private List<UserData> dataList = new ArrayList<UserData>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<UserData> getDataList() {
		return dataList;
	}

	public void setDataList(List<UserData> dataList) {
		this.dataList = dataList;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getSafetycode() {
		return safetycode;
	}

	public void setSafetycode(String safetycode) {
		this.safetycode = safetycode;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getHouroflogon() {
		return houroflogon;
	}

	public void setHouroflogon(Date houroflogon) {
		this.houroflogon = houroflogon;
	}

	public Date getLasttimelogon() {
		return lasttimelogon;
	}

	public void setLasttimelogon(Date lasttimelogon) {
		this.lasttimelogon = lasttimelogon;
	}

	public Date getLasttimeip() {
		return lasttimeip;
	}

	public void setLasttimeip(Date lasttimeip) {
		this.lasttimeip = lasttimeip;
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

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRecAcout() {
		return recAcout;
	}

	public void setRecAcout(String recAcout) {
		this.recAcout = recAcout;
	}

}
