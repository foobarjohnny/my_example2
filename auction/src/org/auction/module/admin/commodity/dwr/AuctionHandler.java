package org.auction.module.admin.commodity.dwr;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.auction.module.admin.commodity.data.AuctionData;
import org.auction.module.admin.commodity.service.AuctionService;
import org.directwebremoting.WebContextFactory;
import org.mobile.common.bean.LoginBean;

public class AuctionHandler {

	private AuctionService auctionService;

	public String auction(String comptyId, String price, String userId) {
		HttpServletRequest req = WebContextFactory.get()
				.getHttpServletRequest();
		LoginBean bean = (LoginBean) req.getSession().getAttribute("login");
		if (bean != null) {
			if (userId != null && !userId.equals(bean.getId())) {
				AuctionData data = new AuctionData();
				data.setComptyId(comptyId);
				data.setUserId(bean.getId());
				data.setPrice(new BigDecimal(price));
				auctionService.auction(data);
				return "success";
			} else {
				return "你现在是最高出价者，请勿瞎点，否则出事概不负责。";
			}
		} else {
			return "你还没有登录，请先登录在参加竞拍。";
		}
	}

	public void setAuctionService(AuctionService auctionService) {
		this.auctionService = auctionService;
	}
}
