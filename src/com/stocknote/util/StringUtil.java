package com.stocknote.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {

	public static String getToday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(new Date(System.currentTimeMillis()));
	}
	
}
