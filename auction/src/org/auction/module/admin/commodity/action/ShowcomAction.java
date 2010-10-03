package org.auction.module.admin.commodity.action;

import org.auction.module.admin.commodity.data.ShowcomData;
import org.auction.module.admin.commodity.service.ShowcomService;
import org.mobile.common.action.GeneralAction;

public class ShowcomAction extends GeneralAction<ShowcomData> {

	private static final long serialVersionUID = 1L;

	private ShowcomData model = new ShowcomData();

	private ShowcomService showcomService;

	public String notAut() throws Exception {
		this.setPage(model);
		showcomService.notAut(model);
		return SUCCESS;
	}

	public String aut() throws Exception {
		showcomService.aut(model);
		return SUCCESS;
	}

	public String save() throws Exception {
		showcomService.save(model);
		return SUCCESS;
	}

	public String forward() throws Exception {
		showcomService.forward(model);
		return SUCCESS;
	}

	public String finshedAut() throws Exception {
		this.setPage(model);
		showcomService.finshedAut(model);
		return SUCCESS;
	}

	public String delete() throws Exception {
		showcomService.delete(model);
		return SUCCESS;
	}

	public String delete2() throws Exception {
		showcomService.delete(model);
		return SUCCESS;
	}

	public String view() throws Exception {
		showcomService.view(model);
		return SUCCESS;
	}

	public String viewList() throws Exception {
		this.setPage(model);
		showcomService.viewList(model);
		return SUCCESS;
	}
	
	public String showList() throws Exception {
		this.setPage(model);
		showcomService.showList(model);
		return SUCCESS;
	}

	public ShowcomData getModel() {
		return model;
	}

	public void setShowcomService(ShowcomService showcomService) {
		this.showcomService = showcomService;
	}
}
