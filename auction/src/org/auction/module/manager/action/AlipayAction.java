package org.auction.module.manager.action;

import org.auction.module.manager.alipay.service.AlipayService;
import org.auction.module.manager.data.AlipayData;
import org.mobile.common.action.GeneralAction;

public class AlipayAction extends GeneralAction<AlipayData> {

	private static final long serialVersionUID = 1L;

	private AlipayData model = new AlipayData();

	private AlipayService alipayService;

	/**
	 * 支付宝返回业务处理
	 * 
	 * @return
	 * @throws Exception
	 */
	public String handler() throws Exception {
		alipayService.handleOrder(model);
		return SUCCESS;
	}

	/**
	 * 支付宝异步处理
	 * 
	 * @throws Exception
	 */
	public void notifyUrl() throws Exception {
		
	}

	public AlipayData getModel() {
		return model;
	}

	public void setAlipayService(AlipayService alipayService) {
		this.alipayService = alipayService;
	}
}
