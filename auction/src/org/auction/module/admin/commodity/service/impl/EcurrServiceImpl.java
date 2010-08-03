package org.auction.module.admin.commodity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.auction.entity.TsEcurr;
import org.auction.module.admin.commodity.data.EcurrData;
import org.auction.module.admin.commodity.service.EcurrService;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.service.GeneralService;
import org.mobile.common.util.BeanProcessUtils;

public class EcurrServiceImpl extends GeneralService implements EcurrService {

	public void delete(EcurrData model) throws GeneralException {
		generalDao.delete(TsEcurr.class, model.getId());
	}

	public void forward(EcurrData model) throws GeneralException {
		if (model.getId() != null && !model.getId().equals("")) {
			TsEcurr tsEcurr = (TsEcurr) generalDao.get(TsEcurr.class,
					model.getId());
			BeanProcessUtils.copyProperties(model, tsEcurr);
		}
	}

	public void save(EcurrData model) throws GeneralException {
		TsEcurr tsEcurr = new TsEcurr();
		BeanProcessUtils.copyProperties(tsEcurr, model);
		if (model.getId() != null && !model.getId().equals("")) {
			generalDao.update(tsEcurr);
		} else {
			generalDao.save(tsEcurr);
		}
	}

	@SuppressWarnings("unchecked")
	public void search(EcurrData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		List list = generalDao.search(TsEcurr.class, search,
				model.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsEcurr tsEcurr = (TsEcurr) list.get(i);
			EcurrData data = new EcurrData();
			BeanProcessUtils.copyProperties(data, tsEcurr);
			model.getDataList().add(data);
		}
	}

}
