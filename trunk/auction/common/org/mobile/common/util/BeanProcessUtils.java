package org.mobile.common.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.mobile.common.exception.GeneralException;

public class BeanProcessUtils {

	public static void copyProperties(Object target, Object source)
			throws GeneralException {
		try {
			BeanUtils.copyProperties(target, source);
		} catch (IllegalAccessException e) {
			throw new GeneralException(e);
		} catch (InvocationTargetException e) {
			throw new GeneralException(e);
		}
	}
}
