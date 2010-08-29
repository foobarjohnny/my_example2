package org.auction.module.admin.commodity.service;

import org.auction.module.admin.commodity.data.BuyData;
import org.mobile.common.exception.GeneralException;

public interface BuyService {

	public void forward(BuyData model) throws GeneralException;

	public void save(BuyData model) throws GeneralException;

	public void delete(BuyData model) throws GeneralException;

	public void search(BuyData model) throws GeneralException;
	
	public void searchBuy(BuyData model) throws GeneralException;
}
