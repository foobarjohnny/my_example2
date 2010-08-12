package org.auction.module.admin.commodity.service;

import org.auction.module.admin.commodity.data.RebotcomData;
import org.mobile.common.exception.GeneralException;

public interface RebotcomService {

	public String forward(RebotcomData model) throws GeneralException;

	public String save(RebotcomData model) throws GeneralException;

	public String delete(RebotcomData model) throws GeneralException;

	public String search(RebotcomData model) throws GeneralException;
}
