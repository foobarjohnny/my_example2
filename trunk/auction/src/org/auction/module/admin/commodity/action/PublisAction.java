package org.auction.module.admin.commodity.action;

import org.auction.module.admin.commodity.data.PublisData;
import org.auction.module.admin.commodity.service.PublisService;
import org.mobile.common.action.GeneralAction;

public class PublisAction extends GeneralAction<PublisData> {

	private static final long serialVersionUID = 1L;

	private PublisData model = new PublisData();

	private PublisService publisService;

	public String forward() throws Exception {
		publisService.forward(model);
		return SUCCESS;
	}

	public String save() throws Exception {
		publisService.edit(model);
		return SUCCESS;
	}

	public String delete() throws Exception {
		publisService.delete(model);
		return SUCCESS;
	}

	public String search() throws Exception {
		this.setPage(model);
		publisService.search(model);
		return SUCCESS;
	}

	public String coolSearch() throws Exception {
		this.setPage(model);
		publisService.search(model);
		return SUCCESS;
	}

	public String coolForward() throws Exception {
		publisService.forward(model);
		return SUCCESS;
	}

	public PublisData getModel() {
		return model;
	}

	public void setPublisService(PublisService publisService) {
		this.publisService = publisService;
	}
}
