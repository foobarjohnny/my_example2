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
		if (!checkedLogin()) {
			return "login";
		}
		this.setPage(model);
		userAuctionService.auction(model);
		return SUCCESS;
	}

	/**
	 * 用户正在参与竞拍商品
	 * 
	 * @return
	 * @throws GeneralException
	 */
	public String now() throws GeneralException {
		if (!checkedLogin()) {
			return "login";
		}
		this.setPage(model);
		userAuctionService.now(model);
		return SUCCESS;
	}

	public String follow() throws GeneralException {
		if (!checkedLogin()) {
			return "login";
		}
		this.setPage(model);
		userAuctionService.follow(model);
		return SUCCESS;
	}

	public String viewAuctionNow() throws GeneralException {
		this.setPage(model);
		userAuctionService.viewAuctionNow(model);
		return SUCCESS;
	}

	public UserAuctionData getModel() {
		return model;
	}

	public void setUserAuctionService(UserAuctionService userAuctionService) {
		this.userAuctionService = userAuctionService;
	}

}
