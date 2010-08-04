package org.mobile.common.log;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * 系统log处理类
 * 
 * @author 孙树林
 * 
 */
public class GeneralLog {

	private static GeneralLog generalLog;

	private static Logger logger = Logger.getLogger(GeneralLog.class);

	private GeneralLog() {
	}

	public static GeneralLog getInstance() {
		if (generalLog != null) {
			return generalLog;
		}
		return new GeneralLog();
	}

	public void debug(String str) {
		logger.debug(str);
	}

	public void debug(Object obj, String str) {
		logger.debug(obj.getClass() + " " + str);
	}

	public void info(String str) {
		logger.info(str);
	}

	public void info(Object obj, String str) {
		logger.info(obj.getClass() + " " + str);
	}

	public void error(String str) {
		logger.error(str);
	}

	public void error(String str, Throwable throwable) {
		logger.error(str, throwable);
	}

	public void error(Object obj, String str) {
		logger.error(obj.getClass() + " " + str);
	}

	public void error(Object obj, Throwable throwable, String str) {
		logger.error(obj.getClass() + " " + str, throwable);
	}

	public void error(String strPath, Throwable throwable, String str) {
		logger.error(strPath + " " + str, throwable);
	}

	public static void init(String path) {
		DOMConfigurator.configure(path);
	}
}
