package com.yiboche.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class UUIDUtils {
	/**
	 * 获取uuid
	 * 
	 * @return
	 */
	public static String getId() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

	/**
	 * 获取激活码
	 * 
	 * @return
	 */
	public static String getCode() {
		return getId();
	}

	/**
	 * 获取订单号
	 * 
	 * @return
	 */
	public static String getOrderId() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String orderId = format.format(new Date());
		Random random = new Random();
		StringBuilder sb=new StringBuilder(orderId);
		sb.append(random.nextInt(10));
		sb.append(random.nextInt(10));
		sb.append(random.nextInt(10));
		return sb.toString();
	}
	
}
