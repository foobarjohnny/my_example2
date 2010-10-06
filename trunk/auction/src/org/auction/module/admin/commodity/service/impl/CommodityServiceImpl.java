package org.auction.module.admin.commodity.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.auction.entity.TsBidding;
import org.auction.entity.TsBingcur;
import org.auction.entity.TsCommodity;
import org.auction.entity.TsImages;
import org.auction.entity.TsSort;
import org.auction.entity.TsUser;
import org.auction.module.admin.commodity.data.CommodityData;
import org.auction.module.admin.commodity.data.SortData;
import org.auction.module.admin.commodity.service.CommodityService;
import org.auction.module.manager.TradeManager;
import org.auction.module.manager.data.TradeData;
import org.mobile.common.bean.OrderByBean;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.manager.GeneralManager;
import org.mobile.common.service.GeneralService;
import org.mobile.common.util.BeanProcessUtils;
import org.mobile.common.util.Constant;
import org.mobile.common.util.FileUpload;
import org.mobile.common.util.UUIDFactory;
import org.mobile.common.util.Constant.COMMODITY_STATE;

public class CommodityServiceImpl extends GeneralService implements CommodityService {

	public void delete(CommodityData model) throws GeneralException {
		TsCommodity tsCommodity = (TsCommodity) generalDao.get(TsCommodity.class, model.getId());
		if (tsCommodity.getState() == null || tsCommodity.getState().equals("4") || tsCommodity.getState().equals("2") || tsCommodity.getState().equals("")) {
			generalDao.delete(tsCommodity);
		} else if (tsCommodity.getState().equals("3")) {
			tsCommodity.setDeleteif("1");
		}
	}

	@SuppressWarnings("unchecked")
	public void forward(CommodityData model) throws GeneralException {
		if (model.getId() != null && !model.getId().equals("")) {
			TsCommodity tsCommodity = (TsCommodity) generalDao.get(TsCommodity.class, model.getId());
			model.setSortId(tsCommodity.getTsSort().getId());
			BeanProcessUtils.copyProperties(model, tsCommodity);
		}
		List<SearchBean> search = new ArrayList<SearchBean>();
		SearchBean bean = new SearchBean();
		bean.setDisplayName("isValid");
		bean.setFieldName("isValid");
		bean.setSignl(Constant.EQ);
		bean.setValue(Constant.YES);
		bean.setType("java.lang.String");
		search.add(bean);
		List list = generalDao.search(TsSort.class, search, null, null);
		for (int i = 0; i < list.size(); i++) {
			TsSort tsSort = (TsSort) list.get(i);
			SortData data = new SortData();
			BeanProcessUtils.copyProperties(data, tsSort);
			model.getSortList().add(data);
		}
	}

	/**
	 * 后台添加产品
	 */
	public void save(CommodityData model) throws GeneralException {
		TsCommodity tsCommodity = new TsCommodity();
		BeanProcessUtils.copyProperties(tsCommodity, model);
		TsSort tsSort = (TsSort) generalDao.get(TsSort.class, model.getSortId());
		tsCommodity.setTsSort(tsSort);
		// 设置结束时间
		Calendar cal = Calendar.getInstance();
		cal.setTime(tsCommodity.getStarttime());
		cal.add(Calendar.HOUR_OF_DAY, tsCommodity.getEndtime());
		tsCommodity.setOvertime(cal.getTime());
		boolean isSave = false;
		// 是更新还是保存
		if (model.getId() != null && !model.getId().equals("")) {
			generalDao.update(tsCommodity);
		} else {
			// 状态4，新增产品
			tsCommodity.setState(COMMODITY_STATE.UNKNOWN_STATE);
			isSave = true;
			generalDao.save(tsCommodity);
		}

		// 保存图片
		if (model.getUpload() != null) {
			if (!isSave) {
				// 更新删除以前图片
				String hql = "delete from TsImages where tablename='TS_COMMODITY' and imageid='" + tsCommodity.getId() + "'";
				generalDao.executeHql(hql);
			}
			// 生成图片文件夹
			GeneralManager manager = GeneralManager.getCurrentManager();
			String targetDir = manager.getImageDir(GeneralManager.UPLOAD_IMAGE);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String dataPath = (format.format(new Date())).replaceAll("-", "");
			String path = targetDir + "//" + dataPath;
			for (int i = 0; i < model.getUpload().length; i++) {
				TsImages tsImages = new TsImages();
				tsImages.setImageid(tsCommodity.getId());
				// 图片文件名称
				String fileName = UUIDFactory.createUUID() + model.getUploadFileName()[i].substring(model.getUploadFileName()[i].lastIndexOf("."), model.getUploadFileName()[i].length());
				File file = new File(path, fileName);
				// 上传图片
				FileUpload.upload(model.getUpload()[i], file);
				tsImages.setFilepath(GeneralManager.UPLOAD_IMAGE_OTHER + "/" + dataPath + "/" + fileName);
				tsImages.setTablename("TS_COMMODITY");
				generalDao.save(tsImages);
			}
		}
	}

