package org.auction.module.manager.alipay.service;

import org.auction.module.manager.data.AlipayData;

public interface AlipayService {

	public void handleOrder(AlipayData model) throws Exception;
	
	public void handler(AlipayData model) throws Exception;
}
