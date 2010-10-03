package org.auction.module.admin.base.action;

import org.auction.module.admin.base.data.DoohickeyData;
import org.auction.module.admin.base.service.DoohickeyService;
import org.mobile.common.action.GeneralAction;

public class DoohickeyAction extends GeneralAction<DoohickeyData> {

	private static final long serialVersionUID = 1L;

	private DoohickeyData model = new DoohickeyData();

	private DoohickeyService doohickeyService;

	public String list() throws Exception {
		this.setPage(model);
		doohickeyService.search(model);
		return SUCCESS;
	}
	
	public String show() throws Exception {
		this.setPage(model);
		model.getPageBean().setPageRec(30);
		doohickeyService.search(model);
		return SUCCESS;
	}
	
	public String forward() throws Exception {
		if (!checkedLogin()) {
			return "login";
		}
		doohickeyService.forward(model);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		doohickeyService.delete(model);
		return SUCCESS;
	}
	
	public String view() throws Exception {
		doohickeyService.view(model);
		return SUCCESS;
	}
	
	public String showList() throws Exception {
		if (!checkedLogin()) {
			return "login";
		}
		doohickeyService.forward(model);
		return SUCCESS;
	}
	
	public String save() throws Exception {
		if (!checkedLogin()) {
			return "login";
		}
		doohickeyService.save(model);
		return SUCCESS;
	}

	public DoohickeyData getModel() {
		return model;
	}

	public void setDoohickeyService(DoohickeyService doohickeyService) {
		this.doohickeyService = doohickeyService;
	}
}
