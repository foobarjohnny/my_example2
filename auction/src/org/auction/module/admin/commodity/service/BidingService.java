package org.auction.module.admin.commodity.service;

import java.util.List;

import org.auction.module.admin.commodity.data.BidingData;
import org.mobile.common.exception.GeneralException;

public interface BidingService {

	public String forward(BidingData model) throws GeneralException;

	public String save(BidingData model) throws GeneralException;

	public String delete(BidingData model) throws GeneralException;

	public String search(BidingData model) throws GeneralException;
	
	@SuppressWarnings("unchecked")
	public List findNewPeople(BidingData model) throws GeneralException;
}
