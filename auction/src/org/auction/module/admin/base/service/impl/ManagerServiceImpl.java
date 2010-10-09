package org.auction.module.admin.base.service.impl;

import java.util.ArrayList; 
import java.util.List;

import org.apache.log4j.Logger;

import org.auction.entity.TsManager;
import org.auction.module.admin.base.data.ManagerData;
import org.auction.module.admin.base.service.ManagerService;
import org.mobile.common.bean.LoginBean;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.manager.GeneralManager;
import org.mobile.common.service.GeneralService;
import org.mobile.common.session.SessionManager;
import org.mobile.common.util.BeanProcessUtils;

public class ManagerServiceImpl extends GeneralService implements
		ManagerService {

	private static Logger log = Logger.getLogger(ManagerServiceImpl.class);
	
	public void forwardInfo(ManagerData model) throws GeneralException {
		if (model.getId() != null && !model.getId().equals("")) {
			TsManager tsManager = (TsManager) generalDao.load(TsManager.class,
					model.getId());
			BeanProcessUtils.copyProperties(model, tsManager);
			if (tsManager.getManagerFun() != null) {
				String[] s = tsManager.getManagerFun().split(",");
				Long[] l = new Long[s.length];
				for (int i = 0; i < s.length; i++) {
					l[i] = Long.parseLong(s[i]);
				}
				model.setValues(l);
			}
		}
	}

	public void saveInfo(ManagerData model) throws GeneralException {
		TsManager tsManager = null;
		if (model.getId() != null && !model.getId().equals("")) {
			tsManager = (TsManager) generalDao.load(TsManager.class, model
					.getId());
		} else {
			tsManager = new TsManager();
		}
		String password = tsManager.getPassword();
		BeanProcessUtils.copyProperties(tsManager, model);
		if (model.getPassword() == null || model.getPassword().equals("")) {
			tsManager.setPassword(password);
		}
		String[] fun = model.getManagerFuns();
		String fs = "";
		if (fun != null && fun.length > 0) {
			for (int i = 0; i < fun.length; i++) {
				if (!fs.equals("")) {
					fs += "," + fun[i];
				} else {
					fs = fun[i];
				}
			}
		}
		tsManager.setManagerFun(fs);
		if (model.getId() != null && !model.getId().equals("")) {
			generalDao.update(tsManager);
		} else {
			generalDao.save(tsManager);
		}
	}

	public void delete(ManagerData model) throws GeneralException {
		generalDao.delete(TsManager.class, model.getId());
	}

	@SuppressWarnings("unchecked")
	public void search(ManagerData model) throws GeneralException {
		List list = generalDao.search(TsManager.class, model.getSearchBeans(),
				model.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsManager tsManager = (TsManager) list.get(i);
			ManagerData data = new ManagerData();
			BeanProcessUtils.copyProperties(data, tsManager);
			if (tsManager.getManagerFun() != null) {
				data.setManagerFuns(tsManager.getManagerFun().split(","));
			}
			model.getDataList().add(data);
		}
	}

	/**
	 * 实现管理员登录后台的操作
	 */
	public boolean login(ManagerData data) throws GeneralException {
		log.debug("开始进行客户的登录处理。。。。。。。。" + data.getAccount() + " " + data.getPassword());
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("account", "eq", "string", data.getAccount()));
		search.add(new SearchBean("password", "eq", "string", data.getPassword()));
		List list = generalDao.search(TsManager.class, search, null, null);
		if (list != null && list.size() > 0) {
			TsManager tsManager = (TsManager) list.get(0);
			LoginBean bean = new LoginBean();
			bean.setId(tsManager.getId());
			GeneralManager manager = GeneralManager.getCurrentManager();
			SessionManager.setLoginInfo(manager.getSessionId(), bean);
			return true;
		}
		return false;
	}

	/**
	 * 通过DWR实现管理员登录后台的操作
	 */
	public LoginBean loginDwr(ManagerData data) throws GeneralException {
		log.debug("dwr开始进行客户的登录处理。。。。。。。。" + data.getAccount() + " " + data.getPassword());
		// 根据用户名，密码查询用户
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("account", "eq", "string", data.getAccount()));
		search.add(new SearchBean("password", "eq", "string", data.getPassword()));
		List list = generalDao.search(TsManager.class, search, null, null);
		// 获得用户，并获得用户相关信息
		if (list != null && list.size() > 0) {
			TsManager tsManager = (TsManager) list.get(0);
			LoginBean bean = new LoginBean();
			bean.setId(tsManager.getId());
			bean.setWorkNo(tsManager.getRealname());
			return bean;
		}
		return null;
	}
}
