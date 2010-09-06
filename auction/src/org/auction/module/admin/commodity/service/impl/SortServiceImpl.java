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
		
		//TODO  注释掉了之前的删除操作，修改为update操作，将IS_VALID字段修改为N
		//generalDao.delete(TsSort.class, model.getId());
		
		//新添加的， 用来修改状态的。
		TsSort tsSort = getSortByID(model);
		tsSort.setIsValid(Constant.NO);
		generalDao.update(tsSort);
	}

	public void forward(SortData model) throws GeneralException {
		if (model.getId() != null && !model.getId().equals("")) {
			TsSort tsSort = (TsSort) generalDao.get(TsSort.class,
					model.getId());
			BeanProcessUtils.copyProperties(model, tsSort);
		}
	}

	public void save(SortData model) throws GeneralException {
		TsSort tsSort = new TsSort();
		BeanProcessUtils.copyProperties(tsSort, model);
		if (model.getId() != null && !model.getId().equals("")) {
			tsSort.setIsValid(Constant.YES);
			generalDao.update(tsSort);
		} else {
			tsSort.setIsValid(Constant.YES);
			generalDao.save(tsSort);
		}
	}

	@SuppressWarnings("unchecked")
	public void search(SortData model) throws GeneralException {
		List<SearchBean> search = model.getSearchBeans();
		//TODO添加查询条件按
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

	//TODO 根据主键获取指定的记录
	public TsSort getSortByID(SortData data) throws GeneralException{
		List<SearchBean> search = new ArrayList<SearchBean>();
		//TODO添加查询条件按
		SearchBean bean = new SearchBean();
		bean.setDisplayName("id");
		bean.setFieldName("id");
		bean.setSignl(Constant.EQ);
		bean.setValue(data.getId());
		bean.setType("java.lang.String");
		search.add(bean);
		List list = generalDao.search(TsSort.class, search, null, null);
		if(list.size() > 0){
			return (TsSort)list.get(0); 
		}else{
			return new TsSort();
		}
	}
	
}
