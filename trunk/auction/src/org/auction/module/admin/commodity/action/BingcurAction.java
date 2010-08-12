package org.auction.module.admin.commodity.action;

import org.auction.module.admin.commodity.data.BingcurData;
import org.mobile.common.action.GeneralAction;
import org.mobile.common.exception.GeneralException;

public class BingcurAction extends GeneralAction<BingcurData> {

	private static final long serialVersionUID = 1L;

	private BingcurData model = new BingcurData();

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

	public BingcurData getModel() {
		return model;
	}

}
