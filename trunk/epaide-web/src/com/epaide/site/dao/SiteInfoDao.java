package com.epaide.site.dao;

import com.epaide.site.model.SiteInfo;

/**
 * 网站信息设置，只有一条有效记录
 * @author paragon
 * 
 */
public interface SiteInfoDao {

	public SiteInfo save(SiteInfo info);

	public void update(SiteInfo info);
	
	public SiteInfo get();

}
