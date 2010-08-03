package org.auction.module.admin.base.service.impl;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.auction.entity.TsNetwork;
import org.auction.module.admin.base.data.NetWorkData;
import org.auction.module.admin.base.service.NetWordService;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.service.GeneralService;
import org.mobile.common.util.BeanProcessUtils;
import org.mobile.common.util.FileUpload;

public class NetWordServiceImpl extends GeneralService implements
		NetWordService {

	@SuppressWarnings("unchecked")
	public void forwardInfo(NetWorkData model) throws GeneralException {
		List list = generalDao.search(TsNetwork.class, null, null, null);
		if (list != null && list.size() > 0) {
			TsNetwork tsNetwork = (TsNetwork) list.get(0);
			BeanProcessUtils.copyProperties(model, tsNetwork);
			model.setFiles(tsNetwork.getLogo());
		}
	}

	public void saveInfo(NetWorkData model) throws GeneralException {
		TsNetwork tsNetwork = new TsNetwork();
		BeanProcessUtils.copyProperties(tsNetwork, model);
		// 上传图片处理
		if (model.getLogoFile() != null) {
			String targetDir = ServletActionContext.getServletContext()
					.getRealPath("/images");
			File file = new File(targetDir, "logo.jpg");
			FileUpload.upload(model.getLogoFile(), file);
			tsNetwork.setLogo(file.getAbsolutePath());
		}
		if (model.getId() != null && !model.getId().equals("")) {
			generalDao.update(tsNetwork);
		} else {
			generalDao.save(tsNetwork);
		}
	}
}
