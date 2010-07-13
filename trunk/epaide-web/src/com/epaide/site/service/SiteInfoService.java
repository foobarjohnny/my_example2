package com.epaide.site.service;

import com.epaide.site.model.SiteInfo;

public interface SiteInfoService {
	public void save(SiteInfo info);
	public void update(SiteInfo info);
	public SiteInfo getSiteInfo();
}
