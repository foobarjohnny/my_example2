package com.epaide.site.action;

import com.epaide.site.model.SiteInfo;
import com.epaide.site.service.SiteInfoService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author paragon
 * 
 */
public class SiteInfoAction extends ActionSupport {
	private static final long serialVersionUID = 7042550857209676190L;

	private SiteInfoService service;

	private SiteInfo siteInfo;

	public String saveSiteInfo() {
		if(siteInfo.getId()==null){
			service.save(siteInfo);
		}else{
			service.update(siteInfo);
		}
		return SUCCESS;
	}
	public SiteInfo getSiteInfo() {
		return siteInfo;
	}

	public void setSiteInfo(SiteInfo siteInfo) {
		this.siteInfo = siteInfo;
	}

	public void setService(SiteInfoService service) {
		this.service = service;
	}

	public SiteInfoService getService() {
		return service;
	}

}
