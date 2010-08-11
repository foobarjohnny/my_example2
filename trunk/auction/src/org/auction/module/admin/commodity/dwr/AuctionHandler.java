package org.auction.module.admin.commodity.dwr;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.auction.module.admin.commodity.data.AuctionData;
import org.auction.module.admin.commodity.service.AuctionService;
import org.directwebremoting.WebContextFactory;
import org.mobile.common.bean.LoginBean;

public class AuctionHandler {

	private AuctionService auctionService;

	public void auction(String comptyId, String price) {
		HttpServletRequest req = WebContextFactory.get()
				.getHttpServletRequest();
		LoginBean bean = (LoginBean) req.getSession().getAttribute("login");
		if (bean != null) {
			AuctionData data = new AuctionData();
			data.setComptyId(comptyId);
			data.setUserId(bean.getId());
			data.setPrice(new BigDecimal(price));
			auctionService.auction(data);
		}
	}

	public void setAuctionService(AuctionService auctionService) {
		this.auctionService = auctionService;
	}
}
