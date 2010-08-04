package org.mobile.common.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类型转换
 * 
 * @author 孙树林
 * 
 */
public class TypeConvert {

	/**
	 * 类型转换工具类
	 * 
	 * @param type
	 * @param value
	 * @return
	 */
	public static Object convert(String type, String value) {
		if (type.equals("int")) {
			return Integer.parseInt(value);
		} else if (type.equals("decimal")) {
			return new BigDecimal(value);
		} else if (type.equals("date")) {
			return formatDate(value, "yyyy-MM-dd");
		} else if (type.equals("timestamp")) {
			return formatDate(value, "yyyy-MM-dd hh:mm:ss");
		} else if (type.equals("long")) {
			return new Long(value);
		} else {
			return value;
		}
	}

	/**
	 * 日期格式转换
	 * 
	 * @return
	 */
	public static Date formatDate(String date, String style) {
		SimpleDateFormat format = new SimpleDateFormat(style);
		try {
			return format.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
}
