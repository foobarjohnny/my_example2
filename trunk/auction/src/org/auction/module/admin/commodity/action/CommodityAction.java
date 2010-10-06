package org.auction.module.admin.commodity.action;

import org.auction.module.admin.commodity.data.CommodityData;
import org.auction.module.admin.commodity.service.CommodityService;
import org.mobile.common.action.GeneralAction;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.util.Constant.COMMODITY_STATE;

public class CommodityAction extends GeneralAction<CommodityData> {

	private static final long serialVersionUID = 1L;

	private CommodityData model = new CommodityData();

	private CommodityService commodityService;

	public String forward() throws GeneralException {
		commodityService.forward(model);
		return SUCCESS;
	}

	/**
	 * 新增产品
	 * 
	 * @return
	 * @throws GeneralException
	 */
	public String save() throws GeneralException {
		try {
			commodityService.save(model);
			if (model.getMethodName().equals("1")) {
				return SUCCESS;
			} else {
				return "page";
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new GeneralException("");
		}
	}

	public String delete() throws GeneralException {
		commodityService.delete(model);
		return SUCCESS;
	}

	public String auction() throws GeneralException {
		commodityService.auction(model);
		return SUCCESS;
	}

	/**
	 * 查询产品
	 * 
	 * @return
	 * @throws GeneralException
	 */
	public String search() throws GeneralException {
		this.setPage(model);
		// 
		if (model.getSearchName() != null
				&& model.getSearchName().equals(COMMODITY_STATE.AUCTION_STATE)) {
			// 正在竞拍商品
			commodityService.searchProgress(model);
			return "progress";
		} else if (model.getSearchName() != null
				&& model.getSearchName().equals(COMMODITY_STATE.CANCEL_STATE)) {
			// 流拍商品
			commodityService.searchLot(model);
			return "lot";
		} else if (model.getSearchName() != null
				&& model.getSearchName().equals(COMMODITY_STATE.SUCCESS_STATE)) {
			// 成交商品
			commodityService.searchReach(model);
			return "reach";
		} else {
			// 显示产品列表
			commodityService.search(model);
			return SUCCESS;
		}
	}

	public String view() throws Exception {
		commodityService.getReach(model);
		return SUCCESS;
	}

	public String history() throws Exception {
		commodityService.getReachView(model);
		return SUCCESS;
	}

	public String select() throws GeneralException {
		commodityService.select(model);
		return SUCCESS;
	}

	public CommodityData getModel() {
		return model;
	}

	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

}
