package org.mobile.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import org.mobile.common.manager.ResourceManager;

/**
 * 日期转换功能
 * 
 * @author 孙树林
 * 
 */
public class DateConvert implements Converter {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd");

	/**
	 * 构造方法
	 */
	public DateConvert() {
	}

	@SuppressWarnings("unchecked")
	public Object convert(Class type, Object value) {
		ResourceManager resource = ResourceManager.getInstance();
		dateFormat = new SimpleDateFormat(resource.getString("date.format"));
		if (value == null)
			return null;
		if (value instanceof String) {
			try {
				return dateFormat.parse((String) value);
			} catch (Exception ex) {
				dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				try {
					return dateFormat.parse((String) value);
				} catch (ParseException e) {
					dateFormat = new SimpleDateFormat("yyyyMMdd");
					try {
						return dateFormat.parse((String) value);
					} catch (ParseException ext) {
						return null;
					}
				}

			}
		} else if (value instanceof java.util.Date) {
			return value;
		} else {
			throw new ConversionException(resource.getString("date.obj.error")
					+ value.getClass());
		}
	}
}