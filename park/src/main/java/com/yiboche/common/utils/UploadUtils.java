package com.yiboche.common.utils;

import java.util.UUID;

public class UploadUtils {
	/**
	 * 获取新文件名 @Description: TODO @param @param realName @param @return @return
	 * String @throws
	 */
	public static String getUUIDName(String realName) {

		int index = realName.lastIndexOf(".");
		if (index == -1) {
			return UUID.randomUUID().toString().replace("-", "").toUpperCase();
		} else {
			return UUID.randomUUID().toString().replace("-", "").toUpperCase() + realName.substring(index);
		}
	}

	/**
	 * 获取文件的名称
	 * 
	 * @param name
	 * @return
	 */
	public static String getRealName(String name) {

		int index = name.lastIndexOf("\\");
		return name.substring(index + 1);
	}

	/**
	 * 
	 * @Description: 获取文件真实名称 @param @param name @param @return @return
	 *               String @throws
	 */
	public static String getDir(String name) {
		int i = name.hashCode();
		String hex = Integer.toHexString(i);
		int j = hex.length();
		for (int k = 0; k < 8 - j; k++) {
			hex = "0" + hex;
		}
		return "/" + hex.charAt(0) + "/" + hex.charAt(1);
	}

}
