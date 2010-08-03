package org.auction.module.admin.base.action;

import org.auction.module.admin.base.data.ManagerData;
import org.auction.module.admin.base.service.ManagerService;
import org.mobile.common.action.GeneralAction;
import org.mobile.common.exception.GeneralException;

public class ManagerAction extends GeneralAction<ManagerData> {

	private static final long serialVersionUID = 1L;

	private ManagerData model = new ManagerData();

	private ManagerService managerService;

	public String delete() throws GeneralException {
		managerService.delete(model);
		return SUCCESS;
	}

	public String search() throws GeneralException {
		setPage(model);
		managerService.search(model);
		return SUCCESS;
	}

	public String forwardInfo() throws GeneralException {
		managerService.forwardInfo(model);
		return SUCCESS;
	}

	public String saveInfo() throws GeneralException {
		managerService.saveInfo(model);
		return SUCCESS;
	}

	public ManagerData getModel() {
		return model;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

}
