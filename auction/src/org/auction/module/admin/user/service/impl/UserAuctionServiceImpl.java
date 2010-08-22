package org.auction.module.admin.user.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.auction.entity.TsBingcur;
import org.auction.entity.TsCommodity;
import org.auction.entity.TsOrder;
import org.auction.entity.TsUser;
import org.auction.module.admin.user.data.UserAuctionData;
import org.auction.module.admin.user.service.UserAuctionService;
import org.auction.module.admin.view.data.ViewData;
import org.mobile.common.bean.LoginBean;
import org.mobile.common.bean.OrderByBean;
import org.mobile.common.bean.PageBean;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.manager.GeneralManager;
import org.mobile.common.service.GeneralService;
import org.mobile.common.session.SessionManager;
import org.mobile.common.util.BeanProcessUtils;

public class UserAuctionServiceImpl extends GeneralService implements
		UserAuctionService {

	@SuppressWarnings("unchecked")
	public void auction(UserAuctionData model) throws GeneralException {
		// 获得登陆用户信息
		GeneralManager manager = GeneralManager.getCurrentManager();
		LoginBean bean = SessionManager.getLoginInfo(manager.getSessionId());
		if (bean != null) {
			TsUser tsUser = (TsUser) generalDao.get(TsUser.class, bean.getId());
			PageBean pageBean = model.getPageBean();
			List<SearchBean> searchBean = new ArrayList<SearchBean>();
			searchBean.add(new SearchBean("tsUser.id", "eq", "string", tsUser
					.getId()));
			List<OrderByBean> orderByBeans = new ArrayList<OrderByBean>();
			orderByBeans.add(new OrderByBean("", "binddate", "desc"));
			List list = generalDao.search(TsBingcur.class, searchBean,
					pageBean, orderByBeans);
			// 用户竞拍到商品记录
			for (int i = 0; i < list.size(); i++) {
				TsBingcur tsBingcur = (TsBingcur) list.get(i);
				// 商品信息
				TsCommodity tsCommodity = tsBingcur.getTsCommodity();
				// 获得该商品订单
				String state = null;
				String orderId = null;
				// 显示用户列表商品状态
				Iterator tsOrders = tsCommodity.getTsOrders().iterator();
				if (tsOrders.hasNext()) {
					TsOrder tsOrder = (TsOrder) tsOrders.next();
					orderId = tsOrder.getId();
					if (tsOrder.getState().equals("1")) {
						state = "未付款";
					} else if (tsOrder.getState().equals("2")) {
						state = "待发货";
					} else if (tsOrder.getState().equals("3")) {
						state = "已发货";
					} else if (tsOrder.getState().equals("4")) {
						state = "交易完成";
					} else {
						state = "作废";
					}
				}
				// 赋值
				UserAuctionData data = new UserAuctionData();
				BeanProcessUtils.copyProperties(data, tsBingcur);
				data.setUser(tsBingcur.getTsUser().getUsername());
				data.setComityName(tsCommodity.getTradename());
				data.setSummary(tsCommodity.getSummary());
				data.setPrices(tsCommodity.getPrices());
				data.setPrice(tsBingcur.getPrice());
				data.setState(state);
				if (data.getPrices().compareTo(new BigDecimal(0)) > 0) {
					BigDecimal total = (data.getPrices().subtract(data.getPrice()).subtract(new BigDecimal(tsBingcur.getAmount() * 1)));
					BigDecimal percents = total.divide(data.getPrices(),BigDecimal.ROUND_HALF_DOWN);
					data.setPercents(percents);
				}
				data.setOrderId(orderId);
				model.getDataList().add(data);
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
				ViewData vd = new ViewData();
				vd.setId(tsCommodity.getId());
				vd.setTradename(tsCommodity.getTradename());
				vd.setDescript(tsCommodity.getSummary());
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
			List orderList = generalDao.search(TsOrder.class, sb, model
					.getPageBean(), null);
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
				} else {
					state = "作废";
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
				model.getDataList().add(data);
			}

		}
	}
}
