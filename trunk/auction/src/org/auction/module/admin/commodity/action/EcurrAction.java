package org.auction.module.admin.commodity.action;

import org.auction.module.admin.commodity.data.EcurrData;
import org.auction.module.admin.commodity.service.EcurrService;
import org.mobile.common.action.GeneralAction;
import org.mobile.common.exception.GeneralException;

public class EcurrAction extends GeneralAction<EcurrData> {

	private static final long serialVersionUID = 1L;

	private EcurrData model = new EcurrData();

	private EcurrService ecurrService;
	
	private String url;

	public String forward() throws GeneralException {
		ecurrService.forward(model);
		return SUCCESS;
	}

	public String save() throws GeneralException {
		ecurrService.save(model);
		return SUCCESS;
	}

	public String delete() throws GeneralException {
		ecurrService.delete(model);
		return SUCCESS;
	}

	public String search() throws GeneralException {
		this.setPage(model);
		ecurrService.search(model);
		return SUCCESS;
	}
	
	public String showEcurr() throws GeneralException {
		ecurrService.search(model);
		return SUCCESS;
	}
	
	public String buyEcurr() throws GeneralException {
		isLogin();
		ecurrService.buy(model);
		url = model.getUrl();
		return SUCCESS;
	}

	public EcurrData getModel() {
		return model;
	}

	public void setEcurrService(EcurrService ecurrService) {
		this.ecurrService = ecurrService;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
