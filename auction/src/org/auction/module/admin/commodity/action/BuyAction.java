package org.auction.module.admin.commodity.action;

import org.auction.module.admin.commodity.data.BuyData;
import org.auction.module.admin.commodity.service.BuyService;
import org.mobile.common.action.GeneralAction;
import org.mobile.common.exception.GeneralException;

public class BuyAction extends GeneralAction<BuyData> {

	private static final long serialVersionUID = 1L;

	private BuyData model = new BuyData();

	private BuyService buyService;

	public String forward() throws GeneralException {
		buyService.forward(model);
		return SUCCESS;
	}

	public String save() throws GeneralException {
		buyService.save(model);
		return SUCCESS;
	}

	public String delete() throws GeneralException {
		buyService.delete(model);
		return SUCCESS;
	}

	public String search() throws GeneralException {
		this.setPage(model);
		buyService.search(model);
		return SUCCESS;
	}

	public String searchUserE() throws GeneralException {
		this.setPage(model);
		buyService.searchBuy(model);
		return SUCCESS;
	}

	public BuyData getModel() {
		return model;
	}

	public void setBuyService(BuyService buyService) {
		this.buyService = buyService;
	}

}
