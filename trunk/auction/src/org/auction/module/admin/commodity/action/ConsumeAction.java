package org.auction.module.admin.commodity.action;

import org.auction.module.admin.commodity.data.ConsumeData;
import org.auction.module.admin.commodity.service.ConsumeService;
import org.mobile.common.action.GeneralAction;
import org.mobile.common.exception.GeneralException;

public class ConsumeAction extends GeneralAction<ConsumeData> {

	private static final long serialVersionUID = 1L;

	private ConsumeData model = new ConsumeData();

	private ConsumeService consumeService;

	public String forward() throws GeneralException {
		consumeService.forward(model);
		return SUCCESS;
	}

	public String save() throws GeneralException {
		consumeService.save(model);
		return SUCCESS;
	}

	public String delete() throws GeneralException {
		consumeService.delete(model);
		return SUCCESS;
	}

	public String search() throws GeneralException {
		this.setPage(model);
		consumeService.search(model);
		return SUCCESS;
	}

	public ConsumeData getModel() {
		return model;
	}

	public void setConsumeService(ConsumeService consumeService) {
		this.consumeService = consumeService;
	}

}
