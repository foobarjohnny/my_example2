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
		// List<SearchBean> search = new ArrayList<SearchBean>();
		// search.add(new SearchBean("state", "eq", "string", "1"));
		// List list = generalDao.search(TsCommodity.class, search, null, null);
		// for (int i = 0; i < list.size(); i++) {
		// TsCommodity tsCommodity = (TsCommodity) list.get(i);
		// ViewData data = new ViewData();
		// BeanProcessUtils.copyProperties(data, tsCommodity);
		// int endtime = tsCommodity.getEndtime();
		// Calendar calendar = Calendar.getInstance();
		// calendar.setTime(tsCommodity.getStarttime());
		// calendar.add(Calendar.HOUR, endtime);
		// data.setYear(calendar.get(Calendar.YEAR));
		// data.setMonth(calendar.get(Calendar.MONTH));
		// data.setDay(calendar.get(Calendar.DAY_OF_MONTH));
		// data.setHour(calendar.get(Calendar.HOUR_OF_DAY));
		// data.setMinute(calendar.get(Calendar.MINUTE));
		// data.setSecond(calendar.get(Calendar.SECOND));
		// // 计算剩余时间
		// tsCommodity.getStarttime().getTime();
		// model.getDataList().add(data);
		// }
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
