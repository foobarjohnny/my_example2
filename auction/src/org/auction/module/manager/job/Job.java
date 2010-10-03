package org.auction.module.manager.job;

import java.util.List;

import org.auction.module.manager.TradeManager;
import org.auction.module.manager.data.TradeData;
import org.auction.module.manager.job.service.IJobService;
import org.mobile.common.exception.GeneralException;

/**
 * 定时调度
 * 
 * @author ThinkPad
 * 
 */
public class Job {

	private IJobService jobService;

	/**
	 * 初始化
	 * 
	 * @throws GeneralException
	 */
	public void initMethod() throws GeneralException {
		addComtity();
	}

	/**
	 * 监听是否有新竞拍商品
	 * 
	 * @throws GeneralException
	 */
	public void addComtity() throws GeneralException {
		List<TradeData> dataList = jobService.getNewComtity(TradeManager.getId());
		for (int i = 0; i < dataList.size(); i++) {
			TradeManager.add(dataList.get(i));
		}
	}

	/**
	 * 竞拍结束商品生成订单
	 */
	public void destoryComtity() throws GeneralException {
		jobService.finish();
	}

	public void setJobService(IJobService jobService) {
		this.jobService = jobService;
	}
}
