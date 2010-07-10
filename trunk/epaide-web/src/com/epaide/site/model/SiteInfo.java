package com.epaide.site.model;

public class SiteInfo {
	private Integer id;
	private String name;
	private String title;
	private String logo;
	
	private String url;
	private boolean allowedRegister;
	private boolean allowedMailNotified;
	private boolean allowedPhoneAuth;
	private int sendEpaibe;
	private int unactiveDuration;
	private String copyright;
	private String metaKey;
	private String metaDesc;
	private String siteDesc;
	private String comCoDesc;
	private String registerAgreement;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isAllowedRegister() {
		return allowedRegister;
	}

	public void setAllowedRegister(boolean allowedRegister) {
		this.allowedRegister = allowedRegister;
	}

	public boolean isAllowedMailNotified() {
		return allowedMailNotified;
	}

	public void setAllowedMailNotified(boolean allowedMailNotified) {
		this.allowedMailNotified = allowedMailNotified;
	}

	public boolean isAllowedPhoneAuth() {
		return allowedPhoneAuth;
	}

	public void setAllowedPhoneAuth(boolean allowedPhoneAuth) {
		this.allowedPhoneAuth = allowedPhoneAuth;
	}

	public int getSendEpaibe() {
		return sendEpaibe;
	}

	public void setSendEpaibe(int sendEpaibe) {
		this.sendEpaibe = sendEpaibe;
	}

	public int getUnactiveDuration() {
		return unactiveDuration;
	}

	public void setUnactiveDuration(int unactiveDuration) {
		this.unactiveDuration = unactiveDuration;
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

	public String getMetaDesc() {
		return metaDesc;
	}

	public void setMetaDesc(String metaDesc) {
		this.metaDesc = metaDesc;
	}

	public String getSiteDesc() {
		return siteDesc;
	}

	public void setSiteDesc(String siteDesc) {
		this.siteDesc = siteDesc;
	}

	public String getComCoDesc() {
		return comCoDesc;
	}

	public void setComCoDesc(String comCoDesc) {
		this.comCoDesc = comCoDesc;
	}

	public String getRegisterAgreement() {
		return registerAgreement;
	}

	public void setRegisterAgreement(String registerAgreement) {
		this.registerAgreement = registerAgreement;
	}

}
