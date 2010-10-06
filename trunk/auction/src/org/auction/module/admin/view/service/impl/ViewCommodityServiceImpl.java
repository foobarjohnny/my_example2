package org.auction.module.admin.view.service.impl;

import java.util.Calendar;
import java.util.List;

import org.auction.module.admin.view.data.ViewData;
import org.auction.module.admin.view.service.ViewCommodityService;
import org.auction.module.manager.TradeManager;
import org.auction.module.manager.data.TradeData;
import org.mobile.common.bean.PageBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.service.GeneralService;

import org.mobile.common.util.Constant;

public class ViewCommodityServiceImpl extends GeneralService implements ViewCommodityService {

	/**
	 * 首页面获得可以竞拍的商品
	 */
	public void show(ViewData model) throws GeneralException {
		// 首页显示竞拍商品显示十条记录
		List<TradeData> list = TradeManager.getTradeData(null);
		int size = list.size() >= Constant.SIZE_PER_PAGE ? Constant.SIZE_PER_PAGE : list.size();
		for (int i = 0; i < size; i++) {
			TradeData td = list.get(i);
			ViewData vd = new ViewData();
			vd.setId(td.getId());
			vd.setTradename(td.getTradename());
			if (td.getPrice() != null && td.getPrice().compareTo(td.getMarketPrice()) > 0) {
				vd.setMarketPrice(td.getPrice());
			} else {
				vd.setMarketPrice(td.getMarketPrice());
			}

			// 商品图片资源
			vd.setImagesPath(generalDao.searchImages(td.getId(), Constant.TRADE_IMAGES));

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

	public void showAll(ViewData model) throws GeneralException {
		// 获得所有参与竞拍的商品
		List<TradeData> list = TradeManager.getTradeData(null);
		// 竞拍商品数量
		int size = list.size();
		// 分页信息处理
		PageBean pageBean = model.getPageBean();
		int pageRec = pageBean.getPageRec();
		if (size % pageRec == 0) {
			pageBean.setTotalPage(size / pageRec);
		} else {
			pageBean.setTotalPage(size / pageRec + 1);
		}
		// 当前页号
		int current = pageBean.getCurrentPage();
		// 获得检索起始位置
		int start = (current - 1) * pageRec;
		// 计数器
		int count = 1;
		for (int i = start; i < size; i++) {
			TradeData td = list.get(i);
			ViewData vd = new ViewData();
			vd.setId(td.getId());
			vd.setTradename(td.getTradename());
			// 查看商品是否有竞拍有使用竞拍价格
			if (td.getPrice() != null && td.getPrice().compareTo(td.getMarketPrice()) > 0) {
				vd.setMarketPrice(td.getPrice());
			} else {
				vd.setMarketPrice(td.getMarketPrice());
			}
			
			// 商品图片资源
			vd.setImagesPath(generalDao.searchImages(td.getId(), Constant.TRADE_IMAGES));
			
			// 计算时间
			Calendar endTime = Calendar.getInstance();
			endTime.setTime(td.getOvertime());
			Calendar today = Calendar.getInstance();
			long time = endTime.getTimeInMillis() - today.getTimeInMillis();
			vd.setRemaining(new Long(time));
			if (time > 0) {
				count++;
				model.getDataList().add(vd);
				if (count == 15) {
					break;
				}
			}
		}
	}

}
