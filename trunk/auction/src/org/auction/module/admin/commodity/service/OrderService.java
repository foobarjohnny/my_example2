package org.auction.module.admin.commodity.service;

import org.auction.module.admin.commodity.data.OrderData;
import org.mobile.common.exception.GeneralException;

public interface OrderService {

	public void forward(OrderData model) throws GeneralException;

	public void save(OrderData model) throws GeneralException;

	public void delete(OrderData model) throws GeneralException;

	public void search(OrderData model) throws GeneralException;

	public String createOrder(String id, String sessionId)
			throws GeneralException;
}
