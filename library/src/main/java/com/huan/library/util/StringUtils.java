package com.huan.library.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class StringUtils {
	
	public static int lastIndexOfIngore(String source, String indexStr){
		int index = source.lastIndexOf(indexStr);
		if (index == -1){
			index = source.lastIndexOf(indexStr.toUpperCase());
		}else if (index == -1){
			index = source.lastIndexOf(indexStr.toLowerCase());
		}
		return index;
	}
	
	 public static String[] getIgnore(Object f) {
		 List<String> list = new ArrayList<String>();
		 String str[]=null;
		 try {
			 Field[] fields = f.getClass().getDeclaredFields();
			 for(int i = 0 , len = fields.length; i < len; i++) {
	            String varName = fields[i].getName();
                boolean accessFlag = fields[i].isAccessible();
                fields[i].setAccessible(true);
                Object o = fields[i].get(f);
                if(o!=null){
//                	System.out.println("传入的对象中包含一个如下的变量：" + varName +  " = " + o);
                }else{
                	list.add(varName);
                }
                fields[i].setAccessible(accessFlag);
			 }
			 if(list!=null&&list.size()>0){
				 str = new String[list.size()];
				 for (int i = 0; i < list.size(); i++) {
					str[i] = list.get(i);
				 }
			 }
		 } catch (Exception ex) {
			 ex.printStackTrace();
		 }
		 return str;
	 }

}
