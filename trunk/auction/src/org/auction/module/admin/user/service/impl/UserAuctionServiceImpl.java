package org.auction.module.admin.user.service.impl;

import java.util.Iterator;

import org.auction.entity.TsBingcur;
import org.auction.entity.TsCommodity;
import org.auction.entity.TsUser;
import org.auction.module.admin.user.data.UserAuctionData;
import org.auction.module.admin.user.service.UserAuctionService;
import org.mobile.common.bean.LoginBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.manager.GeneralManager;
import org.mobile.common.service.GeneralService;
import org.mobile.common.session.SessionManager;
import org.mobile.common.util.BeanProcessUtils;

public class UserAuctionServiceImpl extends GeneralService implements
		UserAuctionService {

	@SuppressWarnings("unchecked")
	public void auction(UserAuctionData model) throws GeneralException {
		GeneralManager manager = GeneralManager.getCurrentManager();
		LoginBean bean = SessionManager.getLoginInfo(manager.getSessionId());
		if (bean != null) {
			TsUser tsUser = (TsUser) generalDao.get(TsUser.class, bean.getId());
			Iterator iterator = tsUser.getTsBingcurs().iterator();
			while (iterator.hasNext()) {
				TsBingcur tsBingcur = (TsBingcur) iterator.next();
				UserAuctionData data = new UserAuctionData();
				BeanProcessUtils.copyProperties(data, tsBingcur);
				data.setTradename(tsBingcur.getTsCommodity().getTradename());
				model.getDataList().add(data);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void now(UserAuctionData model) throws GeneralException {
		GeneralManager manager = GeneralManager.getCurrentManager();
		LoginBean bean = SessionManager.getLoginInfo(manager.getSessionId());
		if (bean != null) {
			TsUser tsUser = (TsUser) generalDao.get(TsUser.class, bean.getId());
			Iterator iterator = generalDao.now(tsUser.getId()).iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				TsCommodity tsCommodity = (TsCommodity) obj[0];
				UserAuctionData data = new UserAuctionData();
				data.setTradename(tsCommodity.getTradename());
				model.getDataList().add(data);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void follow(UserAuctionData model) throws GeneralException {
		GeneralManager manager = GeneralManager.getCurrentManager();
		LoginBean bean = SessionManager.getLoginInfo(manager.getSessionId());
		if (bean != null) {
			TsUser tsUser = (TsUser) generalDao.get(TsUser.class, bean.getId());
			Iterator iterator = tsUser.getTsBingcurs().iterator();
			String[] ids = new String[tsUser.getTsBingcurs().size()];
			int i = 0;
			while (iterator.hasNext()) {
				TsBingcur tsBingcur = (TsBingcur)iterator.next();
				ids[i++] = tsBingcur.getTsCommodity().getId();
			}
			iterator = generalDao.follow(tsUser.getId(), ids).iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				TsCommodity tsCommodity = (TsCommodity) obj[0];
				UserAuctionData data = new UserAuctionData();
				data.setTradename(tsCommodity.getTradename());
				model.getDataList().add(data);
			}
		}
	}
}
