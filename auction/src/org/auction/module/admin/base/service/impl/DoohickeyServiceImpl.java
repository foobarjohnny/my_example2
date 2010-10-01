package org.auction.module.admin.base.service.impl;

import org.auction.entity.TsDoohickey;
import org.auction.entity.TsUser;
import org.auction.module.admin.base.data.DoohickeyData;
import org.auction.module.admin.base.service.DoohickeyService;
import org.mobile.common.bean.LoginBean;
import org.mobile.common.manager.GeneralManager;
import org.mobile.common.service.GeneralService;
import org.mobile.common.session.SessionManager;
import org.mobile.common.util.BeanProcessUtils;

public class DoohickeyServiceImpl extends GeneralService implements
		DoohickeyService {

	public void delete(DoohickeyData model) throws Exception {
		generalDao.delete(TsDoohickey.class, model.getId());
	}

	public void forward(DoohickeyData model) throws Exception {
		GeneralManager manan = GeneralManager.getCurrentManager();
		LoginBean sess = SessionManager.getLoginInfo(manan.getSessionId());
		TsUser tsUser = (TsUser) generalDao.get(TsUser.class, sess.getId());
		TsDoohickey tsDoohickey = new TsDoohickey();
		BeanProcessUtils.copyProperties(tsDoohickey, model);
		tsDoohickey.setTsUser(tsUser);
	}

	public void save(DoohickeyData model) throws Exception {

	}

	public void search(DoohickeyData model) throws Exception {

	}

}
