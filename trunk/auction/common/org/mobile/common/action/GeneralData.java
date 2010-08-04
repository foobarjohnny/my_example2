package org.mobile.common.action;

import java.util.ArrayList;
import java.util.List;

import org.mobile.common.bean.OrderByBean;
import org.mobile.common.bean.PageBean;
import org.mobile.common.bean.SearchBean;

/**
 * 
 * @author skf6611
 * 
 */
public class GeneralData {

	private PageBean pageBean;

	private List<SearchBean> searchBeans = new ArrayList<SearchBean>();

	private String functionId;

	private List<OrderByBean> orderByBeans = new ArrayList<OrderByBean>();

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public List<SearchBean> getSearchBeans() {
		return searchBeans;
	}

	public void setSearchBeans(List<SearchBean> searchBeans) {
		this.searchBeans = searchBeans;
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public List<OrderByBean> getOrderByBeans() {
		return orderByBeans;
	}

	public void setOrderByBeans(List<OrderByBean> orderByBeans) {
		this.orderByBeans = orderByBeans;
	}
}
