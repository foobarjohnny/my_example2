package org.auction.module.admin.user.service.impl;

import java.util.Iterator;

import org.auction.entity.TsConsume;
import org.auction.entity.TsUser;
import org.auction.module.admin.user.data.UserAccountData;
import org.auction.module.admin.user.service.UserAccountService;
import org.mobile.common.bean.LoginBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.manager.GeneralManager;
import org.mobile.common.service.GeneralService;
import org.mobile.common.session.SessionManager;
import org.mobile.common.util.BeanProcessUtils;

public class UserAccountServiceImpl extends GeneralService implements
		UserAccountService {

	@SuppressWarnings("unchecked")
	public void account(UserAccountData model) throws GeneralException {
		GeneralManager manager = GeneralManager.getCurrentManager();
		LoginBean bean = SessionManager.getLoginInfo(manager.getSessionId());
		if (bean != null) {
			TsUser tsUser = (TsUser) generalDao.get(TsUser.class, bean.getId());
			model.setPaycur(tsUser.getPaycur());
			model.setFreecur(tsUser.getFreecur());
			Iterator iterator = tsUser.getTsConsumes().iterator();
			while (iterator.hasNext()) {
				TsConsume tsConsume = (TsConsume) iterator.next();
				UserAccountData data = new UserAccountData();
				BeanProcessUtils.copyProperties(data, tsConsume);
				model.getDataList().add(data);
			}
		}
	}

}
