package org.auction.module.admin.base.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.auction.entity.TsInfo;
import org.auction.module.admin.base.data.InfoData;
import org.auction.module.admin.base.service.InfoService;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.service.GeneralService;
import org.mobile.common.util.BeanProcessUtils;

public class InfoServiceImpl extends GeneralService implements InfoService {

	@SuppressWarnings("unchecked")
	public void forwardInfo(InfoData model) throws GeneralException {
		List<SearchBean> searchs = new ArrayList<SearchBean>();
		if (model.getNettype().equals("1")) {
			searchs.add(new SearchBean("nettype", "eq", "string", "1"));
			// 以后处理
			List list = generalDao.search(TsInfo.class, searchs, null, null);
			if (list != null && list.size() > 0) {
				TsInfo tsInfo = (TsInfo) list.get(0);
				BeanProcessUtils.copyProperties(model, tsInfo);
			}
		} else if (model.getNettype().equals("2")) {
			searchs.add(new SearchBean("nettype", "eq", "string", "2"));
			List list = generalDao.search(TsInfo.class, searchs, null, null);
			if (list != null && list.size() > 0) {
				TsInfo tsInfo = (TsInfo) list.get(0);
				BeanProcessUtils.copyProperties(model, tsInfo);
			}
		} else if (model.getNettype().equals("4")) {
			searchs.add(new SearchBean("nettype", "eq", "string", "4"));
			List list = generalDao.search(TsInfo.class, searchs, null, null);
			if (list != null && list.size() > 0) {
				TsInfo tsInfo = (TsInfo) list.get(0);
				BeanProcessUtils.copyProperties(model, tsInfo);
			}
		} else if (model.getNettype().equals("3")) {
			if (model.getId() != null && !model.getId().equals("")) {
				TsInfo tsInfo = (TsInfo) generalDao.get(TsInfo.class, model
						.getId());
				BeanProcessUtils.copyProperties(model, tsInfo);
			}
		} else if (model.getNettype().equals("5")) {
			if (model.getId() != null && !model.getId().equals("")) {
				TsInfo tsInfo = (TsInfo) generalDao.get(TsInfo.class, model
						.getId());
				BeanProcessUtils.copyProperties(model, tsInfo);
			}
		}
	}

	public void saveInfo(InfoData model) throws GeneralException {
		TsInfo tsInfo = new TsInfo();
		BeanProcessUtils.copyProperties(tsInfo, model);
		tsInfo.setReleasedate(new Date(System.currentTimeMillis()));
		if (model.getId() != null && !model.getId().equals("")) {
			generalDao.update(tsInfo);
		} else {
			tsInfo.setId(null);
			generalDao.save(tsInfo);
		}
	}

	public void delete(InfoData model) throws GeneralException {
		generalDao.delete(TsInfo.class, model.getId());
	}

	@SuppressWarnings("unchecked")
	public void search(InfoData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		if (model.getNettype().equals("3")) {
			search.add(new SearchBean("nettype", "eq", "string", "3"));
		} else if (model.getNettype().equals("5")) {
			search.add(new SearchBean("nettype", "eq", "string", "5"));
		}
		List list = generalDao.search(TsInfo.class, search,
				model.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsInfo tsInfo = (TsInfo) list.get(i);
			InfoData data = new InfoData();
			BeanProcessUtils.copyProperties(data, tsInfo);
			model.getDataList().add(data);
		}
	}
}
