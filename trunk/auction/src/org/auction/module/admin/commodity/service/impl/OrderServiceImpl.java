package org.auction.module.admin.commodity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.auction.entity.TsOrder;
import org.auction.module.admin.commodity.data.OrderData;
import org.auction.module.admin.commodity.service.OrderService;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.service.GeneralService;
import org.mobile.common.util.BeanProcessUtils;

public class OrderServiceImpl extends GeneralService implements OrderService {

	public void delete(OrderData model) throws GeneralException {

	}

	public void forward(OrderData model) throws GeneralException {

	}

	public void save(OrderData model) throws GeneralException {

	}

	@SuppressWarnings("unchecked")
	public void search(OrderData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("ordertype","eq","string",model.getOrdertype()));
		search.add(new SearchBean("state","eq","string",model.getState()));
		List list = generalDao.search(TsOrder.class, search,
				model.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsOrder tsOrder = (TsOrder) list.get(i);
			OrderData data = new OrderData();
			BeanProcessUtils.copyProperties(data, tsOrder);
			data.setCommodityName(tsOrder.getTsCommodity().getTradename());
			model.getDataList().add(data);
		}
	}
}
