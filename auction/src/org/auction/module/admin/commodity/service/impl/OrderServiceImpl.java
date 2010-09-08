package org.auction.module.admin.commodity.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.auction.alipay.AlipayConfig;
import org.auction.entity.TsBidding;
import org.auction.entity.TsBingcur;
import org.auction.entity.TsCommodity;
import org.auction.entity.TsNum;
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
		// 获得订单
		TsOrder tsOrder = (TsOrder) this.generalDao.get(TsOrder.class, model
				.getId());
		tsOrder.setState("6");
		generalDao.update(tsOrder);
	}

	public void channel(OrderData model) throws GeneralException {
		// 获得订单
		TsOrder tsOrder = (TsOrder) this.generalDao.get(TsOrder.class, model
				.getId());
		tsOrder.setState("5");
		generalDao.update(tsOrder);
	}

	public void view(OrderData model) throws GeneralException {
		// 获得订单
		TsOrder tsOrder = (TsOrder) this.generalDao.get(TsOrder.class, model
				.getId());
		BeanProcessUtils.copyProperties(model, tsOrder);
		model.setCommodityName(tsOrder.getTsCommodity().getTradename());
	}

	@SuppressWarnings("unchecked")
	public void orderView(OrderData model) throws GeneralException {
		// 获得订单
		TsOrder tsOrder = (TsOrder) this.generalDao.get(TsOrder.class, model
				.getId());
		BeanProcessUtils.copyProperties(model, tsOrder);
		model.setCommodityName(tsOrder.getTsCommodity().getTradename());
		model.setComId(tsOrder.getTsCommodity().getId());
		model.setEcount(tsOrder.getEcount());
		// 商品价格
		model.setAmount(tsOrder.getAmount());
		BigDecimal bd = new BigDecimal(0);
		// 总价格
		BigDecimal total = new BigDecimal(0);
		if (tsOrder.getFare() != null) {
			total = tsOrder.getAmount().add(tsOrder.getFare());
			bd = tsOrder.getAmount().add(tsOrder.getFare());
		}
		if (tsOrder.getEcount() != null) {
			total = total.add(new BigDecimal(tsOrder.getEcount() * 2));
			bd = bd.subtract(new BigDecimal(tsOrder.getEcount() * 2));
		}
		model.setComprice(total);
		// 应付价格
		model.setTotalPrices(bd);
		
		// 查询该商品成交用户
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("tsCommodity.id", "eq", "string", tsOrder
				.getTsCommodity().getId()));
		List bing_list = generalDao.search(TsBingcur.class, search, null,
				null);
		if (bing_list != null && bing_list.size() > 0) {
			TsBingcur tsBingcur = (TsBingcur) bing_list.get(0);
			model.setBidId(tsBingcur.getId());
		}
	}

	public void forward(OrderData model) throws GeneralException {
		// 获得订单
		TsOrder tsOrder = (TsOrder) this.generalDao.get(TsOrder.class, model
				.getId());
		BeanProcessUtils.copyProperties(model, tsOrder);
		model.setCommodityName(tsOrder.getTsCommodity().getTradename());
	}

	@SuppressWarnings("unchecked")
	public void pay(OrderData model) throws GeneralException {
		// 获得订单
		TsOrder tsOrder = (TsOrder) this.generalDao.get(TsOrder.class, model
				.getId());
		// 生成参数
		Map params = new HashMap();
		params.put("service", AlipayConfig.service);
		params.put("partner", AlipayConfig.partner);
		params.put("subject", tsOrder.getTsCommodity().getTradename());
		params.put("body", tsOrder.getTsCommodity().getSummary());
		params.put("out_trade_no", tsOrder.getId());
		params.put("total_fee", String.valueOf(tsOrder.getTotalPrices()));
		params.put("payment_type", AlipayConfig.payment_type);
		params.put("seller_email", AlipayConfig.seller_email);
		params.put("return_url", AlipayConfig.return_url);
		params.put("notify_url", AlipayConfig.notify_url);
		params.put("_input_charset", AlipayConfig.input_charset);
		String url_get = AlipayConfig.createUrl_Get(params);
		model.setUrl(url_get);
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
			data.setComId(tsOrder.getTsCommodity().getId());
			// 获得竞拍表记录
			// 查询该商品成交用户
			search = new ArrayList<SearchBean>();
			search.add(new SearchBean("tsCommodity.id", "eq", "string", tsOrder
					.getTsCommodity().getId()));
			List bing_list = generalDao.search(TsBingcur.class, search, null,
					null);
			if (bing_list != null && bing_list.size() > 0) {
				TsBingcur tsBingcur = (TsBingcur) bing_list.get(0);
				data.setBidId(tsBingcur.getId());
			}
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
		// 判断用户是否获得该产品竞拍,如果获得商品竞拍按商品购买价生成订单
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("tsUser.id", "eq", "string", userId));
		search.add(new SearchBean("tsCommodity.id", "eq", "string", tsCommodity
				.getId()));
		List bingcurList = generalDao.search(TsBingcur.class, search, null,
				null);
		if (bingcurList != null && bingcurList.size() > 0) {
			BigDecimal total = tsCommodity.getPurchasePrice();
			saveOrder(tsUser, tsCommodity, 0, total);
			result = "success";
			return result;
		}

		// 判断用户是否参与该商品竞拍,如果没有不允许购买
		List bidingList = generalDao
				.search(TsBidding.class, search, null, null);
		if (bidingList != null && bidingList.size() > 0) {
			// 判断用户是否购买过该商品，如果购买过按购买价
			List orderList = generalDao.search(TsOrder.class, search, null,
					null);
			if (orderList != null && orderList.size() > 0) {
				BigDecimal total = tsCommodity.getPurchasePrice();
				saveOrder(tsUser, tsCommodity, 0, total);
			} else {
				// 该用户参加竞拍次数
				int count = bidingList.size();
				// 保存订单
				BigDecimal total = tsCommodity.getPurchasePrice().subtract(
						new BigDecimal(count * 1));
				saveOrder(tsUser, tsCommodity, count, total);
			}
			result = "success";
		} else {
			BigDecimal total = tsCommodity.getPurchasePrice();
			saveOrder(tsUser, tsCommodity, 0, total);
			result = "success";
			return result;
		}
		return result;
	}
	
	/**
	 * 生成用户购买订单
	 */
	@SuppressWarnings("unchecked")
	public String createOrders(String id, String userId) throws GeneralException {
		String result = "success";
		// 商品信息
		TsCommodity tsCommodity = (TsCommodity) generalDao.get(TsCommodity.class, id);
		// 用户信息
		TsUser tsUser = (TsUser) generalDao.get(TsUser.class, userId);
		// 判断用户是否参与该商品竞拍,如果没有不允许购买
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("tsUser.id", "eq", "string", userId));
		search.add(new SearchBean("tsCommodity.id", "eq", "string", tsCommodity
				.getId()));
		// 判断用户是否参与该商品竞拍,如果没有不允许购买
		List bidingList = generalDao
				.search(TsBidding.class, search, null, null);
		if (bidingList != null && bidingList.size() > 0) {
			// 判断用户是否购买过该商品，如果购买过按购买价
			List orderList = generalDao.search(TsOrder.class, search, null,
					null);
			if (orderList != null && orderList.size() > 0) {
				BigDecimal total = tsCommodity.getPurchasePrice();
				saveOrder(tsUser, tsCommodity, 0, total);
			} else {
				// 该用户参加竞拍次数
				int count = bidingList.size();
				// 保存订单
				BigDecimal total = tsCommodity.getPurchasePrice().subtract(
						new BigDecimal(count * 1));
				saveOrder(tsUser, tsCommodity, count, total);
			}
			result = "success";
		} else {
			BigDecimal total = tsCommodity.getPurchasePrice();
			saveOrder(tsUser, tsCommodity, 0, total);
			result = "success";
			return result;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	private void saveOrder(TsUser tsUser, TsCommodity tsCommodity,
			Integer count, BigDecimal total) {
		TsOrder tsOrder = new TsOrder();
		// 生成订单号
		List<SearchBean> searchBeans = new ArrayList<SearchBean>();
		searchBeans
				.add(new SearchBean("tablename", "eq", "string", "TS_ORDER"));
		List list = generalDao.search(TsNum.class, searchBeans, null, null);
		if (list != null && list.size() > 0) {
			TsNum tsNum = (TsNum) list.get(0);
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
			String num = format.format(new Date());
			int len = String.valueOf(tsNum.getSequ()).length();
			for (int i = len - 1; i < 6; i++) {
				num += "0";
			}
			num = num + tsNum.getSequ();
			tsOrder.setOrdernum(num);
			tsNum.setSequ(tsNum.getSequ() + 1);
			generalDao.update(tsNum);
		}
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
		tsOrder.setAmount(total);
		tsOrder.setTotalPrices(total.add(tsOrder.getFare()));
		generalDao.save(tsOrder);
	}

	@SuppressWarnings("unchecked")
	public void searchChannel(OrderData model) throws GeneralException {
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
			data.setComId(tsOrder.getTsCommodity().getId());
			// 获得竞拍表记录
			// 查询该商品成交用户
			search = new ArrayList<SearchBean>();
			search.add(new SearchBean("tsCommodity.id", "eq", "string", tsOrder
					.getTsCommodity().getId()));
			List bing_list = generalDao.search(TsBingcur.class, search, null,
					null);
			if (bing_list != null && bing_list.size() > 0) {
				TsBingcur tsBingcur = (TsBingcur) bing_list.get(0);
				data.setBidId(tsBingcur.getId());
			}
			model.getDataList().add(data);
		}
	}
}
