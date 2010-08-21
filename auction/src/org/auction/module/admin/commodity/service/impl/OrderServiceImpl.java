package org.auction.module.admin.commodity.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.auction.entity.TsBidding;
import org.auction.entity.TsBingcur;
import org.auction.entity.TsCommodity;
import org.auction.entity.TsOrder;
import org.auction.entity.TsUser;
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
		search.add(new SearchBean("ordertype", "eq", "string", model
				.getOrdertype()));
		search.add(new SearchBean("state", "eq", "string", model.getState()));
		List list = generalDao.search(TsOrder.class, search, model
				.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsOrder tsOrder = (TsOrder) list.get(i);
			OrderData data = new OrderData();
			BeanProcessUtils.copyProperties(data, tsOrder);
			data.setCommodityName(tsOrder.getTsCommodity().getTradename());
			model.getDataList().add(data);
		}
	}

	/**
	 * 生成用户购买订单
	 */
	@SuppressWarnings("unchecked")
	public String createOrder(String id, String userId) throws GeneralException {
		String result = "success";
		// 竞拍订单信息
		TsBingcur tsBingcur = (TsBingcur) generalDao.get(TsBingcur.class, id);
		// 用户信息
		TsUser tsUser = (TsUser) generalDao.get(TsUser.class, userId);
		// 商品ID
		TsCommodity tsCommodity = tsBingcur.getTsCommodity();
		// 判断用户是否参与该商品竞拍
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("tsUser.id", "eq", "string", userId));
		search.add(new SearchBean("tsCommodity.id", "eq", "string", tsCommodity
				.getId()));
		List bidingList = generalDao
				.search(TsBidding.class, search, null, null);
		if (bidingList != null && bidingList.size() > 0) {
			// 该用户参加竞拍次数
			int count = bidingList.size();
			// 保存订单
			TsOrder tsOrder = new TsOrder();
			tsOrder.setOrdernum("00000000001");
			tsOrder.setTsUser(tsUser);
			tsOrder.setTsCommodity(tsCommodity);
			tsOrder.setAddress(tsUser.getAddress());
			tsOrder.setOrdertime(new Date());
			tsOrder.setReceiver(tsUser.getRealname());
			tsOrder.setTelphone(tsUser.getTelphone());
			tsOrder.setState("1");
			tsOrder.setFare(new BigDecimal(20));
			tsOrder.setOrdertype("2");
			tsOrder.setEcount(count);
			BigDecimal total = tsCommodity.getPurchasePrice().subtract(
					new BigDecimal(count * 1));
			tsOrder.setAmount(total);
			tsOrder.setTotalPrices(total.add(tsOrder.getFare()));
			generalDao.save(tsOrder);
			result = "success";
		} else {
			result = "没有参加该商品竞拍，不能购买";
		}
		return result;
	}
}
