package org.auction.module.admin.commodity.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.auction.entity.TsImages;
import org.auction.entity.TsPublis;
import org.auction.module.admin.commodity.data.PublisData;
import org.auction.module.admin.commodity.service.PublisService;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.manager.GeneralManager;
import org.mobile.common.service.GeneralService;
import org.mobile.common.util.BeanProcessUtils;
import org.mobile.common.util.FileUpload;
import org.mobile.common.util.UUIDFactory;

public class PublisServiceImpl extends GeneralService implements PublisService {

	public void delete(PublisData model) throws Exception {
		String hql = "delete from TsPublis where id in (:ids)";
		if (model.getIds() != null) {
			generalDao.executeHql(hql, "ids", model.getIds());
		}
	}

	public void edit(PublisData model) throws Exception {
		TsPublis tsCommodity = new TsPublis();
		BeanProcessUtils.copyProperties(tsCommodity, model);
		boolean isSave = false;
		if (model.getId() != null && !model.getId().equals("")) {
			generalDao.update(tsCommodity);
		} else {
			isSave = true;
			generalDao.save(tsCommodity);
		}
		// 保存图片
		if (model.getFiles() != null) {
			for (int i = 0; i < model.getFiles().length; i++) {
				TsImages tsImages = new TsImages();
				tsImages.setImageid(tsCommodity.getId());
				GeneralManager manager = GeneralManager.getCurrentManager();
				String targetDir = manager
						.getImageDir(GeneralManager.UPLOAD_IMAGE);
				File file = new File(targetDir, UUIDFactory.createUUID()
						+ model.getFilesFileName()[i].substring(model
								.getFilesFileName()[i].lastIndexOf("."), model
								.getFilesFileName()[i].length()));
				FileUpload.upload(model.getFiles()[i], file);
				tsImages.setFilepath(file.getAbsolutePath());
				tsImages.setTablename("TS_PUBLIS");
				if (!isSave) {
					// 更新删除以前图片
					String hql = "delete from TsImages where tablename='TS_PUBLIS' and imageid='"
							+ tsCommodity.getId() + "'";
					generalDao.executeHql(hql);
				}
				generalDao.save(tsImages);
			}
		}
	}

	public void forward(PublisData model) throws Exception {
		if (model.getId() != null && !model.getId().equals("")) {
			TsPublis tsCommodity = (TsPublis) generalDao.get(TsPublis.class,
					model.getId());
			BeanProcessUtils.copyProperties(model, tsCommodity);
		}
	}

	@SuppressWarnings("unchecked")
	public void search(PublisData model) throws Exception {
		List<SearchBean> search = new ArrayList<SearchBean>();
		List list = generalDao.search(TsPublis.class, search, model
				.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsPublis tsCommodity = (TsPublis) list.get(i);
			PublisData data = new PublisData();
			BeanProcessUtils.copyProperties(data, tsCommodity);
			model.getDataList().add(data);
		}
	}

	public boolean vote(PublisData model) throws Exception {
		TsPublis tsCommodity = (TsPublis) generalDao.get(TsPublis.class,
				model.getId());
		tsCommodity.setAmount(tsCommodity.getAmount() + 1);
		generalDao.update(tsCommodity);
		model.setAmount(tsCommodity.getAmount());
		return true;
	}

}
