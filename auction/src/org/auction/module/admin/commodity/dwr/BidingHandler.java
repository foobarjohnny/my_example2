package org.auction.module.admin.commodity.dwr;

import java.util.List;

import org.auction.module.admin.commodity.data.BidingData;
import org.auction.module.admin.commodity.service.BidingService;
import org.mobile.common.exception.GeneralException;

/**
 * 
 * @author ThinkPad
 * 
 */
public class BidingHandler {

	private BidingService bidingService;

	@SuppressWarnings("unchecked")
	public String find(String commpityId, String userId, String did)
			throws GeneralException {
		String returnStr = "no";
		BidingData model = new BidingData();
		model.setCommpityId(commpityId);
		model.setUserId(userId);
		List<BidingData> list = bidingService.findNewPeople(model);
		if (list != null && list.size() > 0) {
			BidingData data = list.get(0);
			if (data.getUserId() != null) {
				returnStr = "index:" + did;
				returnStr += ",userId:" + data.getUserId();
				returnStr += ",username:" + data.getUsername();
				returnStr += ",price:" + data.getPrice();
				returnStr += ",add:" + data.getTime();
			}
		}
		return returnStr;
	}

	/**
	 * 商品是否真的结束
	 * 
	 * @param commpityId
	 * @param userId
	 * @param did
	 * @return
	 * @throws GeneralException
	 */
	@SuppressWarnings("unchecked")
	public String finish(String commpityId, String userId, String did)
			throws GeneralException {
		String resultStr = "";
		BidingData model = new BidingData();
		model.setCommpityId(commpityId);
		model.setUserId(userId);
		List<BidingData> list = bidingService.findNewPeople(model);
		if (list != null && list.size() > 0) {
			BidingData data = list.get(0);
			if (data.getUserId() != null) {
				resultStr = "index:" + did;
				resultStr += ",userId:" + data.getUserId();
				resultStr += ",username:" + data.getUsername();
				resultStr += ",price:" + data.getPrice();
				resultStr += ",add:" + data.getTime();
			}
		} else {
			resultStr = "over";
		}
		return resultStr;
	}

	public void setBidingService(BidingService bidingService) {
		this.bidingService = bidingService;
	}
}