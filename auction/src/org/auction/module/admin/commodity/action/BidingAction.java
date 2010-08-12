package org.auction.module.admin.commodity.action;

import org.auction.module.admin.commodity.data.BidingData;
import org.mobile.common.action.GeneralAction;
import org.mobile.common.exception.GeneralException;

public class BidingAction extends GeneralAction<BidingData> {

	private static final long serialVersionUID = 1L;

	private BidingData model = new BidingData();

	public String forward() throws GeneralException {
		return SUCCESS;
	}

	public String save() throws GeneralException {
		return SUCCESS;
	}

	public String delete() throws GeneralException {
		return SUCCESS;
	}

	public String search() throws GeneralException {
		return SUCCESS;
	}

	public BidingData getModel() {
		return model;
	}

}
