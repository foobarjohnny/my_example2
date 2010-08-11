package org.auction.module.admin.view.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.auction.entity.TsCommodity;
import org.auction.module.admin.view.data.ViewData;
import org.auction.module.admin.view.service.ViewCommodityService;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.service.GeneralService;
import org.mobile.common.util.BeanProcessUtils;

public class ViewCommodityServiceImpl extends GeneralService implements
		ViewCommodityService {

	@SuppressWarnings("unchecked")
	public void show(ViewData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("state", "eq", "string", "1"));
		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// Calendar cal = Calendar.getInstance();
		// search.add(new SearchBean("starttime", "gt", "date",
		// format.format(cal
		// .getTime())));
		// cal.add(Calendar.DAY_OF_MONTH, 1);
		// search.add(new SearchBean("starttime", "lt", "date",
		// format.format(cal
		// .getTime())));
		List list = generalDao.search(TsCommodity.class, search, null, null);
		for (int i = 0; i < list.size(); i++) {
			TsCommodity tsCommodity = (TsCommodity) list.get(i);
			ViewData data = new ViewData();
			BeanProcessUtils.copyProperties(data, tsCommodity);
			int endtime = tsCommodity.getEndtime();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(tsCommodity.getStarttime());
			calendar.add(Calendar.HOUR, endtime);
			data.setYear(calendar.get(Calendar.YEAR));
			data.setMonth(calendar.get(Calendar.MONTH));
			data.setDay(calendar.get(Calendar.DAY_OF_MONTH));
			data.setHour(calendar.get(Calendar.HOUR_OF_DAY));
			data.setMinute(calendar.get(Calendar.MINUTE));
			data.setSecond(calendar.get(Calendar.SECOND));
			// 计算剩余时间
			tsCommodity.getStarttime().getTime();
			model.getDataList().add(data);
		}
	}

}
