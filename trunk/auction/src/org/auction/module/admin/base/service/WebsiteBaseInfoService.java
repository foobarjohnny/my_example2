package org.auction.module.admin.base.service;

import org.mobile.common.exception.GeneralException;
import org.auction.module.admin.base.data.WebsiteInfoData;

public interface WebsiteBaseInfoService {

	public WebsiteInfoData searchInfoData() throws GeneralException;

	public void modify(WebsiteInfoData model) throws GeneralException;

	public void save(WebsiteInfoData model) throws GeneralException;
}
