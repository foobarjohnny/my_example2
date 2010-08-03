package org.auction.module.admin.commodity.action;

import org.auction.module.admin.commodity.data.OrderData;
import org.auction.module.admin.commodity.service.OrderService;
import org.mobile.common.action.GeneralAction;
import org.mobile.common.exception.GeneralException;

public class OrderAction extends GeneralAction<OrderData> {

	private static final long serialVersionUID = 1L;

	private OrderData model = new OrderData();
	
	private OrderService orderService;

	public String forward() throws GeneralException {
		return SUCCESS;
	}

	public String save() throws GeneralException {
		return SUCCESS;
	}

	public String delete() throws GeneralException {
		return SUCCESS;
	}

	public String search() throws GeneralException {
		this.setPage(model);
		orderService.search(model);
		return SUCCESS;
	}

	public OrderData getModel() {
		return model;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

}
