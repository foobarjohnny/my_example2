package org.auction.module.manager.job.service;

import java.util.List;

import org.auction.module.manager.data.TradeData;
import org.mobile.common.exception.GeneralException;

public interface IJobService {

	public List<TradeData> getNewComtity(String[] ids) throws GeneralException;

	public void finish() throws GeneralException;
}
