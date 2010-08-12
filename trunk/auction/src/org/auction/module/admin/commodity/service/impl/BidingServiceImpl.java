package org.auction.module.admin.commodity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.auction.entity.TsBidding;
import org.auction.module.admin.commodity.data.BidingData;
import org.auction.module.admin.commodity.service.BidingService;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.service.GeneralService;

public class BidingServiceImpl extends GeneralService implements BidingService {

	@SuppressWarnings("unchecked")
	public List findNewPeople(BidingData model) throws GeneralException {
		List<SearchBean> searchBeans = new ArrayList<SearchBean>();
		searchBeans.add(new SearchBean("tsCommodity.id", "eq", "string", model
				.getCommpityId()));
		searchBeans.add(new SearchBean("isbid", "eq", "string", "1"));
		if (model.getUserId() != null && !model.getUserId().equals("")) {
			searchBeans.add(new SearchBean("tsUser.id", "neq", "string", model
					.getUserId()));
		}
		List list = generalDao.search(TsBidding.class, searchBeans, null, null);
		List<BidingData> newList = new ArrayList<BidingData>();
		for (int i = 0; i < list.size(); i++) {
			TsBidding tsBiding = (TsBidding) list.get(i);
			BidingData data = new BidingData();
			data.setUserId(tsBiding.getTsUser().getId());
			data.setUsername(tsBiding.getTsUser().getUsername());
			data.setPrice(tsBiding.getPrice());
			newList.add(data);
		}
		return newList;
	}

	public String delete(BidingData model) throws GeneralException {
		// TODO Auto-generated method stub
		return null;
	}

	public String forward(BidingData model) throws GeneralException {
		// TODO Auto-generated method stub
		return null;
	}

	public String save(BidingData model) throws GeneralException {
		// TODO Auto-generated method stub
		return null;
	}

	public String search(BidingData model) throws GeneralException {
		// TODO Auto-generated method stub
		return null;
	}

}
