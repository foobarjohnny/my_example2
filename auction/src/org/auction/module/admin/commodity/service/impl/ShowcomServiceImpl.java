package org.auction.module.admin.commodity.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.auction.entity.TsBidding;
import org.auction.entity.TsBingcur;
import org.auction.entity.TsCommodity;
import org.auction.entity.TsShowcom;
import org.auction.entity.TsUser;
import org.auction.module.admin.commodity.data.BidingData;
import org.auction.module.admin.commodity.data.ShowcomData;
import org.auction.module.admin.commodity.service.ShowcomService;
import org.mobile.common.bean.LoginBean;
import org.mobile.common.bean.OrderByBean;
import org.mobile.common.bean.PageBean;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.manager.GeneralManager;
import org.mobile.common.service.GeneralService;
import org.mobile.common.session.SessionManager;
import org.mobile.common.util.BeanProcessUtils;
import org.mobile.common.util.Constant;

public class ShowcomServiceImpl extends GeneralService implements ShowcomService {

	/**
	 * 用户秀宝
	 */
	public void forward(ShowcomData model) throws Exception {
		GeneralManager gm = GeneralManager.getCurrentManager();
		LoginBean lb = SessionManager.getLoginInfo(gm.getSessionId());
		if (lb != null) {
			TsCommodity tsCommodity = (TsCommodity) generalDao.get(TsCommodity.class, model.getTradeId());
			model.setUserID(lb.getId());
			model.setUsername(lb.getWorkNo());
			model.setTradeId(tsCommodity.getId());
			model.setTradename(tsCommodity.getTradename());
		}
	}

	/**
	 * 秀宝审核
	 */
	public void aut(ShowcomData model) throws Exception {
		TsShowcom tsShowcom = (TsShowcom) generalDao.get(TsShowcom.class, model.getId());
		tsShowcom.setAut("1");
		tsShowcom.setAdde(model.getCount());
		generalDao.update(tsShowcom);
		TsUser tsUser = tsShowcom.getTsUser();
		if (model.getCount() != null) {
			tsUser.setFreecur(tsUser.getFreecur() + model.getCount());
		}
		generalDao.update(tsUser);
	}

	public void delete(ShowcomData model) throws Exception {
		generalDao.delete(TsShowcom.class, model.getId());
	}

	/**
	 * 后台秀宝审核列表
	 */
	@SuppressWarnings("unchecked")
	public void notAut(ShowcomData model) throws Exception {
		List<SearchBean> sbs = new ArrayList<SearchBean>();
		sbs.add(new SearchBean("aut", "eq", "string", "2"));
		List list = generalDao.search(TsShowcom.class, sbs, model.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsShowcom tsShowcom = (TsShowcom) list.get(i);
			ShowcomData data = new ShowcomData();
			BeanProcessUtils.copyProperties(data, tsShowcom);
			data.setTradeId(tsShowcom.getTsCommodity().getId());
			data.setTradename(tsShowcom.getTsCommodity().getTradename());
			data.setUsername(tsShowcom.getTsUser().getUsername());
			// 商品竞拍
			List<SearchBean> search = new ArrayList<SearchBean>();
			search.add(new SearchBean("tsCommodity.id", "eq", "string", tsShowcom.getTsCommodity().getId()));
			List bing_list = generalDao.search(TsBingcur.class, search, null, null);
			if (bing_list != null && bing_list.size() > 0) {
				TsBingcur tsBingcur = (TsBingcur) bing_list.get(0);
				data.setBidId(tsBingcur.getId());
			}
			// 商品状态
			data.setTradeState(tsShowcom.getTsCommodity().getState());
			// 商品图片
			data.setImagesPath(generalDao.searchImages(tsShowcom.getTsCommodity().getId(), Constant.TRADE_IMAGES));
			model.getDataList().add(data);
		}
	}

	public void save(ShowcomData model) throws Exception {
		TsShowcom tsShowcom = new TsShowcom();
		BeanProcessUtils.copyProperties(tsShowcom, model);
		tsShowcom.setAut("2");
		TsCommodity tsCommodity = (TsCommodity) generalDao.get(TsCommodity.class, model.getTradeId());
		tsShowcom.setTsCommodity(tsCommodity);
		TsUser tsUser = (TsUser) generalDao.get(TsUser.class, model.getUserID());
		tsShowcom.setTsUser(tsUser);
		tsShowcom.setCreattime(new Date());
		generalDao.save(tsShowcom);
	}

