package org.auction.module.admin.commodity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.auction.entity.TsBuy;
import org.auction.module.admin.commodity.data.BuyData;
import org.auction.module.admin.commodity.service.BuyService;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.service.GeneralService;
import org.mobile.common.util.BeanProcessUtils;

public class BuyServiceImpl extends GeneralService implements BuyService {

	public void delete(BuyData model) throws GeneralException {
		generalDao.delete(TsBuy.class, model.getId());
	}

	public void forward(BuyData model) throws GeneralException {
		if (model.getId() != null && !model.getId().equals("")) {
			TsBuy tsBuy = (TsBuy) generalDao.get(TsBuy.class,
					model.getId());
			BeanProcessUtils.copyProperties(model, tsBuy);
		}
	}

	public void save(BuyData model) throws GeneralException {
		TsBuy tsBuy = new TsBuy();
		BeanProcessUtils.copyProperties(tsBuy, model);
		if (model.getId() != null && !model.getId().equals("")) {
			generalDao.update(tsBuy);
		} else {
			generalDao.save(tsBuy);
		}
	}

	@SuppressWarnings("unchecked")
	public void search(BuyData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		List list = generalDao.search(TsBuy.class, search,
				model.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsBuy tsBuy = (TsBuy) list.get(i);
			BuyData data = new BuyData();
			BeanProcessUtils.copyProperties(data, tsBuy);
			if (tsBuy.getTsUser() != null) {
				data.setUsername(tsBuy.getTsUser().getUsername());
			}
			model.getDataList().add(data);
		}
	}
	
	

}