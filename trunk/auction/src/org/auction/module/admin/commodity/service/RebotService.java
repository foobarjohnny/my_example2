package org.auction.module.admin.commodity.service;

import org.auction.module.admin.commodity.data.RebotData;
import org.mobile.common.exception.GeneralException;

public interface RebotService {

	public void forward(RebotData model) throws GeneralException;

	public void save(RebotData model) throws GeneralException;

	public void delete(RebotData model) throws GeneralException;

	public void search(RebotData model) throws GeneralException;
}
