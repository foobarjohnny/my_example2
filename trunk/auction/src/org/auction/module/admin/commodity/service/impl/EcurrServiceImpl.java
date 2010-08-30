package org.auction.module.admin.commodity.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.auction.alipay.AlipayConfig;
import org.auction.entity.TsEcu;
import org.auction.entity.TsEcurr;
import org.auction.entity.TsUser;
import org.auction.module.admin.commodity.data.EcurrData;
import org.auction.module.admin.commodity.service.EcurrService;
import org.mobile.common.bean.LoginBean;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.manager.GeneralManager;
import org.mobile.common.service.GeneralService;
import org.mobile.common.session.SessionManager;
import org.mobile.common.util.BeanProcessUtils;

public class EcurrServiceImpl extends GeneralService implements EcurrService {

	public void delete(EcurrData model) throws GeneralException {
		generalDao.delete(TsEcurr.class, model.getId());
	}

	public void forward(EcurrData model) throws GeneralException {
		if (model.getId() != null && !model.getId().equals("")) {
			TsEcurr tsEcurr = (TsEcurr) generalDao.get(TsEcurr.class, model
					.getId());
			BeanProcessUtils.copyProperties(model, tsEcurr);
		}
	}

	public void save(EcurrData model) throws GeneralException {
		TsEcurr tsEcurr = new TsEcurr();
		BeanProcessUtils.copyProperties(tsEcurr, model);
		if (model.getId() != null && !model.getId().equals("")) {
			generalDao.update(tsEcurr);
		} else {
			generalDao.save(tsEcurr);
		}
	}

	@SuppressWarnings("unchecked")
	public void search(EcurrData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		List list = generalDao.search(TsEcurr.class, search, model
				.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsEcurr tsEcurr = (TsEcurr) list.get(i);
			EcurrData data = new EcurrData();
			BeanProcessUtils.copyProperties(data, tsEcurr);
			model.getDataList().add(data);
		}
	}

	@SuppressWarnings("unchecked")
	public void buy(EcurrData model) throws GeneralException {
		// 获得购买E拍币数量及付款金额
		TsEcurr tsEcurr = (TsEcurr) generalDao
				.get(TsEcurr.class, model.getId());
		// 获得登陆用
		GeneralManager general = GeneralManager.getCurrentManager();
		LoginBean lb = SessionManager.getLoginInfo(general.getSessionId());
		TsUser tsUser = (TsUser) generalDao.get(TsUser.class, lb.getId());
		// 将用户购买E拍币信息放入临时表中
		TsEcu tsEcu = new TsEcu();
		tsEcu.setTsEcurr(tsEcurr);
		tsEcu.setTsUser(tsUser);
		tsEcu.setState("2");
		generalDao.save(tsEcu);
		// 生成参数
		Map params = new HashMap();
		params.put("service", AlipayConfig.service);
		params.put("partner", AlipayConfig.partner);
		params.put("subject", "购买" + tsEcurr.getAmount() + "E拍币");
		params.put("body", tsEcurr.getRemark());
		params.put("out_trade_no", tsEcu.getId());
		params.put("total_fee", String.valueOf(tsEcurr.getPaymoney()));
		params.put("payment_type", AlipayConfig.payment_type);
		params.put("seller_email", AlipayConfig.seller_email);
		params.put("return_url", AlipayConfig.return_url);
		params.put("notify_url", AlipayConfig.notify_url);
		params.put("_input_charset", AlipayConfig.input_charset);
		String url_get = AlipayConfig.createUrl_Get(params);
		model.setUrl(url_get);
	}

}
