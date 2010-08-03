package org.auction.module.admin.base.action;

import org.auction.module.admin.base.data.NetWorkData;
import org.auction.module.admin.base.service.NetWordService;
import org.mobile.common.action.GeneralAction;
import org.mobile.common.exception.GeneralException;

public class NetWorkAction extends GeneralAction<NetWorkData> {

	private static final long serialVersionUID = 1L;

	private NetWorkData model = new NetWorkData();

	private NetWordService netWordService;

	/**
	 * 网站基本信息表单界面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String forwardInfo() throws GeneralException {
		netWordService.forwardInfo(model);
		return SUCCESS;
	}

	/**
	 * 保存网站基本信息内容
	 * 
	 * @return
	 * @throws GeneralException
	 */
	public String saveInfo() throws GeneralException {
		netWordService.saveInfo(model);
		return SUCCESS;
	}

	public NetWorkData getModel() {
		return model;
	}

	public void setNetWordService(NetWordService netWordService) {
		this.netWordService = netWordService;
	}

}
