package org.auction.module.admin.commodity.service.impl;

import java.util.Date;

import org.auction.entity.TsBidding;
import org.auction.entity.TsCommodity;
import org.auction.entity.TsConsume;
import org.auction.entity.TsUser;
import org.auction.module.admin.commodity.data.AuctionData;
import org.auction.module.admin.commodity.service.AuctionService;
import org.mobile.common.service.GeneralService;

public class AuctionServiceImpl extends GeneralService implements
		AuctionService {

	public void auction(AuctionData data) {
		TsUser tsUser = (TsUser) generalDao.get(TsUser.class, data.getUserId());
		TsCommodity tsCommodity = (TsCommodity) generalDao.get(
				TsCommodity.class, data.getComptyId());
		Long consume = tsCommodity.getConsume();
		if (tsCommodity.getRestricts().equals("2")) {
			Integer paycur = tsUser.getPaycur();
			if (paycur != null && paycur != 0) {
				// 剩余数量
				Long pay = paycur - consume;
				tsUser.setPaycur(pay.intValue());
				// 消费明细
				TsConsume tsConsume = new TsConsume();
				tsConsume.setTsUser(tsUser);
				tsConsume.setBuytime(new Date());
				tsConsume.setRemark("竞拍" + tsCommodity.getTradename());
				tsConsume.setAmount(consume.intValue());
				tsConsume.setBuytype("2");
				// 竞拍表
				TsBidding tsBidding = new TsBidding();
				tsBidding.setTsCommodity(tsCommodity);
				tsBidding.setTsUser(tsUser);
				tsBidding.setBiddate(new Date());
				tsBidding
						.setPrice(data.getPrice().add(tsCommodity.getMarkUp()));
				tsBidding.setIsbid("1");
				modify(tsCommodity.getId());
				generalDao.update(tsUser);
				generalDao.save(tsConsume);
				generalDao.save(tsBidding);
			}
		} else if (tsCommodity.getRestricts().equals("3")) {
			Integer freecur = tsUser.getFreecur();
			if (freecur != null && freecur != 0) {
				// 剩余数量
				Long pay = freecur - consume;
				tsUser.setFreecur(pay.intValue());
				// 消费明细
				TsConsume tsConsume = new TsConsume();
				tsConsume.setTsUser(tsUser);
				tsConsume.setBuytime(new Date());
				tsConsume.setRemark("竞拍" + tsCommodity.getTradename());
				tsConsume.setAmount(consume.intValue());
				tsConsume.setBuytype("3");
				// 竞拍表
				TsBidding tsBidding = new TsBidding();
				tsBidding.setTsCommodity(tsCommodity);
				tsBidding.setTsUser(tsUser);
				tsBidding.setBiddate(new Date());
				tsBidding
						.setPrice(data.getPrice().add(tsCommodity.getMarkUp()));
				tsBidding.setIsbid("1");
				modify(tsCommodity.getId());
				generalDao.update(tsUser);
				generalDao.save(tsConsume);
				generalDao.save(tsBidding);
			}
		} else {
			// 竞拍表
			TsBidding tsBidding = new TsBidding();
			tsBidding.setTsCommodity(tsCommodity);
			tsBidding.setTsUser(tsUser);
			tsBidding.setBiddate(new Date());
			tsBidding.setPrice(data.getPrice().add(tsCommodity.getMarkUp()));
			tsBidding.setIsbid("1");
			modify(tsCommodity.getId());
			generalDao.save(tsBidding);
		}
	}

	private void modify(String comptyId) {
		String hql = "update TsBidding t set t.isbid='2' where t.tsCommodity.id='"
				+ comptyId + "' and  t.isbid='1'";
		generalDao.executeHql(hql);
	}
}
