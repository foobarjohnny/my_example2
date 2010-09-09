package org.auction.module.admin.commodity.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.auction.entity.TsBingcur;
import org.auction.entity.TsCommodity;
import org.auction.entity.TsShowcom;
import org.auction.entity.TsUser;
import org.auction.module.admin.commodity.data.ShowcomData;
import org.auction.module.admin.commodity.service.ShowcomService;
import org.mobile.common.bean.LoginBean;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.manager.GeneralManager;
import org.mobile.common.service.GeneralService;
import org.mobile.common.session.SessionManager;
import org.mobile.common.util.BeanProcessUtils;

public class ShowcomServiceImpl extends GeneralService implements
		ShowcomService {

	public void forward(ShowcomData model) throws Exception {
		GeneralManager gm = GeneralManager.getCurrentManager();
		LoginBean lb = SessionManager.getLoginInfo(gm.getSessionId());
		if (lb != null) {
			TsCommodity tsCommodity = (TsCommodity) generalDao.get(
					TsCommodity.class, model.getTradeId());
			model.setUserID(lb.getId());
			model.setUsername(lb.getWorkNo());
			model.setTradeId(tsCommodity.getId());
			model.setTradename(tsCommodity.getTradename());
		}
	}

	public void aut(ShowcomData model) throws Exception {
		TsShowcom tsShowcom = (TsShowcom) generalDao.get(TsShowcom.class, model
				.getId());
		tsShowcom.setAut("1");
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

	@SuppressWarnings("unchecked")
	public void notAut(ShowcomData model) throws Exception {
		List<SearchBean> sbs = new ArrayList<SearchBean>();
		sbs.add(new SearchBean("aut", "eq", "string", "2"));
		List list = generalDao.search(TsShowcom.class, sbs,
				model.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsShowcom tsShowcom = (TsShowcom) list.get(i);
			ShowcomData data = new ShowcomData();
			BeanProcessUtils.copyProperties(data, tsShowcom);
			data.setTradeId(tsShowcom.getTsCommodity().getId());
			data.setTradename(tsShowcom.getTsCommodity().getTradename());
			data.setUsername(tsShowcom.getTsUser().getUsername());
			// 商品竞拍
			List<SearchBean> search = new ArrayList<SearchBean>();
			search.add(new SearchBean("tsCommodity.id", "eq", "string",
					tsShowcom.getTsCommodity().getId()));
			List bing_list = generalDao.search(TsBingcur.class, search, null,
					null);
			if (bing_list != null && bing_list.size() > 0) {
				TsBingcur tsBingcur = (TsBingcur) bing_list.get(0);
				data.setBidId(tsBingcur.getId());
			}
			model.getDataList().add(data);
		}
	}

	public void save(ShowcomData model) throws Exception {
		TsShowcom tsShowcom = new TsShowcom();
		BeanProcessUtils.copyProperties(tsShowcom, model);
		tsShowcom.setAut("2");
		TsCommodity tsCommodity = (TsCommodity) generalDao.get(
				TsCommodity.class, model.getTradeId());
		tsShowcom.setTsCommodity(tsCommodity);
		TsUser tsUser = (TsUser) generalDao
				.get(TsUser.class, model.getUserID());
		tsShowcom.setTsUser(tsUser);
		tsShowcom.setCreattime(new Date());
		generalDao.save(tsShowcom);
	}

	@SuppressWarnings("unchecked")
	public void view(ShowcomData model) throws Exception {
		TsShowcom tsShowcom = (TsShowcom) generalDao.get(TsShowcom.class, model
				.getId());
		model.setId(tsShowcom.getId());
		model.setTradename(tsShowcom.getTsCommodity().getTradename());
		model.setTradeId(tsShowcom.getTsCommodity().getId());
		model.setRemark(tsShowcom.getRemark());
		model.setAut(tsShowcom.getAut());
		// 商品竞拍
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("tsCommodity.id", "eq", "string", tsShowcom
				.getTsCommodity().getId()));
		List bing_list = generalDao.search(TsBingcur.class, search, null, null);
		if (bing_list != null && bing_list.size() > 0) {
			TsBingcur tsBingcur = (TsBingcur) bing_list.get(0);
			model.setBidId(tsBingcur.getId());
			model.setUsername(tsBingcur.getTsUser().getUsername());
			model.setCreattime(tsBingcur.getBinddate());
			model.setPrice(tsBingcur.getPrice());
		}
	}

	@SuppressWarnings("unchecked")
	public void finshedAut(ShowcomData model) throws Exception {
		List<SearchBean> sbs = new ArrayList<SearchBean>();
		sbs.add(new SearchBean("aut", "eq", "string", "1"));
		List list = generalDao.search(TsShowcom.class, sbs,
				model.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsShowcom tsShowcom = (TsShowcom) list.get(i);
			ShowcomData data = new ShowcomData();
			BeanProcessUtils.copyProperties(data, tsShowcom);
			data.setTradeId(tsShowcom.getTsCommodity().getId());
			data.setTradename(tsShowcom.getTsCommodity().getTradename());
			data.setUsername(tsShowcom.getTsUser().getUsername());
			// 商品竞拍
			List<SearchBean> search = new ArrayList<SearchBean>();
			search.add(new SearchBean("tsCommodity.id", "eq", "string",
					tsShowcom.getTsCommodity().getId()));
			List bing_list = generalDao.search(TsBingcur.class, search, null,
					null);
			if (bing_list != null && bing_list.size() > 0) {
				TsBingcur tsBingcur = (TsBingcur) bing_list.get(0);
				data.setBidId(tsBingcur.getId());
			}
			model.getDataList().add(data);
		}
	}

	@SuppressWarnings("unchecked")
	public void viewList(ShowcomData model) throws Exception {
		List<SearchBean> sbs = new ArrayList<SearchBean>();
		sbs.add(new SearchBean("aut", "eq", "string", "1"));
		List list = generalDao.search(TsShowcom.class, sbs,
				model.getPageBean(), null);
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
			search.add(new SearchBean("tsCommodity.id", "eq", "string",
					tsShowcom.getTsCommodity().getId()));
			List bing_list = generalDao.search(TsBingcur.class, search, null,
					null);
			if (bing_list != null && bing_list.size() > 0) {
				TsBingcur tsBingcur = (TsBingcur) bing_list.get(0);
				data.setBidId(tsBingcur.getId());
				// 节约
				if (tsBingcur.getTsUser().getId().equals(
						tsShowcom.getTsUser().getId())) {
					data.setPrice(tsBingcur.getPrice());
					BigDecimal bg = tsBingcur.getPrice().add(
							new BigDecimal(tsBingcur.getAmount() * 2));
					data.setJs(((data.getMprice().subtract(bg)).divide(data
							.getMprice(), BigDecimal.ROUND_HALF_DOWN))
							.multiply(new BigDecimal(100)));
				} else {
					data
							.setPrice(tsShowcom.getTsCommodity()
									.getPurchasePrice());
					data.setJs(((data.getMprice().subtract(tsShowcom
							.getTsCommodity().getPurchasePrice())).divide(data
							.getMprice(), BigDecimal.ROUND_HALF_DOWN))
							.multiply(new BigDecimal(100)));
				}
			}
			model.getDataList().add(data);
		}
	}

}
