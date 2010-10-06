package org.auction.module.admin.commodity.dwr;

import javax.servlet.http.HttpServletRequest;

import org.auction.module.admin.commodity.service.OrderService;
import org.directwebremoting.WebContextFactory;
import org.mobile.common.bean.LoginBean;
import org.mobile.common.exception.GeneralException;

public class BuyTradeHandler {

	private OrderService orderService;

	/**
	 * 购买商品
	 * 
	 * @param id
	 * @return
	 * @throws GeneralException
	 */
	public String buyTradm(String id) throws GeneralException {
		String result = "success";
		HttpServletRequest req = WebContextFactory.get()
				.getHttpServletRequest();
		LoginBean bean = (LoginBean) req.getSession().getAttribute("login");
		if (bean != null) {
			result = orderService.createOrder(id, bean.getId());
		} else {
			result = "请登录后在购买";
		}
		return result;
	}

	/**
	 * 购买商品
	 * 
	 * @param id
	 * @return
	 * @throws GeneralException
	 */
	public String buyTrad(String id) throws Exception {
		String result = "success";
		HttpServletRequest req = WebContextFactory.get()
				.getHttpServletRequest();
		LoginBean bean = (LoginBean) req.getSession().getAttribute("login");
		if (bean != null) {
			result = orderService.createOrders(id, bean.getId());
		} else {
			result = "请登录后在购买";
		}
		return result;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

}
