package org.auction.module.admin.commodity.dwr;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.auction.module.admin.commodity.data.AuctionData;
import org.auction.module.admin.commodity.service.AuctionService;
import org.directwebremoting.WebContextFactory;
import org.mobile.common.bean.LoginBean;

/**
 * 竞拍的DWR响应类
 * @author Administrator
 *
 */
public class AuctionHandler {

	private AuctionService auctionService;

	/**
	 * 客户竞拍的操作方法
	 * @param comptyId
	 * @param price
	 * @param userId
	 * @param htmlId  这个参数可以不用使用了。
	 * @return
	 */
	public String auction(String comptyId, String price, String userId,
			String htmlId) {
		HttpServletRequest req = WebContextFactory.get().getHttpServletRequest();
		LoginBean bean = (LoginBean) req.getSession().getAttribute("login");
		if (bean != null) {
			if (userId != null && !userId.equals(bean.getId())) {
				AuctionData data = new AuctionData();
				data.setComptyId(comptyId);
				data.setUserId(bean.getId());
				data.setPrice(new BigDecimal(price));
				boolean is = false;
				try {
					is = auctionService.auction(data);
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (is) {
					if (data.isAdd()) {
						return "{'operator':'success','id':'"+comptyId+"', 'add':" + data.getTime() + "}";
					} else {
						return "{'operator':'success'}";
					}
				} else {
					return "{'operator':'error', 'msg':'竞拍点数不够，请充值在竞拍。'}";
				}
			} else {
				return "{'operator':'error','msg':'你现在是最高出价者。'}";
			}
		} else {
			return "{'operator':'error','msg':'你还没有登录，请先登录在参加竞拍。'}";
		}
	}

	public void setAuctionService(AuctionService auctionService) {
		this.auctionService = auctionService;
	}
}
