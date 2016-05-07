package com.hklh8.higou.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class HigouUtil {
	public static String getId(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}
	public static String getNow(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	public static String getGoodsNo(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssms");
		return sdf.format(new Date());
	}
}
