package org.auction.module.admin.commodity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.auction.entity.TsAid;
import org.auction.module.admin.commodity.data.AidData;
import org.auction.module.admin.commodity.service.AidService;
import org.mobile.common.bean.LoginBean;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.manager.GeneralManager;
import org.mobile.common.service.GeneralService;
import org.mobile.common.session.SessionManager;
import org.mobile.common.util.BeanProcessUtils;

public class AidServiceImpl extends GeneralService implements AidService {

	/**
	 * 用户删除竞拍助理，并返回点数
	 */
	public void delete(AidData model) throws Exception {

	}

	/**
	 * 用户设置竞拍助理
	 */
	public void edit(AidData model) throws Exception {

	}

	/**
	 * 用户查询竞拍助理列表
	 */
	@SuppressWarnings("unchecked")
	public void searchList(AidData model) throws Exception {
		LoginBean loginBean = SessionManager.getLoginInfo(GeneralManager
				.getCurrentManager().getSessionId());
		if (loginBean != null) {
			List<SearchBean> search = new ArrayList<SearchBean>();
			search.add(new SearchBean("tsUser.id", "eq", "string", loginBean
					.getId()));
			search.add(new SearchBean("state", "eq", "string", "1"));
			List list = generalDao.search(TsAid.class, search, model
					.getPageBean(), null);
			for (int i = 0; i < list.size(); i++) {
				TsAid tsAid = (TsAid) list.get(i);
				AidData data = new AidData();
				BeanProcessUtils.copyProperties(data, tsAid);
				data.setComid(tsAid.getTsCommodity().getId());
				data.setComname(tsAid.getTsCommodity().getTradename());
				model.getDataList().add(data);
			}
		}
	}

}
