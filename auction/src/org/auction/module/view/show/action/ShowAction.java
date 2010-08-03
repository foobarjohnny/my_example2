package org.auction.module.view.show.action;

import org.auction.module.view.show.data.ShowData;
import org.auction.module.view.show.service.IShowService;
import org.mobile.common.action.GeneralAction;

public class ShowAction extends GeneralAction<ShowData> {

	private static final long serialVersionUID = 1L;

	private ShowData model = new ShowData();

	private IShowService showService;

	public String show() throws Exception {
		showService.show(model);
		return SUCCESS;
	}

	public ShowData getModel() {
		return model;
	}

	public void setShowService(IShowService showService) {
		this.showService = showService;
	}
}
