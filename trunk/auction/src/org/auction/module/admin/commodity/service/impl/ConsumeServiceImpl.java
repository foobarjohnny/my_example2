package org.auction.module.admin.commodity.service.impl;

import java.util.Iterator;
import java.util.List;

import org.auction.entity.TsBingcur;
import org.auction.entity.TsCommodity;
import org.auction.entity.TsConsume;
import org.auction.entity.TsUser;
import org.auction.module.admin.commodity.data.ConsumeData;
import org.auction.module.admin.commodity.service.ConsumeService;
import org.mobile.common.bean.LoginBean;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.manager.GeneralManager;
import org.mobile.common.service.GeneralService;
import org.mobile.common.session.SessionManager;
import org.mobile.common.util.BeanProcessUtils;

public class ConsumeServiceImpl extends GeneralService implements
		ConsumeService {

	public void delete(ConsumeData model) throws GeneralException {
		generalDao.delete(TsConsume.class, model.getId());
	}

	public void forward(ConsumeData model) throws GeneralException {
		if (model.getId() != null && !model.getId().equals("")) {
			TsConsume tsConsume = (TsConsume) generalDao.get(TsConsume.class,
					model.getId());
			BeanProcessUtils.copyProperties(model, tsConsume);
		}
	}

	public void save(ConsumeData model) throws GeneralException {
		TsConsume tsConsume = new TsConsume();
		BeanProcessUtils.copyProperties(tsConsume, model);
		if (model.getId() != null && !model.getId().equals("")) {
			generalDao.update(tsConsume);
		} else {
			generalDao.save(tsConsume);
		}
	}

	@SuppressWarnings("unchecked")
	public void search(ConsumeData model) throws GeneralException {
		String hql = "select c.tsCommodity,sum(c.amount),c.tsUser  from TsConsume c ";
		if (model.getSearchBeans() != null && model.getSearchBeans().size() > 0) {
			if (model.getSearchBeans().get(0) != null) {
				SearchBean s = model.getSearchBeans().get(0);
				hql += " where c.tsUser.username='" + s.getValue() + "'";
			}
		}
		hql += " group by c.tsCommodity,c.tsUser";
		String pageTotal = "select count(id) as id from TsConsume c ";
		if (model.getSearchBeans() != null && model.getSearchBeans().size() > 0) {
			if (model.getSearchBeans().get(0) != null) {
				SearchBean s = model.getSearchBeans().get(0);
				pageTotal += " where c.tsUser.username='" + s.getValue() + "'";
			}
		}
		
		List list = generalDao.search(hql, pageTotal, model.getPageBean());
		if (list != null && list.size() > 0) {
			for (int i=0;i<list.size();i++) {
				ConsumeData data = new ConsumeData();
				Object[] obj = (Object[])list.get(i);
				TsCommodity tsCommodity = (TsCommodity)obj[0];
				data.setAmount((Integer)obj[1]);
				data.setComname(tsCommodity.getTradename());
				data.setDescript(tsCommodity.getSummary());
				data.setComId(tsCommodity.getId());
				data.setMarkPrice(tsCommodity.getPrices());
				TsUser tsUser = (TsUser)obj[2];
				data.setUsername(tsUser.getUsername());
				Iterator it = tsCommodity.getTsBingcurs().iterator();
				if (it.hasNext()) {
					TsBingcur tsBingcur = (TsBingcur)it.next();
					data.setPrice(tsBingcur.getPrice());
				}
				model.getDataList().add(data);
			}
		}
	}

	/**
	 * 用户E拍币消费情况
	 */
	@SuppressWarnings("unchecked")
	public void searchPayE(ConsumeData model) throws GeneralException {
		LoginBean loginBean = SessionManager.getLoginInfo(GeneralManager
				.getCurrentManager().getSessionId());
		if (loginBean != null) {
			String hql = "select c.tsCommodity,sum(c.amount) from TsConsume c where c.tsUser.id='" + loginBean.getId() + "' group by c.tsCommodity";
			String pageTotal = "select count(id) from TsConsume c where c.tsUser.id='" + loginBean.getId() + "' ";
			List list = generalDao.search(hql, pageTotal, model.getPageBean());
			if (list != null && list.size() > 0) {
				for (int i=0;i<list.size();i++) {
					ConsumeData data = new ConsumeData();
					Object[] obj = (Object[])list.get(i);
					TsCommodity tsCommodity = (TsCommodity)obj[0];
					data.setAmount((Integer)obj[1]);
					data.setComname(tsCommodity.getTradename());
					data.setDescript(tsCommodity.getSummary());
					data.setComId(tsCommodity.getId());
					data.setMarkPrice(tsCommodity.getPrices());
					Iterator it = tsCommodity.getTsBingcurs().iterator();
					if (it.hasNext()) {
						TsBingcur tsBingcur = (TsBingcur)it.next();
						data.setPrice(tsBingcur.getPrice());
					}
					model.getDataList().add(data);
				}
			}
		}
		
	}

}
