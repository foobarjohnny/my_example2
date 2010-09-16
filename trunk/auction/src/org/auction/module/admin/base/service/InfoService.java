package org.auction.module.admin.base.service;

import org.auction.module.admin.base.data.InfoData;
import org.mobile.common.exception.GeneralException;

public interface InfoService {

	public void delete(InfoData model) throws GeneralException;

	public void search(InfoData model) throws GeneralException;

	public void forwardInfo(InfoData model) throws GeneralException;

	public void saveInfo(InfoData model) throws GeneralException;
}