	@SuppressWarnings("unchecked")
	public void view(ShowcomData model) throws Exception {
		TsShowcom tsShowcom = (TsShowcom) generalDao.get(TsShowcom.class, model.getId());
		model.setId(tsShowcom.getId());
		model.setTradename(tsShowcom.getTsCommodity().getTradename());
		model.setTradeId(tsShowcom.getTsCommodity().getId());
		model.setRemark(tsShowcom.getRemark());
		model.setAut(tsShowcom.getAut());
		// 商品竞拍
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("tsCommodity.id", "eq", "string", tsShowcom.getTsCommodity().getId()));
		List bing_list = generalDao.search(TsBingcur.class, search, null, null);
		if (bing_list != null && bing_list.size() > 0) {
			TsBingcur tsBingcur = (TsBingcur) bing_list.get(0);
			model.setBidId(tsBingcur.getId());
			model.setUsername(tsBingcur.getTsUser().getUsername());
			model.setCreattime(tsBingcur.getBinddate());
			model.setPrice(tsBingcur.getPrice());
		}
	}

	/**
	 * 已审核秀宝列表
	 */
	@SuppressWarnings("unchecked")
	public void finshedAut(ShowcomData model) throws Exception {
		List<SearchBean> sbs = new ArrayList<SearchBean>();
		sbs.add(new SearchBean("aut", "eq", "string", "1"));
		List list = generalDao.search(TsShowcom.class, sbs, model.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsShowcom tsShowcom = (TsShowcom) list.get(i);
			ShowcomData data = new ShowcomData();
			BeanProcessUtils.copyProperties(data, tsShowcom);
			data.setTradeId(tsShowcom.getTsCommodity().getId());
			data.setTradename(tsShowcom.getTsCommodity().getTradename());
			data.setUsername(tsShowcom.getTsUser().getUsername());
			// 商品竞拍
			List<SearchBean> search = new ArrayList<SearchBean>();
			search.add(new SearchBean("tsCommodity.id", "eq", "string", tsShowcom.getTsCommodity().getId()));
			List bing_list = generalDao.search(TsBingcur.class, search, null, null);
			if (bing_list != null && bing_list.size() > 0) {
				TsBingcur tsBingcur = (TsBingcur) bing_list.get(0);
				data.setBidId(tsBingcur.getId());
			}
			// 商品状态
			data.setTradeState(tsShowcom.getTsCommodity().getState());
			// 商品图片
			data.setImagesPath(generalDao.searchImages(tsShowcom.getTsCommodity().getId(), Constant.TRADE_IMAGES));
			model.getDataList().add(data);
		}
	}

	/**
	 * 前台导航用户秀宝
	 */
	@SuppressWarnings("unchecked")
	public void viewList(ShowcomData model) throws Exception {
		List<SearchBean> sbs = new ArrayList<SearchBean>();
		sbs.add(new SearchBean("aut", "eq", "string", "1"));
		List list = generalDao.search(TsShowcom.class, sbs, model.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsShowcom tsShowcom = (TsShowcom) list.get(i);
			ShowcomData data = new ShowcomData();
			BeanProcessUtils.copyProperties(data, tsShowcom);
			data.setTradeId(tsShowcom.getTsCommodity().getId());
			data.setTradename(tsShowcom.getTsCommodity().getTradename());
			data.setUsername(tsShowcom.getTsUser().getUsername());
			data.setCreattime(tsShowcom.getCreattime());
			data.setMprice(tsShowcom.getTsCommodity().getPrices());
			// 商品竞拍
			List<SearchBean> search = new ArrayList<SearchBean>();
			search.add(new SearchBean("tsCommodity.id", "eq", "string", tsShowcom.getTsCommodity().getId()));
			List bing_list = generalDao.search(TsBingcur.class, search, null, null);
			if (bing_list != null && bing_list.size() > 0) {
				TsBingcur tsBingcur = (TsBingcur) bing_list.get(0);
				data.setBidId(tsBingcur.getId());
				// 节约
				if (tsBingcur.getTsUser().getId().equals(tsShowcom.getTsUser().getId())) {
					data.setPrice(tsBingcur.getPrice());
					BigDecimal bg = tsBingcur.getPrice().add(new BigDecimal(tsBingcur.getAmount() * 2));
					data.setJs(((data.getMprice().subtract(bg)).divide(data.getMprice(), BigDecimal.ROUND_HALF_DOWN)).multiply(new BigDecimal(100)));
				} else {
					data.setPrice(tsShowcom.getTsCommodity().getPurchasePrice());
					data.setJs(((data.getMprice().subtract(tsShowcom.getTsCommodity().getPurchasePrice())).divide(data.getMprice(), BigDecimal.ROUND_HALF_DOWN)).multiply(new BigDecimal(100)));
				}
			}
			//图片
			data.setImagesPath(generalDao.searchImages(tsShowcom.getTsCommodity().getId(), Constant.TRADE_IMAGES));
			model.getDataList().add(data);
		}
	}

	/**
	 * 前台用户我的秀宝
	 */
	@SuppressWarnings("unchecked")
	public void showList(ShowcomData model) throws Exception {
		GeneralManager gm = GeneralManager.getCurrentManager();
		LoginBean lb = SessionManager.getLoginInfo(gm.getSessionId());
		if (lb != null) {
			List<SearchBean> sbs = new ArrayList<SearchBean>();
			sbs.add(new SearchBean("tsUser.id", "eq", "string", lb.getId()));
			// 获得该用户秀宝商品
			List list = generalDao.search(TsShowcom.class, sbs, model.getPageBean(), null);
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					TsShowcom tsShowcom = (TsShowcom) list.get(i);
					ShowcomData data = new ShowcomData();
					BeanProcessUtils.copyProperties(data, tsShowcom);
					data.setTradeId(tsShowcom.getTsCommodity().getId());
					data.setTradename(tsShowcom.getTsCommodity().getTradename());
					data.setUsername(tsShowcom.getTsUser().getUsername());
					data.setCreattime(tsShowcom.getCreattime());
					data.setMprice(tsShowcom.getTsCommodity().getPrices());
					// 商品竞拍
					List<SearchBean> search = new ArrayList<SearchBean>();
					search.add(new SearchBean("tsCommodity.id", "eq", "string", tsShowcom.getTsCommodity().getId()));
					List bing_list = generalDao.search(TsBingcur.class, search, null, null);
					if (bing_list != null && bing_list.size() > 0) {
						TsBingcur tsBingcur = (TsBingcur) bing_list.get(0);
						data.setBidId(tsBingcur.getId());
						// 节约
						if (tsBingcur.getTsUser().getId().equals(tsShowcom.getTsUser().getId())) {
							data.setPrice(tsBingcur.getPrice());
							BigDecimal bg = tsBingcur.getPrice().add(new BigDecimal(tsBingcur.getAmount() * 2));
							data.setJs(((data.getMprice().subtract(bg)).divide(data.getMprice(), BigDecimal.ROUND_HALF_DOWN)).multiply(new BigDecimal(100)));
						} else {
							data.setPrice(tsShowcom.getTsCommodity().getPurchasePrice());
							data.setJs(((data.getMprice().subtract(tsShowcom.getTsCommodity().getPurchasePrice())).divide(data.getMprice(), BigDecimal.ROUND_HALF_DOWN)).multiply(new BigDecimal(100)));
						}
					}
					// 商品状态
					data.setTradeState(tsShowcom.getTsCommodity().getState());
					// 商品图片
					data.setImagesPath(generalDao.searchImages(tsShowcom.getTsCommodity().getId(), Constant.TRADE_IMAGES));
					model.getDataList().add(data);
				}
			}
		}
	}

	/**
	 * 用户秀宝详情
	 */
	@SuppressWarnings("unchecked")
	public void show(ShowcomData model) throws Exception {
		// 获得秀宝信息
		TsShowcom tsShowcom = (TsShowcom) generalDao.get(TsShowcom.class, model.getId());
		// 获得商品
		TsCommodity tsCommodity = (TsCommodity) generalDao.get(TsCommodity.class, tsShowcom.getTsCommodity().getId());
		model.setTradename(tsCommodity.getTradename());
		model.setTradeId(tsCommodity.getId());
		model.setUsername(tsShowcom.getTsUser().getUsername());
		model.setRemark(tsShowcom.getRemark());
		model.setSummary(tsCommodity.getSummary());
		model.setPrices(tsCommodity.getPrices());
		model.setPrice(tsCommodity.getMarketPrice());
		model.setImagesPath(generalDao.searchImages(tsShowcom.getTsCommodity().getId(), Constant.TRADE_IMAGES));
		// 判断当前商品状态
		if (tsCommodity.getState().equals("1")) {

		} else {
			// 竞拍结束的商品获得竞拍获得记录信息
			Set sets = tsCommodity.getTsBingcurs();
			if (sets != null && sets.size() > 0) {
				TsBingcur tsBingcur = (TsBingcur) (sets.toArray())[0];
				model.setMarkprices(tsBingcur.getPrice());
				model.setFree(tsBingcur.getFree());
				model.setPay(tsBingcur.getAmount());
				model.setCreattime(tsBingcur.getBinddate());

				// 节省价格
				BigDecimal percents = new BigDecimal(0);
				percents = model.getPrices().subtract(model.getMarkprices()).subtract(new BigDecimal(model.getPay() * 2));
				model.setPercents(percents);
			}
		}

		// 竞拍历史
		PageBean pageBean = new PageBean();
		List<OrderByBean> orderBean = new ArrayList<OrderByBean>();
		orderBean.add(new OrderByBean("", "biddate", "desc"));
		List<SearchBean> searchBeans = new ArrayList<SearchBean>();
		searchBeans.add(new SearchBean("tsCommodity.id", "eq", "string", tsCommodity.getId()));
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
	}

}
