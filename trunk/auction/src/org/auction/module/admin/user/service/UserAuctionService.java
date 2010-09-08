package org.auction.module.admin.user.service;

import org.auction.module.admin.user.data.UserAuctionData;
import org.mobile.common.exception.GeneralException;


public interface UserAuctionService {
	
	public void auction(UserAuctionData model) throws GeneralException;
	
	public void now(UserAuctionData model) throws GeneralException;
	
	public void follow(UserAuctionData model) throws GeneralException;
	
	public void viewAuctionNow(UserAuctionData model) throws GeneralException;
}
