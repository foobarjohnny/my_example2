package org.auction.module.admin.commodity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.auction.entity.TsCommodity;
import org.auction.entity.TsSort;
import org.auction.module.admin.commodity.data.CommodityData;
import org.auction.module.admin.commodity.data.SortData;
import org.auction.module.admin.commodity.service.CommodityService;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.service.GeneralService;
import org.mobile.common.util.BeanProcessUtils;

public class CommodityServiceImpl extends GeneralService implements
		CommodityService {

	public void delete(CommodityData model) throws GeneralException {
		generalDao.delete(TsCommodity.class, model.getId());
	}

	@SuppressWarnings("unchecked")
	public void forward(CommodityData model) throws GeneralException {
		if (model.getId() != null && !model.getId().equals("")) {
			TsCommodity tsCommodity = (TsCommodity) generalDao.get(
					TsCommodity.class, model.getId());
			model.setSortId(tsCommodity.getTsSort().getId());
			BeanProcessUtils.copyProperties(model, tsCommodity);
		}
		List list = generalDao.search(TsSort.class, null, null, null);
		for (int i = 0; i < list.size(); i++) {
			TsSort tsSort = (TsSort) list.get(i);
			SortData data = new SortData();
			BeanProcessUtils.copyProperties(data, tsSort);
			model.getSortList().add(data);
		}
	}

	public void save(CommodityData model) throws GeneralException {
		TsCommodity tsCommodity = new TsCommodity();
		BeanProcessUtils.copyProperties(tsCommodity, model);
		TsSort tsSort = (TsSort) generalDao
				.get(TsSort.class, model.getSortId());
		tsCommodity.setTsSort(tsSort);
		if (model.getId() != null && !model.getId().equals("")) {
			generalDao.update(tsCommodity);
		} else {
			tsCommodity.setState("4");
			generalDao.save(tsCommodity);
		}
	}

	@SuppressWarnings("unchecked")
	public void search(CommodityData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		List list = generalDao.search(TsCommodity.class, search, model
				.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsCommodity tsCommodity = (TsCommodity) list.get(i);
			CommodityData data = new CommodityData();
			data.setSortName(tsCommodity.getTsSort().getSortname());
			BeanProcessUtils.copyProperties(data, tsCommodity);
			model.getDataList().add(data);
		}
	}

	@SuppressWarnings("unchecked")
	public void searchLot(CommodityData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("state", "eq", "string", "2"));
		List list = generalDao.search(TsCommodity.class, search, model
				.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsCommodity tsCommodity = (TsCommodity) list.get(i);
			CommodityData data = new CommodityData();
			data.setSortName(tsCommodity.getTsSort().getSortname());
			BeanProcessUtils.copyProperties(data, tsCommodity);
			model.getDataList().add(data);
		}
	}

	@SuppressWarnings("unchecked")
	public void searchProgress(CommodityData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("state", "eq", "string", "1"));
		List list = generalDao.search(TsCommodity.class, search, model
				.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsCommodity tsCommodity = (TsCommodity) list.get(i);
			CommodityData data = new CommodityData();
			data.setSortName(tsCommodity.getTsSort().getSortname());
			BeanProcessUtils.copyProperties(data, tsCommodity);
			model.getDataList().add(data);
		}
	}

	@SuppressWarnings("unchecked")
	public void searchReach(CommodityData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("state", "eq", "string", "3"));
		List list = generalDao.search(TsCommodity.class, search, model
				.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsCommodity tsCommodity = (TsCommodity) list.get(i);
			CommodityData data = new CommodityData();
			data.setSortName(tsCommodity.getTsSort().getSortname());
			BeanProcessUtils.copyProperties(data, tsCommodity);
			model.getDataList().add(data);
		}
	}

	public void auction(CommodityData model) throws GeneralException {
		TsCommodity tsCommodity = (TsCommodity) generalDao.get(
				TsCommodity.class, model.getId());
		tsCommodity.setState("1");
		generalDao.update(tsCommodity);
	}

	@SuppressWarnings("unchecked")
	public void select(CommodityData model) throws GeneralException {
		List list = generalDao.select();
		for (int i = 0; i < list.size(); i++) {
			TsCommodity tsCommodity = (TsCommodity) list.get(i);
			CommodityData data = new CommodityData();
			data.setSortName(tsCommodity.getTsSort().getSortname());
			BeanProcessUtils.copyProperties(data, tsCommodity);
			model.getDataList().add(data);
		}
	}
}
