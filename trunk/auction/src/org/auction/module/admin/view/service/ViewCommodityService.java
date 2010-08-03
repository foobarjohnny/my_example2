package org.auction.module.admin.view.service;

import org.auction.module.admin.view.data.ViewData;
import org.mobile.common.exception.GeneralException;

public interface ViewCommodityService {

	public void show(ViewData model) throws GeneralException;
}
