package org.auction.module.admin.commodity.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.auction.entity.TsBidding;
import org.auction.entity.TsBingcur;
import org.auction.module.admin.commodity.data.BidingData;
import org.auction.module.admin.commodity.data.BingcurData;
import org.auction.module.admin.commodity.service.BingcurService;
import org.mobile.common.bean.OrderByBean;
import org.mobile.common.bean.PageBean;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.service.GeneralService;
import org.mobile.common.util.BeanProcessUtils;
import org.mobile.common.util.Constant;

public class BingcurServiceImpl extends GeneralService implements BingcurService {

	public String delete(BingcurData model) throws GeneralException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 竞拍商品显示信息
	 */
	@SuppressWarnings("unchecked")
	public String forward(BingcurData model) throws GeneralException {
		// 查询竞拍商品
		TsBingcur tsBingcur = (TsBingcur) generalDao.get(TsBingcur.class, model.getId());
		BeanProcessUtils.copyProperties(model, tsBingcur);
		model.setUser(tsBingcur.getTsUser().getUsername());
		model.setComityName(tsBingcur.getTsCommodity().getTradename());
		model.setSummary(tsBingcur.getTsCommodity().getSummary());
		model.setPrices(tsBingcur.getTsCommodity().getPrices());
		model.setMarkprices(tsBingcur.getTsCommodity().getPurchasePrice());
		model.setTradeId(tsBingcur.getTsCommodity().getId());
		model.setFree(tsBingcur.getFree());
		if (model.getPrices().compareTo(new BigDecimal(0)) > 0) {
			BigDecimal total = (model.getPrices().subtract(model.getPrice()).subtract(new BigDecimal(tsBingcur.getAmount() * 1)));
			BigDecimal percents = total.divide(model.getPrices(), BigDecimal.ROUND_HALF_DOWN);
			model.setPercents(percents);
		}
		// 竞拍历史
		PageBean pageBean = new PageBean();
		List<OrderByBean> orderBean = new ArrayList<OrderByBean>();
		orderBean.add(new OrderByBean("", "biddate", "desc"));
		List<SearchBean> searchBeans = new ArrayList<SearchBean>();
		searchBeans.add(new SearchBean("tsCommodity.id", "eq", "string", tsBingcur.getTsCommodity().getId()));
		List list = generalDao.search(TsBidding.class, searchBeans, pageBean, orderBean);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				TsBidding tsBidding = (TsBidding) list.get(i);
				BidingData bidingData = new BidingData();
				BeanProcessUtils.copyProperties(bidingData, tsBidding);
				bidingData.setUsername(tsBidding.getTsUser().getUsername());
				model.getBidingList().add(bidingData);
			}
		}
		// 商品图片
		model.setImagesPath(generalDao.searchImages(tsBingcur.getTsCommodity().getId(), Constant.TRADE_IMAGES));
		// // 获得商品图片ID
		// List<SearchBean> searchBean = new ArrayList<SearchBean>();
		// searchBean.add(new SearchBean("imageid", "eq", "string",
		// tsBingcur.getTsCommodity().getId()));
		// searchBean.add(new SearchBean("tablename", "eq", "string",
		// "TS_COMMODITY"));
		// List imagelist = generalDao.search(TsImages.class, searchBean, null,
		// null);
		// String[] images = new String[4];
		// for (int i = 0; i < imagelist.size(); i++) {
		// if (i < 4) {
		// TsImages tsImages = (TsImages) imagelist.get(i);
		// images[i] = tsImages.getId();
		// }
		// }
		// model.setImage(images);
		return null;
	}

	public String save(BingcurData model) throws GeneralException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 竞拍历史列表
	 */
	@SuppressWarnings("unchecked")
	public String search(BingcurData model) throws GeneralException {
		PageBean pageBean = model.getPageBean();
		List<OrderByBean> orderByBeans = new ArrayList<OrderByBean>();
		orderByBeans.add(new OrderByBean("", "binddate", "desc"));
		List list = generalDao.search(TsBingcur.class, null, pageBean, orderByBeans);
		for (int i = 0; i < list.size(); i++) {
			TsBingcur tsBingcur = (TsBingcur) list.get(i);
			BingcurData data = new BingcurData();
			BeanProcessUtils.copyProperties(data, tsBingcur);
			data.setUser(tsBingcur.getTsUser().getUsername());
			data.setComityName(tsBingcur.getTsCommodity().getTradename());
			data.setTradeId(tsBingcur.getTsCommodity().getId());
			data.setSummary(tsBingcur.getTsCommodity().getSummary());
			data.setPrices(tsBingcur.getTsCommodity().getPrices());
			if (data.getPrices().compareTo(new BigDecimal(0)) > 0) {
				BigDecimal total = (data.getPrices().subtract(data.getPrice()).subtract(new BigDecimal(tsBingcur.getAmount() * 1)));
				BigDecimal percents = total.divide(data.getPrices(), BigDecimal.ROUND_HALF_DOWN);
				data.setPercents(percents);
			}
			
			//商品图片
			data.setImagesPath(generalDao.searchImages(tsBingcur.getTsCommodity().getId(), Constant.TRADE_IMAGES));
			model.getDataList().add(data);
		}
		return null;
	}

	/**
	 * 商品竞拍出价历史记录
	 */
	@SuppressWarnings("unchecked")
	public String searchBiding(BingcurData model) throws GeneralException {
		// TsBidding tsBingcur = (TsBidding) generalDao.get(TsBidding.class,
		// model.getId());
		List<SearchBean> searchBeans = new ArrayList<SearchBean>();
		searchBeans.add(new SearchBean("tsCommodity.id", "eq", "string", model.getId()));
		List<OrderByBean> orderBean = new ArrayList<OrderByBean>();
		orderBean.add(new OrderByBean("", "biddate", "desc"));
		List list = generalDao.search(TsBidding.class, searchBeans, model.getPageBean(), orderBean);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				TsBidding tsBidding = (TsBidding) list.get(i);
				BidingData bidingData = new BidingData();
				BeanProcessUtils.copyProperties(bidingData, tsBidding);
				bidingData.setUsername(tsBidding.getTsUser().getUsername());
				model.getBidingList().add(bidingData);
			}
		}
		return null;
	}

}