	/**
	 * 显示所有商品
	 */
	@SuppressWarnings("unchecked")
	public void search(CommodityData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		List list = generalDao.search(TsCommodity.class, search, model.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsCommodity tsCommodity = (TsCommodity) list.get(i);
			CommodityData data = new CommodityData();
			data.setSortName(tsCommodity.getTsSort().getSortname());
			BeanProcessUtils.copyProperties(data, tsCommodity);

			// 获得商品的图片
			data.setImagesPath(generalDao.searchImages(tsCommodity.getId(), Constant.TRADE_IMAGES));
			model.getDataList().add(data);
		}
	}

	/**
	 * 查询流拍的商品
	 */
	@SuppressWarnings("unchecked")
	public void searchLot(CommodityData model) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("state", "eq", "string", "2"));
		List list = generalDao.search(TsCommodity.class, search, model.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsCommodity tsCommodity = (TsCommodity) list.get(i);
			CommodityData data = new CommodityData();
			data.setSortName(tsCommodity.getTsSort().getSortname());
			BeanProcessUtils.copyProperties(data, tsCommodity);
			
			// 获得商品的图片
			data.setImagesPath(generalDao.searchImages(tsCommodity.getId(), Constant.TRADE_IMAGES));
			model.getDataList().add(data);
		}
	}

	/**
	 * 查询正在竞拍的产品
	 */
	@SuppressWarnings("unchecked")
	public void searchProgress(CommodityData model) throws GeneralException {
		// 查询正在竞拍商品
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("state", "eq", "string", "1"));
		List list = generalDao.search(TsCommodity.class, search, model.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsCommodity tsCommodity = (TsCommodity) list.get(i);
			Long time = (tsCommodity.getOvertime().getTime() - new Date().getTime()) / (1000 * 60);
			CommodityData data = new CommodityData();
			data.setSortName(tsCommodity.getTsSort().getSortname());
			BeanProcessUtils.copyProperties(data, tsCommodity);
			data.setTime(time);
			// 根据商品ID查询现在最高出价人
			search = new ArrayList<SearchBean>();
			search.add(new SearchBean("tsCommodity.id", "eq", "string", tsCommodity.getId()));
			List<OrderByBean> obs = new ArrayList<OrderByBean>();
			obs.add(new OrderByBean("", "price", "desc"));
			List b_list = generalDao.search(TsBidding.class, search, null, obs);
			if (b_list != null && b_list.size() > 0) {
				TsBidding tsBidding = (TsBidding) b_list.get(0);
				data.setUsername(tsBidding.getTsUser().getUsername());
				data.setBidPrice(tsBidding.getPrice());
			} else {
				data.setBidPrice(tsCommodity.getMarketPrice());
			}
			
			// 获得商品的图片
			data.setImagesPath(generalDao.searchImages(tsCommodity.getId(), Constant.TRADE_IMAGES));
			model.getDataList().add(data);
		}
	}

	/**
	 * 查询成交的商品
	 */
	@SuppressWarnings("unchecked")
	public void searchReach(CommodityData model) throws GeneralException {
		// 查询成交的商品
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("state", "eq", "string", "3"));
		List list = generalDao.search(TsCommodity.class, search, model.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsCommodity tsCommodity = (TsCommodity) list.get(i);
			CommodityData data = new CommodityData();
			data.setSortName(tsCommodity.getTsSort().getSortname());
			BeanProcessUtils.copyProperties(data, tsCommodity);
			// 查询该商品成交用户
			search = new ArrayList<SearchBean>();
			search.add(new SearchBean("tsCommodity.id", "eq", "string", tsCommodity.getId()));
			List bing_list = generalDao.search(TsBingcur.class, search, null, null);
			if (bing_list != null && bing_list.size() > 0) {
				TsBingcur tsBingcur = (TsBingcur) bing_list.get(0);
				data.setUsername(tsBingcur.getTsUser().getUsername());
				data.setBidPrice(tsBingcur.getPrice());
				data.setOvertime(tsBingcur.getBinddate());
			}
			
			// 获得商品的图片
			data.setImagesPath(generalDao.searchImages(tsCommodity.getId(), Constant.TRADE_IMAGES));
			model.getDataList().add(data);
		}
	}

	@SuppressWarnings("unchecked")
	public void getReach(CommodityData model) throws GeneralException {
		TsCommodity tsCommodity = (TsCommodity) generalDao.get(TsCommodity.class, model.getId());
		BeanProcessUtils.copyProperties(model, tsCommodity);
		List<SearchBean> search = new ArrayList<SearchBean>();
		search.add(new SearchBean("tsCommodity.id", "eq", "string", tsCommodity.getId()));
		List bing_list = generalDao.search(TsBingcur.class, search, null, null);
		if (bing_list != null && bing_list.size() > 0) {
			TsBingcur tsBingcur = (TsBingcur) bing_list.get(0);
			model.setUsername(tsBingcur.getTsUser().getUsername());
			model.setBidPrice(tsBingcur.getPrice());
			model.setOvertime(tsBingcur.getBinddate());
			model.setBidId(tsBingcur.getId());
		}

		// 统计参与竞拍人数
		String hql = "select count(distinct t.tsUser.id) from TsBidding t where t.tsCommodity.id='" + tsCommodity.getId() + "'";
		Object count = generalDao.executeQuery(hql);
		model.setCount(Integer.parseInt(String.valueOf(count)));
		// 获得付费E拍币数量
		String p_hql = "select count(t.id) from TsBidding t where t.tsCommodity.id='" + tsCommodity.getId() + "' and t.bidtype='2'";
		Object pcount = generalDao.executeQuery(p_hql);
		model.setPcount(Integer.parseInt(String.valueOf(pcount)) * tsCommodity.getConsume().intValue());
		// 免费E拍币数量
		String f_hql = "select count(t.id) from TsBidding t where t.tsCommodity.id='" + tsCommodity.getId() + "' and t.bidtype='3'";
		Object fcount = generalDao.executeQuery(f_hql);
		model.setFcount(Integer.parseInt(String.valueOf(fcount)) * tsCommodity.getConsume().intValue());
	}

	/**
	 * 商品竞拍历史
	 */
	@SuppressWarnings("unchecked")
	public void getReachView(CommodityData model) throws GeneralException {
		String hql = "select count(t.id), t.tsUser from TsBidding t where t.tsCommodity.id='" + model.getId() + "' group by t.tsUser";
		List list = generalDao.executeQueryList(hql);
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			CommodityData data = new CommodityData();
			data.setCount(Integer.parseInt(String.valueOf(obj[0])));
			TsUser user = (TsUser) obj[1];
			data.setUsername(user.getUsername());
			model.getDataList().add(data);
		}
	}

	/**
	 * 商品上架竞拍
	 */
	public void auction(CommodityData model) throws GeneralException {
		// 获得要上架的商品
		TsCommodity tsCommodity = (TsCommodity) generalDao.get(TsCommodity.class, model.getId());
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
