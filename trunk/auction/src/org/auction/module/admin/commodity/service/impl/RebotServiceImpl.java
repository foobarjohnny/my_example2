package org.auction.module.admin.commodity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.auction.entity.TsRobot;
import org.auction.module.admin.commodity.data.RebotData;
import org.auction.module.admin.commodity.service.RebotService;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.service.GeneralService;
import org.mobile.common.util.BeanProcessUtils;

public class RebotServiceImpl extends GeneralService implements RebotService {

	public void delete(RebotData model) throws GeneralException {
		this.generalDao.delete(TsRobot.class, model.getId());
	}

	public void forward(RebotData model) throws GeneralException {
		if (model.getId() != null && !model.getId().equals("")) {
			TsRobot tsRobot = (TsRobot) generalDao.get(TsRobot.class,
					model.getId());
			BeanProcessUtils.copyProperties(model, tsRobot);
		}
	}

	public void save(RebotData model) throws GeneralException {
		TsRobot tsRobot = new TsRobot();
		BeanProcessUtils.copyProperties(tsRobot, model);
		if (model.getId() != null && !model.getId().equals("")) {
			generalDao.update(tsRobot);
		} else {
			generalDao.save(tsRobot);
		}
	}

	@SuppressWarnings("unchecked")
	public void search(RebotData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		List list = generalDao.search(TsRobot.class, search,
				model.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsRobot tsRobot = (TsRobot) list.get(i);
			RebotData data = new RebotData();
			BeanProcessUtils.copyProperties(data, tsRobot);
			model.getDataList().add(data);
		}
	}

}
