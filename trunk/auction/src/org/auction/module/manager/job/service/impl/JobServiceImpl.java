package org.auction.module.manager.job.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.auction.entity.TsBidding;
import org.auction.entity.TsCommodity;
import org.auction.module.manager.data.TradeData;
import org.auction.module.manager.job.service.IJobService;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.service.GeneralService;
import org.mobile.common.util.BeanProcessUtils;

public class JobServiceImpl extends GeneralService implements IJobService {

	@SuppressWarnings("unchecked")
	public List<TradeData> getNewComtity(String[] ids) throws GeneralException {
		List<TradeData> dataList = new ArrayList<TradeData>();
		List list = this.generalDao.auction(ids);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				TsCommodity tsCommodity = (TsCommodity) list.get(i);
				if (tsCommodity.getState().equals("4")) {
					tsCommodity.setState("1");
					generalDao.update(tsCommodity);
					TradeData data = new TradeData();
					BeanProcessUtils.copyProperties(data, tsCommodity);
					dataList.add(data);
				} else if (tsCommodity.getState().equals("1")) {
					TradeData data = new TradeData();
					BeanProcessUtils.copyProperties(data, tsCommodity);
					TsBidding tsBidding = (TsBidding) generalDao
							.getBinding(tsCommodity.getId());
					if (tsBidding != null) {
						BeanProcessUtils.copyProperties(data, tsBidding);
						data.setBid(tsBidding.getId());
						BeanProcessUtils.copyProperties(data, tsBidding.getTsUser());
						data.setUid(tsBidding.getTsUser().getId());
						data.setId(tsCommodity.getId());
					}
					dataList.add(data);
				}

			}
		}
		return dataList;
	}

}
