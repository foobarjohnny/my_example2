package org.auction.module.manager.job.service.impl;

import java.math.BigDecimal; 
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

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
import org.mobile.common.util.Constant;
/**
 * 装载正在竞拍商品的信息
 * @author 
 *
 */
public class JobServiceImpl extends GeneralService implements IJobService {

	private static Logger logger = Logger.getLogger(JobServiceImpl.class);
	
	/**
	 * 根据当前Application上下文中的商品编号， 来获取竞拍商品的相关信息，获取到新的需要竞拍的商品的信息
	 */
	@SuppressWarnings("unchecked")
	public List<TradeData> getNewComtity(String[] ids) throws GeneralException {
		
		List<TradeData> dataList = new ArrayList<TradeData>();
		List list = this.generalDao.auction(ids);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				TsCommodity tsCommodity = (TsCommodity) list.get(i);
				TradeData data = new TradeData();
				
				//如果状态是4的话，那么需要修改成为1，再次竞拍
				if (tsCommodity.getState().equals(Constant.COMMODITY_STATE.UNKNOWN_STATE)) {
					tsCommodity.setState("1");
					generalDao.update(tsCommodity);
					BeanProcessUtils.copyProperties(data, tsCommodity);
				//查询正在竞拍的商品	
				} else if (tsCommodity.getState().equals(Constant.COMMODITY_STATE.AUCTION_STATE)) {
					BeanProcessUtils.copyProperties(data, tsCommodity);
					TsBidding tsBidding = (TsBidding) generalDao.getBinding(tsCommodity.getId());
					if (tsBidding != null) {
						BeanProcessUtils.copyProperties(data, tsBidding);
						data.setBid(tsBidding.getId());
						BeanProcessUtils.copyProperties(data, tsBidding.getTsUser());
						data.setUid(tsBidding.getTsUser().getId());
						data.setId(tsCommodity.getId());
						data.setMarketPrice(tsBidding.getPrice());
					}
				}
				dataList.add(data);
			}
		}
		return dataList;
	}

	/**
	 * 移除竞拍结束的商品
	 */
	public void remove() throws GeneralException {
		List<TradeData> list = TradeManager.getTradeData(null);
		if (list != null && list.size() > 0) { 
			for (int i = 0; i < list.size(); i++) {
				TradeData tradeData = list.get(i);
				if (tradeData.isFinshed()) {
					TradeManager.remove(tradeData.getId());
				}
			}
		}
	}

	/**
	 * 对于竞拍完成的商品进行处理， 
	 */
	public void finish() throws GeneralException {
		List<TradeData> list = TradeManager.getTradeData(null);
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
					//商品是否已生产订单
					if (!tradeData.isOrder()) {
						createItem(tradeData);
					}
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
			// 总共花费E币
			int e = generalDao.countE(tsCommodity.getId(), tsUser.getId());
			tsBingcur.setAmount(e * tsCommodity.getConsume().intValue());
			int f = generalDao.countF(tsCommodity.getId(), tsUser.getId());
			tsBingcur.setAmount(f * tsCommodity.getConsume().intValue());
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
		TradeManager.finshed(tsCommodity.getId());
	}

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "1");
		map.remove("1");
		System.out.println(map.keySet().iterator().next());
	}
}
