package org.auction.entity;

/**
 * TsNetwork entity. @author MyEclipse Persistence Tools
 */

public class TsNetwork implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 8659870315848929873L;
	private String id;
	private String networkName;
	private String title;
	private String logo;
	private String webSite;
	private String isReg;
	private String isEmail;
	private String isPhone;
	private Integer giveEcur;
	private Integer outName;
	private String copyright;
	private String metaKey;
	private String metaDes;

	// Constructors

	/** default constructor */
	public TsNetwork() {
	}

	/** full constructor */
	public TsNetwork(String networkName, String title, String logo,
			String webSite, String isReg, String isEmail, String isPhone,
			Integer giveEcur, Integer outName, String copyright,
			String metaKey, String metaDes) {
		this.networkName = networkName;
		this.title = title;
		this.logo = logo;
		this.webSite = webSite;
		this.isReg = isReg;
		this.isEmail = isEmail;
		this.isPhone = isPhone;
		this.giveEcur = giveEcur;
		this.outName = outName;
		this.copyright = copyright;
		this.metaKey = metaKey;
		this.metaDes = metaDes;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNetworkName() {
		return this.networkName;
	}

	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getIsReg() {
		return this.isReg;
	}

	public void setIsReg(String isReg) {
		this.isReg = isReg;
	}

	public String getIsEmail() {
		return this.isEmail;
	}

	public void setIsEmail(String isEmail) {
		this.isEmail = isEmail;
	}

	public String getIsPhone() {
		return this.isPhone;
	}

	public void setIsPhone(String isPhone) {
		this.isPhone = isPhone;
	}

	public Integer getGiveEcur() {
		return this.giveEcur;
	}

	public void setGiveEcur(Integer giveEcur) {
		this.giveEcur = giveEcur;
	}

	public Integer getOutName() {
		return this.outName;
	}

	public void setOutName(Integer outName) {
		this.outName = outName;
	}

	public String getCopyright() {
		return this.copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getMetaKey() {
		return this.metaKey;
	}

	public void setMetaKey(String metaKey) {
		this.metaKey = metaKey;
	}

	public String getMetaDes() {
		return this.metaDes;
	}

	public void setMetaDes(String metaDes) {
		this.metaDes = metaDes;
	}

}