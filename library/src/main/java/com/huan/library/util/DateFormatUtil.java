package com.huan.library.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {

	public static String format(Date date, String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String dateStr = sdf.format(date);
		return dateStr;
	}
	
	public static Date convertToDate(String value){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date rtnOjb = null;
		if(value != null && !"".equals(value.toString())){
			try {
				rtnOjb = sdf.parse(value.toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} 
		return rtnOjb;
	}
}
