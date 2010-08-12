package org.auction.module.admin.user.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.auction.entity.TsUser;
import org.auction.module.admin.user.data.UserData;
import org.auction.module.admin.user.service.UserService;
import org.mobile.common.bean.LoginBean;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.manager.GeneralManager;
import org.mobile.common.service.GeneralService;
import org.mobile.common.session.SessionManager;
import org.mobile.common.util.BeanProcessUtils;

public class UserServiceImpl extends GeneralService implements UserService {

	public void delete(UserData model) throws GeneralException {
		generalDao.delete(TsUser.class, model.getId());
	}

	public void forward(UserData model) throws GeneralException {
		if (model.getId() != null && !model.getId().equals("")) {
			TsUser tsUser = (TsUser) generalDao
					.get(TsUser.class, model.getId());
			BeanProcessUtils.copyProperties(model, tsUser);
		}
	}

	public void save(UserData model) throws GeneralException {
		TsUser tsUser = new TsUser();
		BeanProcessUtils.copyProperties(tsUser, model);
		if (model.getId() != null && !model.getId().equals("")) {
			generalDao.update(tsUser);
		} else {
			tsUser.setHouroflogon(new Date());
			generalDao.save(tsUser);
		}
	}

	@SuppressWarnings("unchecked")
	public void search(UserData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		List list = generalDao.search(TsUser.class, search,
				model.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsUser tsUser = (TsUser) list.get(i);
			UserData data = new UserData();
			BeanProcessUtils.copyProperties(data, tsUser);
			model.getDataList().add(data);
		}
	}

	@SuppressWarnings("unchecked")
	public boolean login(UserData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("username", "eq", "string", model
				.getUsername()));
		search.add(new SearchBean("password", "eq", "string", model
				.getPassword()));
		List list = generalDao.search(TsUser.class, search, null, null);
		if (list != null && list.size() > 0) {
			TsUser tsUser = (TsUser) list.get(0);
			LoginBean bean = new LoginBean();
			bean.setWorkNo(tsUser.getUsername());
			bean.setId(tsUser.getId());
			GeneralManager manager = GeneralManager.getCurrentManager();
			SessionManager.setLoginInfo(manager.getSessionId(), bean);
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public LoginBean loginDwr(UserData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("username", "eq", "string", model
				.getUsername()));
		search.add(new SearchBean("password", "eq", "string", model
				.getPassword()));
		List list = generalDao.search(TsUser.class, search, null, null);
		if (list != null && list.size() > 0) {
			TsUser tsUser = (TsUser) list.get(0);
			LoginBean bean = new LoginBean();
			bean.setWorkNo(tsUser.getUsername());
			bean.setId(tsUser.getId());
			// GeneralManager manager = GeneralManager.getCurrentManager();
			// SessionManager.setLoginInfo(manager.getSessionId(), bean);
			return bean;
		}
		return null;
	}

	public void regedit(UserData model) throws GeneralException {
		TsUser tsUser = new TsUser();
		BeanProcessUtils.copyProperties(tsUser, model);
		tsUser.setHouroflogon(new Date());
		generalDao.save(tsUser);
		LoginBean bean = new LoginBean();
		bean.setWorkNo(tsUser.getUsername());
		bean.setId(tsUser.getId());
		GeneralManager manager = GeneralManager.getCurrentManager();
		SessionManager.setLoginInfo(manager.getSessionId(), bean);
	}

	public void view(UserData model) throws GeneralException {
		GeneralManager manager = GeneralManager.getCurrentManager();
		LoginBean bean = SessionManager.getLoginInfo(manager.getSessionId());
		TsUser tsUser = (TsUser) generalDao.get(TsUser.class, bean.getId());
		BeanProcessUtils.copyProperties(model, tsUser);
	}

	public void update(UserData model) throws GeneralException {
		TsUser tsUser = new TsUser();
		BeanProcessUtils.copyProperties(tsUser, model);
		generalDao.update(tsUser);
	}
}
