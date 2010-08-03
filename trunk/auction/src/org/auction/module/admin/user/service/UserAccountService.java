package org.auction.module.admin.user.service;

import org.auction.module.admin.user.data.UserAccountData;
import org.mobile.common.exception.GeneralException;

public interface UserAccountService {

	public void account(UserAccountData model) throws GeneralException;
}
