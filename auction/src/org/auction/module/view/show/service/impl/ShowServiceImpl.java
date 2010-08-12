package org.auction.module.view.show.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.auction.entity.TsBingcur;
import org.auction.entity.TsCommodity;
import org.auction.entity.TsInfo;
import org.auction.entity.TsSort;
import org.auction.module.admin.base.data.InfoData;
import org.auction.module.admin.commodity.data.BingcurData;
import org.auction.module.admin.commodity.data.SortData;
import org.auction.module.admin.view.data.ViewData;
import org.auction.module.view.show.data.ShowData;
import org.auction.module.view.show.service.IShowService;
import org.mobile.common.bean.PageBean;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.dao.IGeneralDao;
import org.mobile.common.util.BeanProcessUtils;

public class ShowServiceImpl implements IShowService {

	private IGeneralDao generalDao;

	@SuppressWarnings("unchecked")
	public void show(ShowData model) throws Exception {
		// 商品分类
		List<SearchBean> search = new ArrayList<SearchBean>();
		List list = generalDao.search(TsSort.class, search, null, null);
		for (int i = 0; i < list.size(); i++) {
			TsSort tsSort = (TsSort) list.get(i);
			SortData data = new SortData();
			BeanProcessUtils.copyProperties(data, tsSort);
			model.getSortDataList().add(data);
		}
		// 竞拍历史
		PageBean pageBean = new PageBean();
		list = generalDao.search(TsBingcur.class, search, pageBean, null);
		for (int i = 0; i < list.size(); i++) {
			TsBingcur tsSort = (TsBingcur) list.get(i);
			BingcurData data = new BingcurData();
			BeanProcessUtils.copyProperties(data, tsSort);
			data.setUser(tsSort.getTsUser().getRealname());
			data.setComityName(tsSort.getTsCommodity().getTradename());
			model.getBingcurDataList().add(data);
		}
		// 网站公告
		search = new ArrayList<SearchBean>();
		search.add(new SearchBean("nettype", "eq", "string", "5"));
		list = generalDao.search(TsInfo.class, search, pageBean, null);
		for (int i = 0; i < list.size(); i++) {
			TsInfo tsSort = (TsInfo) list.get(i);
			InfoData data = new InfoData();
			BeanProcessUtils.copyProperties(data, tsSort);
			model.getPostDataList().add(data);
		}
		// 帮助中心
		search = new ArrayList<SearchBean>();
		search.add(new SearchBean("nettype", "eq", "string", "3"));
		list = generalDao.search(TsInfo.class, search, pageBean, null);
		for (int i = 0; i < list.size(); i++) {
			TsInfo tsSort = (TsInfo) list.get(i);
			InfoData data = new InfoData();
			BeanProcessUtils.copyProperties(data, tsSort);
			model.getHelpDataList().add(data);
		}
		// 正在竞拍商品
		search = new ArrayList<SearchBean>();
		search.add(new SearchBean("state", "eq", "string", "1"));
		list = generalDao.search(TsCommodity.class, search, pageBean, null);
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
			model.getViewDataList().add(data);
		}
	}

	public void setGeneralDao(IGeneralDao generalDao) {
		this.generalDao = generalDao;
	}
}
