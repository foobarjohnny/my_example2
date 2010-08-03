package org.auction.module.admin.base.service;

import org.auction.module.admin.base.data.NetWorkData;
import org.mobile.common.exception.GeneralException;

public interface NetWordService {

	public void forwardInfo(NetWorkData model) throws GeneralException;

	public void saveInfo(NetWorkData model) throws GeneralException;
}
