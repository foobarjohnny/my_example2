package org.auction.module.admin.commodity.service;

import org.auction.module.admin.commodity.data.BingcurData;
import org.mobile.common.exception.GeneralException;

public interface BingcurService {

	public String forward(BingcurData model) throws GeneralException;

	public String save(BingcurData model) throws GeneralException;

	public String delete(BingcurData model) throws GeneralException;

	public String search(BingcurData model) throws GeneralException;

	public String searchBiding(BingcurData model) throws GeneralException;
}
