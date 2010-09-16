package org.auction.module.admin.base.service.impl;

import java.io.File;
import java.util.List;

import org.auction.entity.TsNetwork;
import org.auction.module.admin.base.data.WebsiteInfoData;
import org.auction.module.admin.base.service.WebsiteBaseInfoService;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.manager.GeneralManager;
import org.mobile.common.service.GeneralService;
import org.mobile.common.util.BeanProcessUtils;
import org.mobile.common.util.FileUpload;

public class WebsiteBaseInfoServiceImpl extends GeneralService implements
		WebsiteBaseInfoService {

	@SuppressWarnings("unchecked")
	public WebsiteInfoData searchInfoData() throws GeneralException {
		List list = generalDao.search(TsNetwork.class, null, null, null);
		WebsiteInfoData model = new WebsiteInfoData();
		if (list != null && list.size() > 0) {
			TsNetwork tsNetwork = (TsNetwork) list.get(0);
			BeanProcessUtils.copyProperties(model, tsNetwork);
			model.setFiles(tsNetwork.getLogo());
		}
		return model;
	}

	@SuppressWarnings("unchecked")
	public void modify(WebsiteInfoData model) throws GeneralException {
		System.out.println("service begin");
		List list = generalDao.search(TsNetwork.class, null, null, null);
		if (list != null && list.size() > 0) {
			TsNetwork tsNetwork = (TsNetwork) list.get(0);
			BeanProcessUtils.copyProperties(model, tsNetwork);
			model.setFiles(tsNetwork.getLogo());
		}
		System.out.println("service end");
	}

	public void save(WebsiteInfoData model) throws GeneralException {
		TsNetwork tsNetwork = new TsNetwork();
		BeanProcessUtils.copyProperties(tsNetwork, model);
		// 上传图片处理
		if (model.getLogoFile() != null) {
			GeneralManager manager = GeneralManager.getCurrentManager();
			String targetDir = manager.getImageDir(GeneralManager.IMAGE);
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