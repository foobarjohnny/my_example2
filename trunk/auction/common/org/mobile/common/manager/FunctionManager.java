package org.mobile.common.manager;

import java.util.HashMap;
import java.util.Map;

import org.mobile.common.exception.GeneralException;
import org.mobile.module.system.function.service.IFunctionService;
import org.mobile.module.system.menu.action.MenuData;

/**
 * 系统功能权限
 * 
 * @author 孙树林
 * 
 */
public class FunctionManager {

	private IFunctionService functionService;

	private static Map<String, MenuData> menus = new HashMap<String, MenuData>();

	private static FunctionManager manager;

	public static FunctionManager getInstance() {
		return manager;
	}

	/**
	 * @throws GeneralException
	 * 
	 */
	public void init() throws GeneralException {
		menus = functionService.query();
	}

	/**
	 * 获得功能名称
	 * 
	 * @param key
	 * @return
	 */
	public static String getMenuName(String key) {
		MenuData data = menus.get(key);
		if (data != null) {
			return data.getMenuName();
		} else {
			return "";
		}
	}

	public void setFunctionService(IFunctionService functionService) {
		this.functionService = functionService;
	}
}
