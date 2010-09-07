package org.auction.module.admin.commodity.action;

import org.auction.module.admin.commodity.data.CommodityData;
import org.auction.module.admin.commodity.service.CommodityService;
import org.mobile.common.action.GeneralAction;
import org.mobile.common.exception.GeneralException;

public class CommodityAction extends GeneralAction<CommodityData> {

	private static final long serialVersionUID = 1L;

	private CommodityData model = new CommodityData();

	private CommodityService commodityService;

	public String forward() throws GeneralException {
		commodityService.forward(model);
		return SUCCESS;
	}

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

	public String search() throws GeneralException {
		this.setPage(model);
		if (model.getSearchName() != null && model.getSearchName().equals("1")) {
			commodityService.searchProgress(model);
			return "progress";
		} else if (model.getSearchName() != null
				&& model.getSearchName().equals("2")) {
			commodityService.searchLot(model);
			return "lot";
		} else if (model.getSearchName() != null
				&& model.getSearchName().equals("3")) {
			commodityService.searchReach(model);
			return "reach";
		} else {
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
