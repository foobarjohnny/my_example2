package org.mobile.common.util;

import java.util.UUID;

/**
 * 生成UUID
 * 
 * @author ThinkPad
 * 
 */
public class UUIDFactory {

	/**
	 * 生成UUID
	 * 
	 * @return
	 */
	public static String createUUID() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "");
		return uuid;
	}
}
