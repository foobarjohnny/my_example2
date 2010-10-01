package org.auction.module.admin.base.action;

import org.auction.module.admin.base.data.InfoData;
import org.auction.module.admin.base.service.InfoService;
import org.mobile.common.action.GeneralAction;
import org.mobile.common.exception.GeneralException;

public class InfoAction extends GeneralAction<InfoData> {

	private static final long serialVersionUID = 1L;

	private InfoData model = new InfoData();

	private InfoService infoService;

	public String delete() throws GeneralException {
		infoService.delete(model);
		if (model.getNettype().equals("1")) {
			return "web";
		} else if (model.getNettype().equals("2")) {
			return "join";
		} else if (model.getNettype().equals("4")) {
			return "reg";
		} else if (model.getNettype().equals("3")) {
			return "help";
		} else if (model.getNettype().equals("5")) {
			return "post";
		}
		return SUCCESS;
	}

	public String search() throws GeneralException {
		setPage(model);
		infoService.search(model);
		if (model.getNettype().equals("3")) {
			return "help";
		} else if (model.getNettype().equals("5")) {
			return "post";
		}
		return SUCCESS;
	}

	public String forwardInfo() throws GeneralException {
		infoService.forwardInfo(model);
		if (model.getNettype().equals("1")) {
			return "web";
		} else if (model.getNettype().equals("2")) {
			return "join";
		} else if (model.getNettype().equals("4")) {
			return "reg";
		} else if (model.getNettype().equals("3")) {
			return "help";
		} else if (model.getNettype().equals("5")) {
			return "post";
		}
		return SUCCESS;
	}

	public String saveInfo() throws GeneralException {
		try {
			infoService.saveInfo(model);
			if (model.getNettype().equals("1")) {
				return "web";
			} else if (model.getNettype().equals("2")) {
				return "join";
			} else if (model.getNettype().equals("4")) {
				return "reg";
			} else if (model.getNettype().equals("3")) {
				return "help";
			} else if (model.getNettype().equals("5")) {
				return "post";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String viewInfo() throws GeneralException {
		infoService.forwardInfo(model);
		if (model.getNettype().equals("5")) {
			return "post";
		} else if (model.getNettype().equals("3")) {
			return "help";
		} else {
			return SUCCESS;
		}
	}

	public String viewInfoList() throws GeneralException {
		setPage(model);
		model.getPageBean().setPageRec(30);
		infoService.search(model);
		if (model.getNettype().equals("5")) {
			return "post";
		} else if (model.getNettype().equals("3")) {
			return "help";
		} else {
			return SUCCESS;
		}
	}

	public InfoData getModel() {
		return model;
	}

	public void setInfoService(InfoService infoService) {
		this.infoService = infoService;
	}

}
