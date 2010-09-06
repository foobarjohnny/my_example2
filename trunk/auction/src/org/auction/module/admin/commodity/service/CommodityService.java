package org.auction.module.admin.commodity.service;

import org.auction.module.admin.commodity.data.CommodityData;
import org.mobile.common.exception.GeneralException;

public interface CommodityService {

	public void forward(CommodityData model) throws GeneralException;

	public void save(CommodityData model) throws GeneralException;

	public void delete(CommodityData model) throws GeneralException;

	public void search(CommodityData model) throws GeneralException;
	
	public void searchLot(CommodityData model) throws GeneralException;
	
	public void searchProgress(CommodityData model) throws GeneralException;
	
	public void searchReach(CommodityData model) throws GeneralException;
	
	public void auction(CommodityData model) throws GeneralException;
	
	public void select(CommodityData model) throws GeneralException;
	
	public void getReach(CommodityData model) throws GeneralException;
}
