package org.auction.module.admin.user.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import org.auction.entity.TsInfo;
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

	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	public void delete(UserData model) throws GeneralException {
		generalDao.delete(TsUser.class, model.getId());
	}

	public void forward(UserData model) throws GeneralException {
		GeneralManager m = GeneralManager.getCurrentManager();
		LoginBean lb = SessionManager.getLoginInfo(m.getSessionId());
		if (lb != null) {
			TsUser tsUser = (TsUser) generalDao.get(TsUser.class, lb.getId());
			BeanProcessUtils.copyProperties(model, tsUser);
		}
	}

	@SuppressWarnings("unchecked")
	public void regForward(UserData model) throws Exception {
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("nettype", "eq", "string", "4"));
		List list = generalDao.search(TsInfo.class, null, model.getPageBean(),
				null);
		if (list != null && list.size() > 0) {
			TsInfo tsInfo = (TsInfo) list.get(0);
			model.setInfo(tsInfo.getInfo());
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
		System.out.println("开始进行客户的登录处理。。。。。。。。" + model.getUsername() + " "
				+ model.getPassword());
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

		System.out.println("dwr开始进行客户的登录处理。。。。。。。。" + model.getUsername() + " "
				+ model.getPassword());
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
			bean.setPaycur(tsUser.getPaycur());
			bean.setFreecur(tsUser.getFreecur());
			// 获得用户拍到商品数
			String hql = "select count(id) from TsBingcur t where t.tsUser.id='"
					+ tsUser.getId() + "'";
			Object o = generalDao.executeQuery(hql);
			bean.setAmount(Integer.parseInt(String.valueOf(o)));
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

	public void reg(UserData model) throws GeneralException {
		TsUser tsUser = new TsUser();
		BeanProcessUtils.copyProperties(tsUser, model);
		tsUser.setHouroflogon(new Date());
		generalDao.save(tsUser);
		LoginBean bean = new LoginBean();
		bean.setWorkNo(tsUser.getUsername());
		bean.setId(tsUser.getId());
		// GeneralManager manager = GeneralManager.getCurrentManager();
		// SessionManager.setLoginInfo(manager.getSessionId(), bean);
		// 用户邀请注册
		if (model.getRegId() != null && !model.getRegId().equals("")) {
			TsUser user = (TsUser) generalDao.get(TsUser.class, model
					.getRegId());
			user.setFreecur(user.getFreecur() + 20);
		}
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

	/**
	 * 检查用户属性
	 */
	@SuppressWarnings("unchecked")
	public boolean checkedUser(UserData model) throws Exception {
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean(model.getMethodName(), "eq", "string", model
				.getEmail()));
		List list = generalDao.search(TsUser.class, search, null, null);
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}
}
