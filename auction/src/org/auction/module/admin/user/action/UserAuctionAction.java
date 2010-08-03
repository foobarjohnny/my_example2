package org.auction.module.admin.user.action;

import org.auction.module.admin.user.data.UserAuctionData;
import org.auction.module.admin.user.service.UserAuctionService;
import org.mobile.common.action.GeneralAction;
import org.mobile.common.exception.GeneralException;

public class UserAuctionAction extends GeneralAction<UserAuctionData> {

	private static final long serialVersionUID = 1L;

	private UserAuctionData model = new UserAuctionData();

	private UserAuctionService userAuctionService;

	public String auction() throws GeneralException {
		this.setPage(model);
		userAuctionService.auction(model);
		return SUCCESS;
	}
	
	public String now() throws GeneralException {
		this.setPage(model);
		userAuctionService.now(model);
		return SUCCESS;
	}
	
	public String follow() throws GeneralException {
		this.setPage(model);
		userAuctionService.follow(model);
		return SUCCESS;
	}

	public UserAuctionData getModel() {
		return model;
	}

	public void setUserAuctionService(UserAuctionService userAuctionService) {
		this.userAuctionService = userAuctionService;
	}

}
