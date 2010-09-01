package org.auction.module.admin.commodity.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.auction.entity.TsCommodity;
import org.auction.entity.TsImages;
import org.auction.entity.TsSort;
import org.auction.module.admin.commodity.data.CommodityData;
import org.auction.module.admin.commodity.data.SortData;
import org.auction.module.admin.commodity.service.CommodityService;
import org.auction.module.manager.TradeManager;
import org.auction.module.manager.data.TradeData;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.manager.GeneralManager;
import org.mobile.common.service.GeneralService;
import org.mobile.common.util.BeanProcessUtils;
import org.mobile.common.util.FileUpload;
import org.mobile.common.util.UUIDFactory;

public class CommodityServiceImpl extends GeneralService implements
		CommodityService {

	public void delete(CommodityData model) throws GeneralException {
		TsCommodity tsCommodity = (TsCommodity) generalDao.get(
				TsCommodity.class, model.getId());
		if (tsCommodity.getState() == null
				|| tsCommodity.getState().equals("4")
				|| tsCommodity.getState().equals("2")
				|| tsCommodity.getState().equals("")) {
			generalDao.delete(tsCommodity);
		} else if (tsCommodity.getState().equals("3")) {
			tsCommodity.setDeleteif("1");
		}
	}

	@SuppressWarnings("unchecked")
	public void forward(CommodityData model) throws GeneralException {
		if (model.getId() != null && !model.getId().equals("")) {
			TsCommodity tsCommodity = (TsCommodity) generalDao.get(
					TsCommodity.class, model.getId());
			model.setSortId(tsCommodity.getTsSort().getId());
			BeanProcessUtils.copyProperties(model, tsCommodity);
		}
		List list = generalDao.search(TsSort.class, null, null, null);
		for (int i = 0; i < list.size(); i++) {
			TsSort tsSort = (TsSort) list.get(i);
			SortData data = new SortData();
			BeanProcessUtils.copyProperties(data, tsSort);
			model.getSortList().add(data);
		}
	}

	public void save(CommodityData model) throws GeneralException {
		TsCommodity tsCommodity = new TsCommodity();
		BeanProcessUtils.copyProperties(tsCommodity, model);
		TsSort tsSort = (TsSort) generalDao
				.get(TsSort.class, model.getSortId());
		tsCommodity.setTsSort(tsSort);
		Calendar cal = Calendar.getInstance();
		cal.setTime(tsCommodity.getStarttime());
		cal.add(Calendar.HOUR_OF_DAY, tsCommodity.getEndtime());
		tsCommodity.setOvertime(cal.getTime());
		boolean isSave = false;
		if (model.getId() != null && !model.getId().equals("")) {
			generalDao.update(tsCommodity);
		} else {
			tsCommodity.setState("4");
			isSave = true;
			generalDao.save(tsCommodity);
		}
		// 保存图片
		if (model.getUpload() != null) {
			TsImages tsImages = new TsImages();
			tsImages.setImageid(tsCommodity.getId());
			GeneralManager manager = GeneralManager.getCurrentManager();
			String targetDir = manager.getImageDir(GeneralManager.UPLOAD_IMAGE);
			File file = new File(targetDir, UUIDFactory.createUUID()
					+ model.getUploadFileName().substring(
							model.getUploadFileName().lastIndexOf("."),
							model.getUploadFileName().length()));
			FileUpload.upload(model.getUpload(), file);
			tsImages.setFilepath(file.getAbsolutePath());
			tsImages.setTablename("TS_COMMODITY");
			if (!isSave) {
				// 更新删除以前图片
				String hql = "delete from TsImages where tablename='TS_COMMODITY' and imageid='"
						+ tsCommodity.getId() + "'";
				generalDao.executeHql(hql);
			}
			generalDao.save(tsImages);
		}
	}

	@SuppressWarnings("unchecked")
	public void search(CommodityData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		List list = generalDao.search(TsCommodity.class, search, model
				.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsCommodity tsCommodity = (TsCommodity) list.get(i);
			CommodityData data = new CommodityData();
			data.setSortName(tsCommodity.getTsSort().getSortname());
			BeanProcessUtils.copyProperties(data, tsCommodity);
			model.getDataList().add(data);
		}
	}

	@SuppressWarnings("unchecked")
	public void searchLot(CommodityData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("state", "eq", "string", "2"));
		List list = generalDao.search(TsCommodity.class, search, model
				.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsCommodity tsCommodity = (TsCommodity) list.get(i);
			CommodityData data = new CommodityData();
			data.setSortName(tsCommodity.getTsSort().getSortname());
			BeanProcessUtils.copyProperties(data, tsCommodity);
			model.getDataList().add(data);
		}
	}

	@SuppressWarnings("unchecked")
	public void searchProgress(CommodityData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("state", "eq", "string", "1"));
		List list = generalDao.search(TsCommodity.class, search, model
				.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsCommodity tsCommodity = (TsCommodity) list.get(i);
			CommodityData data = new CommodityData();
			data.setSortName(tsCommodity.getTsSort().getSortname());
			BeanProcessUtils.copyProperties(data, tsCommodity);
			model.getDataList().add(data);
		}
	}

	@SuppressWarnings("unchecked")
	public void searchReach(CommodityData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("state", "eq", "string", "3"));
		List list = generalDao.search(TsCommodity.class, search, model
				.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsCommodity tsCommodity = (TsCommodity) list.get(i);
			CommodityData data = new CommodityData();
			data.setSortName(tsCommodity.getTsSort().getSortname());
			BeanProcessUtils.copyProperties(data, tsCommodity);
			model.getDataList().add(data);
		}
	}

	/**
	 * 商品上架竞拍
	 */
	public void auction(CommodityData model) throws GeneralException {
		// 获得要上架的商品
		TsCommodity tsCommodity = (TsCommodity) generalDao.get(
				TsCommodity.class, model.getId());
		tsCommodity.setState("1");
		tsCommodity.setStarttime(new Date());
		Calendar cal = Calendar.getInstance();
		cal.setTime(tsCommodity.getStarttime());
		cal.add(Calendar.HOUR_OF_DAY, tsCommodity.getEndtime());
		tsCommodity.setOvertime(cal.getTime());
		generalDao.update(tsCommodity);
		// 将商品加入竞拍列表
		TradeData tradeData = new TradeData();
		BeanProcessUtils.copyProperties(tradeData, tsCommodity);
		TradeManager.add(tradeData);
	}

	@SuppressWarnings("unchecked")
	public void select(CommodityData model) throws GeneralException {
		List list = generalDao.select();
		for (int i = 0; i < list.size(); i++) {
			TsCommodity tsCommodity = (TsCommodity) list.get(i);
			CommodityData data = new CommodityData();
			data.setSortName(tsCommodity.getTsSort().getSortname());
			BeanProcessUtils.copyProperties(data, tsCommodity);
			model.getDataList().add(data);
		}
	}
}
