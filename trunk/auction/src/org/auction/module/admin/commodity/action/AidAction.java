package org.auction.module.admin.commodity.action;

import org.auction.module.admin.commodity.data.AidData;
import org.auction.module.admin.commodity.service.AidService;
import org.mobile.common.action.GeneralAction;

public class AidAction extends GeneralAction<AidData> {

	private static final long serialVersionUID = 1L;
	
	private AidData model = new AidData();
	
	private AidService aidService;

	/**
	 * 用户设置竞拍助理列表
	 * @return
	 * @throws Exception
	 */
	public String search() throws Exception {
		if (!checkedLogin()) {
			return "login";
		}
		this.setPage(model);
		aidService.searchList(model);
		return SUCCESS;
	}
	
	public AidData getModel() {
		return model;
	}

	/**
	 * @param aidService the aidService to set
	 */
	public void setAidService(AidService aidService) {
		this.aidService = aidService;
	}

}
