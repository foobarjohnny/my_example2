package org.mobile.common.manager;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.mobile.common.bean.SqlBean;
import org.mobile.common.log.GeneralLog;

/**
 * 预处理器，只要在同一个线程内获得共同内容
 * 
 * @author 孙树林
 * 
 */
public class GeneralManager {

	public static final String GENERAL_MANAGER = "GeneralManager";
	public static final String UPLOAD_IMAGE = "/upload/images";
	public static final String UPLOAD_IMAGE_OTHER = "upload/images";
	public static final String IMAGE = "/images";
	private static ThreadLocal<GeneralManager> local = new ThreadLocal<GeneralManager>();
	private GeneralLog logger = GeneralLog.getInstance();
	/** sessionId */
	private String sessionId;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ServletContext servletContext;
	/** 权限编号 */
	private String functionId;
	/** 后台数据库 */
	private List<SqlBean> sqlBeans = new ArrayList<SqlBean>();

	public GeneralManager() {
		super();
	}

	public GeneralManager(String sessionId, HttpServletRequest request,
			HttpServletResponse response, ServletContext servletContext) {
		super();
		this.sessionId = sessionId;
		this.request = request;
		this.response = response;
		this.servletContext = servletContext;
	}

	/**
	 * 将自身保存到线程安全的对象中
	 * 
	 * @param manager
	 */
	public static void setCurrentManager(GeneralManager manager) {
		local.set(manager);
	}

	/**
	 * 从线程中取得自身,只要在一个请求过程中,取得的内容都是一样的
	 * 
	 * @return
	 */
	public static GeneralManager getCurrentManager() {
		return local.get();
	}

	/**
	 * 处理请求内容前需要做的工作
	 * 
	 */
	public void preProcess() {
		GeneralLog.getInstance().debug(request.getRequestURL(),
				"Request Startup");
	}

	/**
	 * 处理出现异常时的工作
	 * 
	 * @param e
	 */
	public void processException(Exception e) {
		GeneralLog.getInstance().error(request.getRequestURI(), e,
				"Request Error");
	}

	/**
	 * 处理请求内容后需要做的工作
	 * 
	 */
	public void postProcess() {
		GeneralLog.getInstance().debug(request.getRequestURL(), "Request Stop");
	}

	/**
	 * 上传图片路径
	 * 
	 * @return
	 */
	public String getImageDir(String dir) {
		return ServletActionContext.getServletContext().getRealPath(dir);
	}

	public String getSessionId() {
		return sessionId;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public List<SqlBean> getSqlBeans() {
		return sqlBeans;
	}

	public void setSqlBeans(List<SqlBean> sqlBeans) {
		this.sqlBeans = sqlBeans;
	}
}
