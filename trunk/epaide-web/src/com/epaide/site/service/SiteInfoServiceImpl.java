package com.epaide.site.service;

import com.epaide.site.dao.SiteInfoDao;
import com.epaide.site.model.SiteInfo;

public class SiteInfoServiceImpl implements SiteInfoService{

	private SiteInfoDao dao;

	public void setDao(SiteInfoDao dao) {
		this.dao = dao;
	}

	@Override
	public void save(SiteInfo info) {
		dao.save(info);
	}

	@Override
	public void update(SiteInfo info) {
		dao.update(info);
	}

	@Override
	public SiteInfo getSiteInfo() {
		return dao.get();
	}
	
	
	
	
}
