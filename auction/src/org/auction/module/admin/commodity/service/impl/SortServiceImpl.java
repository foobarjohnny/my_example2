package org.auction.module.admin.commodity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.auction.entity.TsSort;
import org.auction.module.admin.commodity.data.SortData;
import org.auction.module.admin.commodity.service.SortService;
import org.mobile.common.bean.SearchBean;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.service.GeneralService;
import org.mobile.common.util.BeanProcessUtils;
import org.mobile.common.util.Constant;

public class SortServiceImpl extends GeneralService implements SortService {

	public void delete(SortData model) throws GeneralException {

		// TODO 注释掉了之前的删除操作，修改为update操作，将IS_VALID字段修改为N
		// generalDao.delete(TsSort.class, model.getId());

		// 新添加的， 用来修改状态的。
		TsSort tsSort = getSortByID(model);
		tsSort.setIsValid(Constant.NO);
		generalDao.update(tsSort);
	}

	public void forward(SortData model) throws GeneralException {
		if (model.getId() != null && !model.getId().equals("")) {
			TsSort tsSort = (TsSort) generalDao
					.get(TsSort.class, model.getId());
			BeanProcessUtils.copyProperties(model, tsSort);
		}
	}

	/*
	 * 保存产品分类的操作
	 * 
	 * @see
	 * org.auction.module.admin.commodity.service.SortService#save(org.auction
	 * .module.admin.commodity.data.SortData)
	 */
	public boolean save(SortData model) throws GeneralException {

		// 先按照分类的名称检查是否存在相同名称的分类信息
		TsSort sortTemp = getSortByName(model);
		if (sortTemp.getId() != null) {
			// 说明存在同样名称的产品分类
			return false;
		}

		TsSort tsSort = new TsSort();
		BeanProcessUtils.copyProperties(tsSort, model);
		tsSort.setIsValid(Constant.YES);
		if (model.getId() != null && !model.getId().equals("")) {
			tsSort.setIsValid(Constant.YES);
			generalDao.update(tsSort);
		} else {
			tsSort.setIsValid(Constant.YES);
			generalDao.save(tsSort);
		}

		return true;
	}

	@SuppressWarnings("unchecked")
	public void search(SortData model) throws GeneralException {
		List<SearchBean> search = model.getSearchBeans();
		// TODO添加查询条件按
		SearchBean bean = new SearchBean();
		bean.setDisplayName("isValid");
		bean.setFieldName("isValid");
		bean.setSignl(Constant.EQ);
		bean.setValue(Constant.YES);
		bean.setType("java.lang.String");
		search.add(bean);
		List list = generalDao.search(TsSort.class, search,
				model.getPageBean(), null);
		for (int i = 0; i < list.size(); i++) {
			TsSort tsSort = (TsSort) list.get(i);
			SortData data = new SortData();
			BeanProcessUtils.copyProperties(data, tsSort);
			model.getDataList().add(data);
		}
	}

	// TODO 根据主键获取指定的记录
	public TsSort getSortByID(SortData data) throws GeneralException {
		List<SearchBean> search = new ArrayList<SearchBean>();
		// TODO添加查询条件按
		SearchBean bean = new SearchBean();
		bean.setDisplayName("id");
		bean.setFieldName("id");
		bean.setSignl(Constant.EQ);
		bean.setValue(data.getId());
		bean.setType("java.lang.String");
		search.add(bean);
		List<Object> list = generalDao.search(TsSort.class, search, null, null);
		if (list.size() > 0) {
			return (TsSort) list.get(0);
		} else {
			return new TsSort();
		}
	}

	/**
	 * 根据产品分类的名称检索
	 * 
	 * @param data
	 * @return
	 * @throws GeneralException
	 */
	public TsSort getSortByName(SortData data) throws GeneralException {

		List<SearchBean> search = new ArrayList<SearchBean>();

		SearchBean bean = new SearchBean();
		bean.setDisplayName("sortname");
		bean.setFieldName("sortname");
		bean.setSignl(Constant.EQ);
		bean.setValue(data.getSortname());
		bean.setType("java.lang.String");

		search.add(bean);

		List<Object> list = generalDao.search(TsSort.class, search, null, null);
		if (list.size() > 0) {
			return (TsSort) list.get(0);
		} else {
			return new TsSort();
		}
	}
}
