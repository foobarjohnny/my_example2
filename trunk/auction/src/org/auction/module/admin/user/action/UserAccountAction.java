package org.auction.module.admin.user.action;

import org.auction.module.admin.user.data.UserAccountData;
import org.auction.module.admin.user.service.UserAccountService;
import org.mobile.common.action.GeneralAction;
import org.mobile.common.exception.GeneralException;

public class UserAccountAction extends GeneralAction<UserAccountData> {

	private static final long serialVersionUID = 1L;
	
	private UserAccountData model = new UserAccountData();

	private UserAccountService userAccountService;
	
	public String account() throws GeneralException {
		this.setPage(model);
		userAccountService.account(model);
		return SUCCESS;
	}

	public UserAccountData getModel() {
		return model;
	}

	public void setUserAccountService(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}

}
