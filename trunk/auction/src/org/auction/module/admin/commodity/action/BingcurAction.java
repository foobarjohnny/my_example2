package org.auction.module.admin.commodity.action;

import org.auction.module.admin.commodity.data.BingcurData;
import org.auction.module.admin.commodity.service.BingcurService;
import org.mobile.common.action.GeneralAction;
import org.mobile.common.exception.GeneralException;

public class BingcurAction extends GeneralAction<BingcurData> {

	private static final long serialVersionUID = 1L;

	private BingcurData model = new BingcurData();
	
	private BingcurService bingcurService;

	public String forward() throws GeneralException {
		bingcurService.forward(model);
		return SUCCESS;
	}

	public String save() throws GeneralException {
		return SUCCESS;
	}

	public String delete() throws GeneralException {
		return SUCCESS;
	}

	public String search() throws GeneralException {
		setPage(model);
		bingcurService.search(model);
		return SUCCESS;
	}
	
	public String searchBiding() throws GeneralException {
		setPage(model);
		bingcurService.searchBiding(model);
		return SUCCESS;
	}

	public BingcurData getModel() {
		return model;
	}

	public void setBingcurService(BingcurService bingcurService) {
		this.bingcurService = bingcurService;
	}

}
