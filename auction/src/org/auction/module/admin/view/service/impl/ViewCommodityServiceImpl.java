package org.auction.module.admin.view.service.impl;

import java.util.Calendar;
import java.util.List;

import org.auction.module.admin.view.data.ViewData;
import org.auction.module.admin.view.service.ViewCommodityService;
import org.auction.module.manager.TradeManager;
import org.auction.module.manager.data.TradeData;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.service.GeneralService;

public class ViewCommodityServiceImpl extends GeneralService implements
		ViewCommodityService {

	public void show(ViewData model) throws GeneralException {
		List<TradeData> list = TradeManager.getTradeData();
		for (int i = 0; i < list.size(); i++) {
			TradeData td = list.get(i);
			ViewData vd = new ViewData();
			vd.setId(td.getId());
			vd.setTradename(td.getTradename());
			if (td.getPrice() != null && td.getPrice().compareTo(td.getMarketPrice()) > 0) {
				vd.setMarketPrice(td.getPrice());
			} else {
				vd.setMarketPrice(td.getMarketPrice());
			}
			// 计算时间
			Calendar endTime = Calendar.getInstance();
			endTime.setTime(td.getOvertime());
			Calendar today = Calendar.getInstance();
			long time = endTime.getTimeInMillis() - today.getTimeInMillis();
			vd.setRemaining(new Long(time));
			if (time > 0) {
				model.getDataList().add(vd);
			}
		}
	}

}
