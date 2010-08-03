package org.auction.module.admin.commodity.action;

import org.auction.module.admin.commodity.data.SortData;
import org.auction.module.admin.commodity.service.SortService;
import org.mobile.common.action.GeneralAction;
import org.mobile.common.exception.GeneralException;

public class SortAction extends GeneralAction<SortData> {

	private static final long serialVersionUID = 1L;

	private SortData model = new SortData();
	
	private SortService sortService;

	public String forward() throws GeneralException {
		sortService.forward(model);
		return SUCCESS;
	}

	public String save() throws GeneralException {
		sortService.save(model);
		return SUCCESS;
	}

	public String delete() throws GeneralException {
		sortService.delete(model);
		return SUCCESS;
	}

	public String search() throws GeneralException {
		this.setPage(model);
		sortService.search(model);
		return SUCCESS;
	}

	public SortData getModel() {
		return model;
	}

	public void setSortService(SortService sortService) {
		this.sortService = sortService;
	}

}
