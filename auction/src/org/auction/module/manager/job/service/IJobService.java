package org.auction.module.manager.job.service;

import java.util.List;

import org.auction.module.manager.data.TradeData;
import org.mobile.common.exception.GeneralException;

public interface IJobService {

	/**
	 * 得到新的竞拍的产品信息
	 * 
	 * @param ids
	 * @return
	 * @throws GeneralException
	 */
	public List<TradeData> getNewComtity(String[] ids) throws GeneralException;

	/**
	 * 对于竞拍结束的产品进行处理
	 * 
	 * @throws GeneralException
	 */
	public void finish() throws GeneralException;

	/**
	 * 移除竞拍结束的商品
	 * 
	 * @throws GeneralException
	 */
	public void remove() throws GeneralException;
}
