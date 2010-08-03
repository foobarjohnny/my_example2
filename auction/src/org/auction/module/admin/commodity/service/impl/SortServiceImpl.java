package org.auction.module.admin.commodity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.auction.entity.TsSort;
import org.auction.module.admin.commodity.data.SortData;
import org.auction.module.admin.commodity.service.SortService;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.service.GeneralService;
import org.mobile.common.util.BeanProcessUtils;

public class SortServiceImpl extends GeneralService implements SortService {

	public void delete(SortData model) throws GeneralException {
		generalDao.delete(TsSort.class, model.getId());
	}

	public void forward(SortData model) throws GeneralException {
		if (model.getId() != null && !model.getId().equals("")) {
			TsSort tsSort = (TsSort) generalDao.get(TsSort.class,
					model.getId());
			BeanProcessUtils.copyProperties(model, tsSort);
		}
	}

	public void save(SortData model) throws GeneralException {
		TsSort tsSort = new TsSort();
		BeanProcessUtils.copyProperties(tsSort, model);
		if (model.getId() != null && !model.getId().equals("")) {
			generalDao.update(tsSort);
		} else {
			generalDao.save(tsSort);
		}
	}

	@SuppressWarnings("unchecked")
	public void search(SortData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		List list = generalDao.search(TsSort.class, search,
				model.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsSort tsSort = (TsSort) list.get(i);
			SortData data = new SortData();
			BeanProcessUtils.copyProperties(data, tsSort);
			model.getDataList().add(data);
		}
	}

}
