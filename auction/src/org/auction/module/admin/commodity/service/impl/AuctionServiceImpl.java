package org.auction.module.admin.commodity.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.auction.entity.TsBidding;
import org.auction.entity.TsCommodity;
import org.auction.entity.TsConsume;
import org.auction.entity.TsUser;
import org.auction.module.admin.commodity.data.AuctionData;
import org.auction.module.admin.commodity.service.AuctionService;
import org.auction.module.manager.TradeManager;
import org.auction.module.manager.data.TradeData;
import org.mobile.common.service.GeneralService;

public class AuctionServiceImpl extends GeneralService implements
		AuctionService {

	public boolean auction(AuctionData data) {
		// 获得竞拍商品
		TradeData tradeData = TradeManager.get(data.getComptyId());
		if (tradeData == null) {
			return false;
		} else {
			// 获得用户信息
			TsUser tsUser = (TsUser) generalDao.get(TsUser.class, data
					.getUserId());
			// 商品信息
			TsCommodity tsCommodity = (TsCommodity) generalDao.get(
					TsCommodity.class, data.getComptyId());
			// 每次竞拍消耗E币数量
			Long consume = tsCommodity.getConsume();
			// 消费类型
			String type = "";
			// 竞拍方式2收费币,3免费币，1无限制
			if (tsCommodity.getRestricts().equals("2")) {
				// 收费
				Integer paycur = tsUser.getPaycur();
				if (paycur != null && paycur != 0 && paycur - consume > 0) {
					// 剩余数量
					Long pay = paycur - consume;
					tsUser.setPaycur(pay.intValue());
					// 消费明细
					TsConsume tsConsume = new TsConsume();
					tsConsume.setTsUser(tsUser);
					tsConsume.setBuytime(new Date());
					tsConsume.setRemark("竞拍" + tsCommodity.getTradename()
							+ "消费付费E拍币" + consume.intValue() + "枚");
					tsConsume.setAmount(consume.intValue());
					tsConsume.setBuytype("2");
					tsConsume.setTsCommodity(tsCommodity);
					type = "2";
					generalDao.update(tsUser);
					generalDao.save(tsConsume);
				} else {
					return false;
				}
			} else if (tsCommodity.getRestricts().equals("3")) {
				Integer freecur = tsUser.getFreecur();
				if (freecur != null && freecur != 0 && freecur - consume > 0) {
					// 剩余数量
					Long pay = freecur - consume;
					tsUser.setFreecur(pay.intValue());
					// 消费明细
					TsConsume tsConsume = new TsConsume();
					tsConsume.setTsUser(tsUser);
					tsConsume.setBuytime(new Date());
					tsConsume.setRemark("竞拍" + tsCommodity.getTradename()
							+ "消费免费E拍币" + consume.intValue() + "枚");
					tsConsume.setAmount(consume.intValue());
					tsConsume.setBuytype("3");
					type = "3";
					tsConsume.setTsCommodity(tsCommodity);
					generalDao.update(tsUser);
					generalDao.save(tsConsume);
				} else {
					return false;
				}
			} else {
				// 无限制,使用免费E拍币，在使用付费E拍币
				Integer freecur = tsUser.getFreecur();
				Integer paycur = tsUser.getPaycur();
				if (freecur - consume > 0) {
					// 使用免费E拍币
					// 剩余数量
					Long pay = freecur - consume;
					tsUser.setFreecur(pay.intValue());
					// 消费明细
					TsConsume tsConsume = new TsConsume();
					tsConsume.setTsUser(tsUser);
					tsConsume.setBuytime(new Date());
					tsConsume.setRemark("竞拍" + tsCommodity.getTradename()
							+ "消费免费E拍币" + consume.intValue() + "枚");
					tsConsume.setAmount(consume.intValue());
					tsConsume.setBuytype("3");
					type = "3";
					tsConsume.setTsCommodity(tsCommodity);
					generalDao.update(tsUser);
					generalDao.save(tsConsume);
				} else if (paycur - consume > 0) {
					// 使用付费E拍币
					Long pay = paycur - consume;
					tsUser.setPaycur(pay.intValue());
					// 消费明细
					TsConsume tsConsume = new TsConsume();
					tsConsume.setTsUser(tsUser);
					tsConsume.setBuytime(new Date());
					tsConsume.setRemark("竞拍" + tsCommodity.getTradename()
							+ "消费付费E拍币" + consume.intValue() + "枚");
					tsConsume.setAmount(consume.intValue());
					tsConsume.setBuytype("2");
					tsConsume.setTsCommodity(tsCommodity);
					type = "2";
					generalDao.update(tsUser);
					generalDao.save(tsConsume);
				} else {
					return false;
				}
			}
			// 竞拍表
			TsBidding tsBidding = new TsBidding();
			tsBidding.setTsCommodity(tsCommodity);
			tsBidding.setTsUser(tsUser);
			tsBidding.setBiddate(new Date());
			tsBidding.setBidtype(type);
			tsBidding.setPrice(tradeData.getPrice().add(tsCommodity.getMarkUp()));
			tsBidding.setIsbid("1");
			modify(tsCommodity.getId());
			generalDao.save(tsBidding);
			// 设置当前出价最高用户
			tradeData.setUid(tsUser.getId());
			tradeData.setUsername(tsUser.getUsername());
			// 设置竞拍信息
			tradeData.setBid(tsBidding.getId());
			tradeData.setIsbid(tsBidding.getIsbid());
			tradeData.setBiddate(tsBidding.getBiddate());
			tradeData.setPrice(tsBidding.getPrice());
			tradeData.setMarketPrice(tsBidding.getPrice());
			// 获得竞拍商品时间是否小于最低限制
			Calendar cal = Calendar.getInstance();
			cal.setTime(tradeData.getOvertime());
			Calendar today = Calendar.getInstance();
			long over = cal.getTimeInMillis();
			long curren = today.getTimeInMillis();
			long time = (over - curren) / 1000;
			//如果时间小于商品的增加时间，正价商品的时间
			if (time < tradeData.getAddtimes()) {
				long add = tradeData.getAddtimes() - time;
				cal.add(Calendar.SECOND, (int) add);
				tradeData.setOvertime(cal.getTime());
				tsCommodity.setOvertime(cal.getTime());
				generalDao.update(tsCommodity);
				data.setAdd(true);
				data.setTime(tsCommodity.getAddtimes());
			}
			return true;
		}
	}

	private void modify(String comptyId) {
		String hql = "update TsBidding t set t.isbid='2' where t.tsCommodity.id='"
				+ comptyId + "' and  t.isbid='1'";
		generalDao.executeHql(hql);
	}
}
