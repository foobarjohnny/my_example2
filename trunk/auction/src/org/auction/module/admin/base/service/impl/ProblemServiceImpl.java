package org.auction.module.admin.base.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.auction.entity.TsProblem;
import org.auction.entity.TsUser;
import org.auction.module.admin.base.data.ProblemData;
import org.auction.module.admin.base.service.ProblemService;
import org.mobile.common.bean.LoginBean;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.manager.GeneralManager;
import org.mobile.common.service.GeneralService;
import org.mobile.common.session.SessionManager;
import org.mobile.common.util.BeanProcessUtils;

public class ProblemServiceImpl extends GeneralService implements
		ProblemService {

	public void forwardInfo(ProblemData model) throws GeneralException {
		if (model.getId() != null && !model.getId().equals("")) {
			TsProblem tsProblem = (TsProblem) generalDao.get(TsProblem.class,
					model.getId());
			BeanProcessUtils.copyProperties(model, tsProblem);
		}
	}

	public void proForward(ProblemData model) throws GeneralException {
		GeneralManager g = GeneralManager.getCurrentManager();
		LoginBean lb = (LoginBean) SessionManager
				.getLoginInfo(g.getSessionId());
		model.setUserId(lb.getId());
		model.setUsername(lb.getWorkNo());
	}

	public void savePro(ProblemData model) throws GeneralException {
		TsProblem tsProblem = (TsProblem) generalDao.get(TsProblem.class, model
				.getId());
		tsProblem.setDetails(model.getDetails());
		generalDao.update(tsProblem);
	}

	public void saveInfo(ProblemData model) throws GeneralException {
		TsProblem tsProblem = new TsProblem();
		if (model.getId() != null && !model.getId().equals("")) {
			tsProblem = (TsProblem) generalDao.get(TsUser.class, model
					.getUserId());
		}
		BeanProcessUtils.copyProperties(tsProblem, model);
		tsProblem.setReleasedate(new Date());
		tsProblem.setTsUser((TsUser) generalDao.get(TsUser.class, model
				.getUserId()));
		if (model.getId() != null && !model.getId().equals("")) {
			generalDao.update(tsProblem);
		} else {
			tsProblem.setId(null);
			generalDao.save(tsProblem);
		}
	}

	public void delete(ProblemData model) throws GeneralException {
		generalDao.delete(TsProblem.class, model.getId());
	}

	@SuppressWarnings("unchecked")
	public void search(ProblemData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		List list = generalDao.search(TsProblem.class, search, model
				.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsProblem tsProblem = (TsProblem) list.get(i);
			ProblemData data = new ProblemData();
			BeanProcessUtils.copyProperties(data, tsProblem);
			data.setUsername(tsProblem.getTsUser().getUsername());
			model.getDataList().add(data);
		}
	}
}
