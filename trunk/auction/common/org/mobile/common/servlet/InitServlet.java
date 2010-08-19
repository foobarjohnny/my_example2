package org.mobile.common.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.beanutils.ConvertUtils;
import org.mobile.common.exception.GeneralException;
import org.mobile.common.manager.FunctionManager;
import org.mobile.common.manager.ResourceManager;
import org.mobile.common.util.DateConvert;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 初始化系统资源
 * 
 * @author 孙树林
 * 
 */
public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = -1255583046411586519L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 获取struts2的系统资源文件，装载的名称是resource.properties
		String resources = config.getInitParameter("resource");
		ResourceManager.init(resources);
		
		// 注册日期转换
		ConvertUtils.register(new DateConvert(), java.util.Date.class);
		// 系统功能权限
		// WebApplicationContext context = WebApplicationContextUtils
		// .getWebApplicationContext(config.getServletContext());
		// FunctionManager manager = (FunctionManager)
		// context.getBean("functionManager");
		// try {
		// // manager.init();
		// } catch (GeneralException e) {
		// e.printStackTrace();
		// }
	}

}
