package org.auction.module.admin.user.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.auction.entity.TsBidding;
import org.auction.entity.TsBingcur;
import org.auction.entity.TsCommodity;
import org.auction.entity.TsOrder;
import org.auction.entity.TsUser;
import org.auction.module.admin.commodity.data.BidingData;
import org.auction.module.admin.user.data.UserAuctionData;
import org.auction.module.admin.user.service.UserAuctionService;
import org.auction.module.admin.view.data.ViewData;
import org.auction.module.manager.TradeManager;
import org.auction.module.manager.data.TradeData;
import org.mobile.common.bean.LoginBean;
import org.mobile.common.bean.OrderByBean;
import org.mobile.common.bean.PageBean;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.manager.GeneralManager;
import org.mobile.common.service.GeneralService;
import org.mobile.common.session.SessionManager;
import org.mobile.common.util.BeanProcessUtils;
import org.mobile.common.util.Constant;

public class UserAuctionServiceImpl extends GeneralService implements UserAuctionService {

	/**
	 * 前台用户赢得的竞拍商品列表
	 */
	@SuppressWarnings("unchecked")
	public void auction(UserAuctionData model) throws GeneralException {
		// 获得登陆用户信息
		GeneralManager manager = GeneralManager.getCurrentManager();
		LoginBean bean = SessionManager.getLoginInfo(manager.getSessionId());
		if (bean != null) {
			TsUser tsUser = (TsUser) generalDao.get(TsUser.class, bean.getId());
			// 查询用户购买订单
			List<SearchBean> sb = new ArrayList<SearchBean>();
			sb.add(new SearchBean("tsUser.id", "eq", "string", tsUser.getId()));
			sb.add(new SearchBean("ordertype", "eq", "string", "1"));
			List orderList = generalDao.search(TsOrder.class, sb, model.getPageBean(), null);
			for (int i = 0; i < orderList.size(); i++) {
				TsOrder tsOrder = (TsOrder) orderList.get(i);
				String state = null;
				// 显示用户列表商品状态
				if (tsOrder.getState().equals("1")) {
					state = "未付款";
				} else if (tsOrder.getState().equals("2")) {
					state = "待发货";
				} else if (tsOrder.getState().equals("3")) {
					state = "已发货";
				} else if (tsOrder.getState().equals("4")) {
					state = "交易完成";
				} else if (tsOrder.getState().equals("5")) {
					state = "作废";
				} else {
					state = "删除";
				}
				// 商品信息
				TsCommodity tsCommodity = tsOrder.getTsCommodity();
				// 赋值
				UserAuctionData data = new UserAuctionData();
				data.setState(state);
				data.setUser(tsUser.getUsername());
				data.setComityName(tsCommodity.getTradename());
				data.setSummary(tsCommodity.getSummary());
				data.setPrice(tsOrder.getAmount());
				data.setBinddate(tsOrder.getOrdertime());
				data.setId(tsCommodity.getId());
				data.setOrderId(tsOrder.getId());
				data.setPurprices(tsCommodity.getPurchasePrice());
				data.setPercents((tsCommodity.getPurchasePrice().subtract(tsOrder.getAmount())).divide(tsCommodity.getPurchasePrice(), BigDecimal.ROUND_HALF_DOWN));
				// 商品显示图片
				data.setImagesPath(generalDao.searchImages(tsCommodity.getId(), Constant.TRADE_IMAGES));
				List<SearchBean> search = new ArrayList<SearchBean>();
				search.add(new SearchBean("tsCommodity.id", "eq", "string", tsCommodity.getId()));
				List bing_list = generalDao.search(TsBingcur.class, search, null, null);
				if (bing_list != null && bing_list.size() > 0) {
					TsBingcur tsBingcur = (TsBingcur) bing_list.get(0);
					data.setBidId(tsBingcur.getId());
				}
				if (!state.equals("作废") && !state.equals("删除")) {
					model.getDataList().add(data);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void now(UserAuctionData model) throws GeneralException {
		GeneralManager manager = GeneralManager.getCurrentManager();
		LoginBean bean = SessionManager.getLoginInfo(manager.getSessionId());
		if (bean != null) {
			TsUser tsUser = (TsUser) generalDao.get(TsUser.class, bean.getId());
			Iterator iterator = generalDao.now(tsUser.getId()).iterator();
			while (iterator.hasNext()) {
				// 商品信息
				TsCommodity tsCommodity = (TsCommodity) iterator.next();
				TradeData td = TradeManager.get(tsCommodity.getId());
				ViewData vd = new ViewData();
				vd.setId(tsCommodity.getId());
				vd.setTradename(tsCommodity.getTradename());
				vd.setDescript(tsCommodity.getSummary());
				// 竞拍价格
				if (td.getPrice() != null && td.getPrice().compareTo(td.getMarketPrice()) > 0) {
					vd.setMarketPrice(td.getPrice());
				} else {
					vd.setMarketPrice(td.getMarketPrice());
				}

				// 获得图片
				vd.setImagesPath(generalDao.searchImages(tsCommodity.getId(), Constant.TRADE_IMAGES));

				// 计算时间
				Calendar endTime = Calendar.getInstance();
				endTime.setTime(tsCommodity.getOvertime());
				Calendar today = Calendar.getInstance();
				long time = endTime.getTimeInMillis() - today.getTimeInMillis();
				vd.setRemaining(new Long(time));
				if (time > 0) {
					model.getTradeData().add(vd);
				}
			}
		}
	}

	/**
	 * 用户购买的商品
	 */
	@SuppressWarnings("unchecked")
	public void follow(UserAuctionData model) throws GeneralException {
		// 获得登陆人员信息
		GeneralManager manager = GeneralManager.getCurrentManager();
		LoginBean bean = SessionManager.getLoginInfo(manager.getSessionId());
		if (bean != null) {
			TsUser tsUser = (TsUser) generalDao.get(TsUser.class, bean.getId());
			// 查询用户购买订单
			List<SearchBean> sb = new ArrayList<SearchBean>();
			sb.add(new SearchBean("tsUser.id", "eq", "string", tsUser.getId()));
			sb.add(new SearchBean("ordertype", "eq", "string", "2"));
			List orderList = generalDao.search(TsOrder.class, sb, model.getPageBean(), null);
			for (int i = 0; i < orderList.size(); i++) {
				TsOrder tsOrder = (TsOrder) orderList.get(i);
				String state = null;
				// 显示用户列表商品状态
				if (tsOrder.getState().equals("1")) {
					state = "未付款";
				} else if (tsOrder.getState().equals("2")) {
					state = "待发货";
				} else if (tsOrder.getState().equals("3")) {
					state = "已发货";
				} else if (tsOrder.getState().equals("4")) {
					state = "交易完成";
				} else if (tsOrder.getState().equals("5")) {
					state = "作废";
				} else {
					state = "删除";
				}
				// 商品信息
				TsCommodity tsCommodity = tsOrder.getTsCommodity();
				// 赋值
				UserAuctionData data = new UserAuctionData();
				data.setState(state);
				data.setTradeState(tsCommodity.getState());
				data.setUser(tsUser.getUsername());
				data.setComityName(tsCommodity.getTradename());
				data.setSummary(tsCommodity.getSummary());
				data.setPrice(tsOrder.getAmount());
				data.setBinddate(tsOrder.getOrdertime());
				data.setId(tsCommodity.getId());
				data.setOrderId(tsOrder.getId());
//				// 商品显示图片
				data.setImagesPath(generalDao.searchImages(tsCommodity.getId(), Constant.TRADE_IMAGES));
//				List<SearchBean> search = new ArrayList<SearchBean>();
//				search.add(new SearchBean("tsCommodity.id", "eq", "string", tsCommodity.getId()));
//				List bing_list = generalDao.search(TsBingcur.class, search, null, null);
//				if (bing_list != null && bing_list.size() > 0) {
//					TsBingcur tsBingcur = (TsBingcur) bing_list.get(0);
//					data.setBidId(tsBingcur.getId());
//				}
				if (!state.equals("作废") && !state.equals("删除")) {
					model.getDataList().add(data);
				}
			}

		}
	}

	/**
	 * 正在竞拍商品单独显示
	 */
	@SuppressWarnings("unchecked")
	public void viewAuctionNow(UserAuctionData model) throws GeneralException {
		// 查找商品
		TsCommodity tsCommodity = (TsCommodity) generalDao.get(TsCommodity.class, model.getId());
		model.setTradename(tsCommodity.getTradename());
		model.setSummary(tsCommodity.getSummary());
		model.setPrices(tsCommodity.getPrices());
		model.setMarkup(tsCommodity.getMarkUp());
		model.setAddtime(tsCommodity.getAddtimes());
		model.setBuyprices(tsCommodity.getPurchasePrice());
		model.setId(tsCommodity.getId());
		String s = tsCommodity.getRestricts();
		if (s.equals("1")) {
			//model.setType("无限制");
		} else if (s.equals("2")) {
			model.setType("收费E拍币");
		} else {
			model.setType("免费E拍币");
		}
		// 当前竞拍商品最高出价人
		List<SearchBean> list = new ArrayList<SearchBean>();
		list.add(new SearchBean("isbid", "eq", "string", "1"));
		List bidList = generalDao.search(TsBidding.class, list, null, null);
		if (bidList != null && bidList.size() > 0) {
			TsBidding tsBidding = (TsBidding) bidList.get(0);
			model.setUser(tsBidding.getTsUser().getUsername());
			model.setMarkprices(tsBidding.getPrice());
		}

		// 获得商品图片ID
		model.setImagesPath(generalDao.searchImages(tsCommodity.getId(), Constant.TRADE_IMAGES));

		// 竞拍历史
		PageBean pageBean = new PageBean();
		List<OrderByBean> orderBean = new ArrayList<OrderByBean>();
		orderBean.add(new OrderByBean("", "biddate", "desc"));
		List<SearchBean> searchBeans = new ArrayList<SearchBean>();
		searchBeans.add(new SearchBean("tsCommodity.id", "eq", "string", model.getId()));
		List lists = generalDao.search(TsBidding.class, searchBeans, pageBean, orderBean);
		if (lists != null && lists.size() > 0) {
			for (int i = 0; i < lists.size(); i++) {
				TsBidding tsBidding = (TsBidding) lists.get(i);
				BidingData bidingData = new BidingData();
				BeanProcessUtils.copyProperties(bidingData, tsBidding);
				bidingData.setUsername(tsBidding.getTsUser().getUsername());
				model.getBidingList().add(bidingData);
			}
		}
		// 计算时间
		Calendar endTime = Calendar.getInstance();
		endTime.setTime(tsCommodity.getOvertime());
		Calendar today = Calendar.getInstance();
		long time = endTime.getTimeInMillis() - today.getTimeInMillis();
		if (time > 0) {
			model.setRemaining(new Long(time));
		}
	}

}
