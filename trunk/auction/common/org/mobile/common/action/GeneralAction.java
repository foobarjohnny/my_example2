package org.mobile.common.action;

import org.mobile.common.bean.PageBean;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 所有Action基类，所有Action都必须继承该类，提供处理Action中常使用的共同方法。
 * 
 * @author 孙树林
 * 
 * @param <T>
 */
public abstract class GeneralAction<T> extends ActionSupport implements
		ModelDriven<T> {

	private static final long serialVersionUID = 8863417639381876502L;

	/**
	 * 分页处理
	 * 
	 * @param generalData
	 */
	protected void setPage(GeneralData generalData) {
		if (generalData.getPageBean() != null) {

		} else {
			generalData.setPageBean(new PageBean());
		}
	}
}
