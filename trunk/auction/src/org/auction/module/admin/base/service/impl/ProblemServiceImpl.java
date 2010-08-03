package org.auction.module.admin.base.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.auction.entity.TsProblem;
import org.auction.module.admin.base.data.ProblemData;
import org.auction.module.admin.base.service.ProblemService;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.service.GeneralService;
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

	public void saveInfo(ProblemData model) throws GeneralException {
		TsProblem tsProblem = new TsProblem();
		BeanProcessUtils.copyProperties(tsProblem, model);
		// tsProblem.setReleasedate(new java.sql.Timestamp(new Date()));
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
			model.getDataList().add(data);
		}
	}
}
