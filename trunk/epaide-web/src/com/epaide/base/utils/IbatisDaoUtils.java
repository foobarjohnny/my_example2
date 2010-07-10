package com.epaide.base.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class IbatisDaoUtils {
	protected static String getPrimaryKeyFieldName(Object o) {
		Field[] fieldlist = o.getClass().getDeclaredFields();
		String fieldName = null;
		for (Field fld : fieldlist) {
			if ((fld.getName().equals("id"))
					|| (fld.getName().indexOf("Id") > -1)) {
				fieldName = fld.getName();
				break;
			}
		}
		return fieldName;
	}

	public static Class getPrimaryKeyFieldType(Object o) {
		Field[] fieldlist = o.getClass().getDeclaredFields();
		Class fieldType = null;
		for (Field fld : fieldlist) {
			if ((fld.getName().equals("id"))
					|| (fld.getName().indexOf("Id") > -1)) {
				fieldType = fld.getType();
				break;
			}
		}
		return fieldType;
	}

	public static Object getPrimaryKeyValue(Object o) {
		String fieldName = getPrimaryKeyFieldName(o);
		String getterMethod = "get"
				+ Character.toUpperCase(fieldName.charAt(0))
				+ fieldName.substring(1);
		try {
			Method getMethod = o.getClass().getMethod(getterMethod,
					(Class[]) null);
			return getMethod.invoke(o, (Object[]) null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void setPrimaryKey(Object o, Class clazz, Object value) {
		String fieldName = getPrimaryKeyFieldName(o);
		String setMethodName = "set"
				+ Character.toUpperCase(fieldName.charAt(0))
				+ fieldName.substring(1);
		try {
			Method setMethod = o.getClass().getMethod(setMethodName,
					new Class[] { clazz });
			if (value != null)
				setMethod.invoke(o, new Object[] { value });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getSelectQuery(String className) {
		return "get" + className + "s";
	}

	public static String getFindQuery(String className) {
		return "get" + className;
	}

	public static String getInsertQuery(String className) {
		return "add" + className;
	}

	public static String getUpdateQuery(String className) {
		return "update" + className;
	}

	public static String getDeleteQuery(String className) {
		return "delete" + className;
	}

	public static String getSelectQuery(Class clazz) {
		return getSelectQuery(getShortName(clazz));
	}

	public static String getFindQuery(Class clazz) {
		return getFindQuery(getShortName(clazz));
	}

	public static String getInsertQuery(Class clazz) {
		return getInsertQuery(getShortName(clazz));
	}

	public static String getUpdateQuery(Class clazz) {
		return getUpdateQuery(getShortName(clazz));
	}

	public static String getDeleteQuery(Class clazz) {
		return getDeleteQuery(getShortName(clazz));
	}

	public static String getShortName(String className) {
		int lastDotIndex = className.lastIndexOf(".");
		String shortName = className.substring(lastDotIndex + 1);
		return shortName;
	}

	public static String getShortName(Class clazz) {
		return getShortName(clazz.getCanonicalName());
	}

}
