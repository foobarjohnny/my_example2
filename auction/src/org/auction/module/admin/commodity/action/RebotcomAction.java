package org.auction.module.admin.commodity.action;

import org.auction.module.admin.commodity.data.RebotcomData;
import org.mobile.common.action.GeneralAction;
import org.mobile.common.exception.GeneralException;

public class RebotcomAction extends GeneralAction<RebotcomData> {

	private static final long serialVersionUID = 1L;

	private RebotcomData model = new RebotcomData();

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

	public RebotcomData getModel() {
		return model;
	}

}
