package org.auction.module.manager.job.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.auction.entity.TsBidding;
import org.auction.entity.TsBingcur;
import org.auction.entity.TsCommodity;
import org.auction.entity.TsNum;
import org.auction.entity.TsOrder;
import org.auction.entity.TsUser;
import org.auction.module.manager.TradeManager;
import org.auction.module.manager.data.TradeData;
import org.auction.module.manager.job.service.IJobService;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.service.GeneralService;
import org.mobile.common.util.BeanProcessUtils;

public class JobServiceImpl extends GeneralService implements IJobService {

	@SuppressWarnings("unchecked")
	public List<TradeData> getNewComtity(String[] ids) throws GeneralException {
		List<TradeData> dataList = new ArrayList<TradeData>();
		List list = this.generalDao.auction(ids);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				TsCommodity tsCommodity = (TsCommodity) list.get(i);
				if (tsCommodity.getState().equals("4")) {
					tsCommodity.setState("1");
					generalDao.update(tsCommodity);
					TradeData data = new TradeData();
					BeanProcessUtils.copyProperties(data, tsCommodity);
					dataList.add(data);
				} else if (tsCommodity.getState().equals("1")) {
					TradeData data = new TradeData();
					BeanProcessUtils.copyProperties(data, tsCommodity);
					TsBidding tsBidding = (TsBidding) generalDao
							.getBinding(tsCommodity.getId());
					if (tsBidding != null) {
						BeanProcessUtils.copyProperties(data, tsBidding);
						data.setBid(tsBidding.getId());
						BeanProcessUtils.copyProperties(data, tsBidding
								.getTsUser());
						data.setUid(tsBidding.getTsUser().getId());
						data.setId(tsCommodity.getId());
						data.setMarketPrice(tsBidding.getPrice());
					}
					dataList.add(data);
				}

			}
		}
		return dataList;
	}

	public void finish() throws GeneralException {
		List<TradeData> list = TradeManager.getTradeData();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				TradeData tradeData = list.get(i);
				// 计算时间
				Calendar endTime = Calendar.getInstance();
				endTime.setTime(tradeData.getOvertime());
				Calendar today = Calendar.getInstance();
				long time = endTime.getTimeInMillis() - today.getTimeInMillis();
				// 商品竞拍结束处理
				if (time < 0) {
					createItem(tradeData);
				}
			}
		}
	}

	/**
	 * 生成订单，更改商品状态，加入竞拍获得表
	 * 
	 * @param tradeData
	 */
	@SuppressWarnings("unchecked")
	private void createItem(TradeData tradeData) {
		// 获得商品信息
		TsCommodity tsCommodity = (TsCommodity) generalDao.get(
				TsCommodity.class, tradeData.getId());

		// 商品状态，2流拍，3成交
		if (tradeData.getBid() != null && !tradeData.getBid().equals("")) {
			tsCommodity.setState("3");
			// 用户信息
			TsUser tsUser = (TsUser) generalDao.get(TsUser.class, tradeData
					.getUid());
			// 更新竞拍表
			TsBidding tsBidding = (TsBidding) generalDao.get(TsBidding.class,
					tradeData.getBid());
			tsBidding.setIsbid("3");
			generalDao.update(tsBidding);
			// 保存中标信息
			TsBingcur tsBingcur = new TsBingcur();
			tsBingcur.setTsCommodity(tsCommodity);
			tsBingcur.setTsUser(tsUser);
			tsBingcur.setBinddate(tsBidding.getBiddate());
			tsBingcur.setPrice(tsBidding.getPrice());
			if (tsCommodity.getRestricts().equals("2")
					|| tsCommodity.getRestricts().equals("3")) {
				// 总共花费E币
				int e = generalDao.countE(tsCommodity.getId(), tsUser.getId());
				tsBingcur.setAmount(e * tsCommodity.getConsume().intValue());
			}
			generalDao.save(tsBingcur);
			// 生成订单
			TsOrder tsOrder = new TsOrder();
			tsOrder.setTsCommodity(tsCommodity);
			tsOrder.setTsUser(tsUser);
			tsOrder.setOrdertype("1");
			// 生成订单号
			List<SearchBean> searchBeans = new ArrayList<SearchBean>();
			searchBeans.add(new SearchBean("tablename", "eq", "string",
					"TS_ORDER"));
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
			tsOrder.setAddress(tsUser.getAddress());
			tsOrder.setOrdertime(new Date());
			tsOrder.setReceiver(tsUser.getRealname());
			tsOrder.setTelphone(tsUser.getTelphone());
			tsOrder.setState("1");
			tsOrder.setFare(new BigDecimal(20));
			tsOrder.setAmount(tsBingcur.getPrice());
			tsOrder.setEcount(tsBingcur.getAmount());
			BigDecimal total = tsOrder.getFare().add(tsBingcur.getPrice()).add(
					new BigDecimal(tsBingcur.getAmount() * 1));
			tsOrder.setTotalPrices(total);
			generalDao.save(tsOrder);
		} else {
			tsCommodity.setState("2");
		}
		// 更新商品状态
		generalDao.update(tsCommodity);
		// 删除TradeManager无用的信息
		TradeManager.remove(tsCommodity.getId());
	}

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "1");
		map.remove("1");
		System.out.println(map.keySet().iterator().next());
	}
}
