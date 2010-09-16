package org.auction.module.admin.base.data;

import java.io.File;

import org.mobile.common.action.GeneralData;

public class WebsiteInfoData extends GeneralData {

	private String id;
	private String networkName;
	private String title;
	private File logoFile;
	private String files;
	private String webSite;
	private String isReg;
	private String isEmail;
	private String isPhone;
	private Integer giveEcur;
	private Integer outName;
	private String copyright;
	private String metaKey;
	private String metaDes;

	/**
	 * 构造函数
	 */
	public WebsiteInfoData() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNetworkName() {
		return networkName;
	}

	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public File getLogoFile() {
		return logoFile;
	}

	public void setLogoFile(File logoFile) {
		this.logoFile = logoFile;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getIsReg() {
		return isReg;
	}

	public void setIsReg(String isReg) {
		this.isReg = isReg;
	}

	public String getIsEmail() {
		return isEmail;
	}

	public void setIsEmail(String isEmail) {
		this.isEmail = isEmail;
	}

	public String getIsPhone() {
		return isPhone;
	}

	public void setIsPhone(String isPhone) {
		this.isPhone = isPhone;
	}

	public Integer getGiveEcur() {
		return giveEcur;
	}

	public void setGiveEcur(Integer giveEcur) {
		this.giveEcur = giveEcur;
	}

	public Integer getOutName() {
		return outName;
	}

	public void setOutName(Integer outName) {
		this.outName = outName;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getMetaKey() {
		return metaKey;
	}

	public void setMetaKey(String metaKey) {
		this.metaKey = metaKey;
	}

	public String getMetaDes() {
		return metaDes;
	}

	public void setMetaDes(String metaDes) {
		this.metaDes = metaDes;
	}

}
