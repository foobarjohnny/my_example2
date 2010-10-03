package org.auction.module.admin.base.service.impl;

import java.util.Date;
import java.util.List;

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
		model.setUserid(sess.getId());
		model.setUsername(sess.getWorkNo());
	}

	public void view(DoohickeyData model) throws Exception {
		TsDoohickey tsDoohickey = (TsDoohickey) generalDao.get(
				TsDoohickey.class, model.getId());
		model.setTitle(tsDoohickey.getTitle());
		model.setAddtime(tsDoohickey.getAddtime());
		model.setRemark(tsDoohickey.getRemark());
		model.setUsername(tsDoohickey.getTsUser().getUsername());
	}

	public void save(DoohickeyData model) throws Exception {
		GeneralManager manan = GeneralManager.getCurrentManager();
		LoginBean sess = SessionManager.getLoginInfo(manan.getSessionId());
		TsUser tsUser = (TsUser) generalDao.get(TsUser.class, sess.getId());
		TsDoohickey tsDoohickey = new TsDoohickey();
		tsDoohickey.setTsUser(tsUser);
		tsDoohickey.setAddtime(new Date());
		tsDoohickey.setRemark(model.getRemark());
		tsDoohickey.setTitle(model.getTitle());
		generalDao.save(tsDoohickey);
	}

	@SuppressWarnings("unchecked")
	public void search(DoohickeyData model) throws Exception {
		List list = generalDao.search(TsDoohickey.class,
				model.getSearchBeans(), model.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsDoohickey tsDoohickey = (TsDoohickey) list.get(i);
			DoohickeyData data = new DoohickeyData();
			BeanProcessUtils.copyProperties(data, tsDoohickey);
			data.setUsername(tsDoohickey.getTsUser().getUsername());
			model.getDataList().add(data);
		}
	}

}
