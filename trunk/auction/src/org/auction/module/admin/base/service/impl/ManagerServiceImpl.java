package org.auction.module.admin.base.service.impl;

import java.util.List;

import org.auction.entity.TsManager;
import org.auction.module.admin.base.data.ManagerData;
import org.auction.module.admin.base.service.ManagerService;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.service.GeneralService;
import org.mobile.common.util.BeanProcessUtils;

public class ManagerServiceImpl extends GeneralService implements
		ManagerService {

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
}
