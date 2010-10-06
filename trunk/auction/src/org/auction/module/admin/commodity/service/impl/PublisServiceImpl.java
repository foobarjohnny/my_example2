package org.auction.module.admin.commodity.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

	/**
	 * 后台酷品发布
	 */
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

			// 更新删除以前图片
			if (!isSave) {
				String hql = "delete from TsImages where tablename='TS_PUBLIS' and imageid='" + tsCommodity.getId() + "'";
				generalDao.executeHql(hql);
			}

			// 生成图片文件夹
			GeneralManager manager = GeneralManager.getCurrentManager();
			String targetDir = manager.getImageDir(GeneralManager.UPLOAD_IMAGE);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String dataPath = (format.format(new Date())).replaceAll("-", "");
			String path = targetDir + "//" + dataPath;
			for (int i = 0; i < model.getFiles().length; i++) {
				TsImages tsImages = new TsImages();
				tsImages.setImageid(tsCommodity.getId());
				// 图片文件名称
				String fileName = UUIDFactory.createUUID() + model.getFilesFileName()[i].substring(model.getFilesFileName()[i].lastIndexOf("."), model.getFilesFileName()[i].length());
				File file = new File(path, fileName);
				// 上传图片
				FileUpload.upload(model.getFiles()[i], file);
				tsImages.setFilepath(GeneralManager.UPLOAD_IMAGE_OTHER + "/" + dataPath + "/" + fileName);
				tsImages.setTablename("TS_PUBLIS");
				generalDao.save(tsImages);
			}
			//			
			// for (int i = 0; i < model.getFiles().length; i++) {
			//				
			// TsImages tsImages = new TsImages();
			// tsImages.setImageid(tsCommodity.getId());
			// GeneralManager manager = GeneralManager.getCurrentManager();
			// String targetDir =
			// manager.getImageDir(GeneralManager.UPLOAD_IMAGE);
			// File file = new File(targetDir, UUIDFactory.createUUID() +
			// model.getFilesFileName()[i].substring(model.getFilesFileName()[i].lastIndexOf("."),
			// model.getFilesFileName()[i].length()));
			// FileUpload.upload(model.getFiles()[i], file);
			// tsImages.setFilepath(file.getAbsolutePath());
			// tsImages.setTablename("TS_PUBLIS");
			// generalDao.save(tsImages);
			// }
		}
	}

	/**
	 * 显示酷品详细信息
	 */
	public void forward(PublisData model) throws Exception {
		if (model.getId() != null && !model.getId().equals("")) {
			TsPublis tsCommodity = (TsPublis) generalDao.get(TsPublis.class, model.getId());
			BeanProcessUtils.copyProperties(model, tsCommodity);
			// 查询图片
			model.setImagesPath(generalDao.searchImages(tsCommodity.getId(), "TS_PUBLIS"));
			// List<SearchBean> sb = new ArrayList<SearchBean>();
			// sb.add(new SearchBean("imageid", "eq", "string",
			// tsCommodity.getId()));
			// sb.add(new SearchBean("tablename", "eq", "string", "TS_PUBLIS"));
			// List list = generalDao.search(TsImages.class, sb, null, null);
			//
			// if (list != null && list.size() > 0) {
			// String[] ids = new String[list.size()];
			// for (int i = 0; i < list.size(); i++) {
			// TsImages image = (TsImages) list.get(i);
			// ids[i] = image.getId();
			// }
			// model.setIds(ids);
			// }
		}
	}

	/**
	 * 酷品显示
	 */
	@SuppressWarnings("unchecked")
	public void search(PublisData model) throws Exception {
		List<SearchBean> search = new ArrayList<SearchBean>();
		List list = generalDao.search(TsPublis.class, search, model.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsPublis tsCommodity = (TsPublis) list.get(i);
			PublisData data = new PublisData();
			BeanProcessUtils.copyProperties(data, tsCommodity);
			// 设置酷品图片
			data.setImagesPath(generalDao.searchImages(tsCommodity.getId(), "TS_PUBLIS"));
			model.getDataList().add(data);
		}
	}

	public boolean vote(PublisData model) throws Exception {
		TsPublis tsCommodity = (TsPublis) generalDao.get(TsPublis.class, model.getId());
		tsCommodity.setAmount(tsCommodity.getAmount() + 1);
		generalDao.update(tsCommodity);
		model.setAmount(tsCommodity.getAmount());
		return true;
	}

}
