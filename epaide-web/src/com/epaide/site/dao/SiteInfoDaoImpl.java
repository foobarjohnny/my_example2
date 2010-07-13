package com.epaide.site.dao;

import com.epaide.base.dao.GenericDaoImpl;
import com.epaide.site.model.SiteInfo;

public class SiteInfoDaoImpl extends GenericDaoImpl<SiteInfo, Integer>
		implements SiteInfoDao {

	public SiteInfoDaoImpl(Class<SiteInfo> persistentClass) {
		super(persistentClass);
	}

	public SiteInfo save(SiteInfo paramT) {
		return super.save(paramT);
	}

	@Override
	public void update(SiteInfo paramT) {
		super.update(paramT);
	}

	@Override
	public SiteInfo get() {
		return super.getAll().get(0);
	}

}
