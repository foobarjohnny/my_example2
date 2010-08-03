package org.auction.module.admin.commodity.action;

import org.auction.module.admin.commodity.data.RebotData;
import org.auction.module.admin.commodity.service.RebotService;
import org.mobile.common.action.GeneralAction;
import org.mobile.common.exception.GeneralException;

public class RebotAction extends GeneralAction<RebotData> {

	private static final long serialVersionUID = 1L;

	private RebotData model = new RebotData();

	private RebotService rebotService;

	public String forward() throws GeneralException {
		rebotService.forward(model);
		return SUCCESS;
	}

	public String save() throws GeneralException {
		rebotService.save(model);
		return SUCCESS;
	}

	public String delete() throws GeneralException {
		rebotService.delete(model);
		return SUCCESS;
	}

	public String search() throws GeneralException {
		rebotService.search(model);
		return SUCCESS;
	}

	public RebotData getModel() {
		return model;
	}

	public void setRebotService(RebotService rebotService) {
		this.rebotService = rebotService;
	}

}
