package org.auction.module.admin.base.action;

import org.auction.module.admin.base.data.DoohickeyData;
import org.auction.module.admin.base.service.DoohickeyService;
import org.mobile.common.action.GeneralAction;

public class DoohickeyAction extends GeneralAction<DoohickeyData> {

	private static final long serialVersionUID = 1L;

	private DoohickeyData model = new DoohickeyData();

	private DoohickeyService doohickeyService;

	public DoohickeyData getModel() {
		return model;
	}

	public void setDoohickeyService(DoohickeyService doohickeyService) {
		this.doohickeyService = doohickeyService;
	}
}
