package org.auction.module.admin.commodity.action;

import org.auction.module.admin.commodity.data.OrderData;
import org.auction.module.admin.commodity.service.OrderService;
import org.mobile.common.action.GeneralAction;
import org.mobile.common.exception.GeneralException;

public class OrderAction extends GeneralAction<OrderData> {

	private static final long serialVersionUID = 1L;

	private OrderData model = new OrderData();

	private OrderService orderService;

	private String requestUrl;

	public String pay() throws GeneralException {
		// 查找订单信息
		orderService.pay(model);
		requestUrl = model.getUrl();
		return SUCCESS;
	}

	public String forward() throws GeneralException {
		orderService.forward(model);
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

	public String cancel() throws GeneralException {
		orderService.channel(model);
		return SUCCESS;
	}
	
	public String view() throws GeneralException {
		orderService.view(model);
		return SUCCESS;
	}

	public OrderData getModel() {
		return model;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

}
