package org.auction.module.admin.base.action;

import org.auction.module.admin.base.data.WebsiteInfoData; 
import org.auction.module.admin.base.service.WebsiteBaseInfoService;
import org.mobile.common.action.GeneralAction;
import org.mobile.common.exception.GeneralException;

public class WebsiteBaseInfoAction  extends GeneralAction<WebsiteInfoData> {

	private static final long serialVersionUID = 1L;

	private WebsiteInfoData model = new WebsiteInfoData();

	private WebsiteBaseInfoService webServices;
	
	public WebsiteInfoData getModel() {
		
		return model;
	}
	
	/**
	 * 检索
	 * @return
	 * @throws GeneralException
	 */
	public String searchInfoData() throws GeneralException{
		model = webServices.searchInfoData();
		return SUCCESS;
	}
	
	public String save() throws GeneralException{
		webServices.save(model);
		return SUCCESS;
	}
	
	
	
//	public String modify() throws GeneralException{
//		webService.modify(model);
//		return SUCCESS;
//	}

	

	public void setModel(WebsiteInfoData model) {
		this.model = model;
	}

	public WebsiteBaseInfoService getWebServices() {
		return webServices;
	}

	public void setWebServices(WebsiteBaseInfoService webServices) {
		this.webServices = webServices;
	}
	

//	public String delete() throws GeneralException {
//		infoService.delete(model);
//		if (model.getNettype().equals("1")) {
//			return "web";
//		} else if (model.getNettype().equals("2")) {
//			return "join";
//		} else if (model.getNettype().equals("4")) {
//			return "reg";
//		} else if (model.getNettype().equals("3")) {
//			return "help";
//		} else if (model.getNettype().equals("5")) {
//			return "post";
//		}
//		return SUCCESS;
//	}

//	public String search() throws GeneralException {
//		setPage(model);
//		infoService.search(model);
//		if (model.getNettype().equals("3")) {
//			return "help";
//		} else if (model.getNettype().equals("5")) {
//			return "post";
//		} 
//		return SUCCESS;
//	}
//
//	public String forwardInfo() throws GeneralException {
//		infoService.forwardInfo(model);
//		if (model.getNettype().equals("1")) {
//			return "web";
//		} else if (model.getNettype().equals("2")) {
//			return "join";
//		} else if (model.getNettype().equals("4")) {
//			return "reg";
//		} else if (model.getNettype().equals("3")) {
//			return "help";
//		} else if (model.getNettype().equals("5")) {
//			return "post";
//		}
//		return SUCCESS;
//	}
//
//	public String saveInfo() throws GeneralException {
//		infoService.saveInfo(model);
//		if (model.getNettype().equals("1")) {
//			return "web";
//		} else if (model.getNettype().equals("2")) {
//			return "join";
//		} else if (model.getNettype().equals("4")) {
//			return "reg";
//		} else if (model.getNettype().equals("3")) {
//			return "help";
//		} else if (model.getNettype().equals("5")) {
//			return "post";
//		}
//		return SUCCESS;
//	}
//
}
