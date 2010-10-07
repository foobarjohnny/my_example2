package org.auction.module.admin.commodity.service;

import org.auction.module.admin.commodity.data.AidData;

public interface AidService {

	/**
	 * 前台保存设置的竞拍助理信息
	 * 
	 * @param model
	 * @throws Exception
	 */
	public void edit(AidData model) throws Exception;

	/**
	 * 前台用户竞拍助理列表
	 * 
	 * @param model
	 * @throws Exception
	 */
	public void searchList(AidData model) throws Exception;

	/**
	 * 前台用户删除竞拍助理，并且返回竞拍点数
	 * 
	 * @param model
	 * @throws Exception
	 */
	public void delete(AidData model) throws Exception;
}
