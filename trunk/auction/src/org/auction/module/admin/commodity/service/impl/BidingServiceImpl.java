package org.auction.module.admin.commodity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.auction.module.admin.commodity.data.BidingData;
import org.auction.module.admin.commodity.service.BidingService;
import org.auction.module.manager.TradeManager;
import org.auction.module.manager.data.TradeData;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.service.GeneralService;

public class BidingServiceImpl extends GeneralService implements BidingService {

	@SuppressWarnings("unchecked")
	public List findNewPeople(BidingData model) throws GeneralException {
		List<BidingData> newList = new ArrayList<BidingData>();
		// 获得竞拍商品
		TradeData tradeData = TradeManager.get(model.getCommpityId());
		if (tradeData != null) {
			String uid = tradeData.getUid();
			if (uid != null && !uid.equals("") && !uid.equals(model.getUserId())) {
				BidingData data = new BidingData();
				data.setUserId(uid);
				data.setUsername(tradeData.getUsername());
				data.setPrice(tradeData.getMarketPrice());
				data.setTime(tradeData.getAddtimes());
				newList.add(data);
			}
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
