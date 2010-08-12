package org.auction.module.admin.commodity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.auction.entity.TsConsume;
import org.auction.module.admin.commodity.data.ConsumeData;
import org.auction.module.admin.commodity.service.ConsumeService;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.service.GeneralService;
import org.mobile.common.util.BeanProcessUtils;

public class ConsumeServiceImpl extends GeneralService implements ConsumeService {

	public void delete(ConsumeData model) throws GeneralException {
		generalDao.delete(TsConsume.class, model.getId());
	}

	public void forward(ConsumeData model) throws GeneralException {
		if (model.getId() != null && !model.getId().equals("")) {
			TsConsume tsConsume = (TsConsume) generalDao.get(TsConsume.class,
					model.getId());
			BeanProcessUtils.copyProperties(model, tsConsume);
		}
	}

	public void save(ConsumeData model) throws GeneralException {
		TsConsume tsConsume = new TsConsume();
		BeanProcessUtils.copyProperties(tsConsume, model);
		if (model.getId() != null && !model.getId().equals("")) {
			generalDao.update(tsConsume);
		} else {
			generalDao.save(tsConsume);
		}
	}

	@SuppressWarnings("unchecked")
	public void search(ConsumeData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		List list = generalDao.search(TsConsume.class, search,
				model.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsConsume tsConsume = (TsConsume) list.get(i);
			ConsumeData data = new ConsumeData();
			BeanProcessUtils.copyProperties(data, tsConsume);
			if (tsConsume.getTsUser() != null) {
				data.setUsername(tsConsume.getTsUser().getUsername());
			}
			model.getDataList().add(data);
		}
	}

}
