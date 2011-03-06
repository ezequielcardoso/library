package com.huan.library.util;

import java.util.Arrays;

public class StringAndUTF8 {
    public static String toUtf8String(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 0 && c <= 255) {
                sb.append(c);
            } else {
                byte[] b;
                try {
                    b = Character.toString(c).getBytes("utf-8");
                } catch (Exception ex) {
                    b = new byte[0];
                }
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0)
                        k += 256;
                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return sb.toString();
    }
    /**
     * 将经过UFT-8编码转换后的UTF8串恢复为原字符串
     * @param UTF8String 字符串经过UTF8转码后的结果，如果传入的参数形式不是转码后的字符串，此方法不适用
     * @return
     */
    public static String UTFToString(String UTF8String){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<UTF8String.length();i++){
            if(UTF8String.charAt(i)=='%'){
                String[] str = UTF8String.substring(i+1, i+9).split("%");
                byte[] b = new  byte[3];
                for(int j = 0;j<b.length;j++){
                    b[j] = hexStringToInt(str[j]).byteValue();
                }
                sb.append(new String(b));
                i+=8;
            }else{
                sb.append(UTF8String.charAt(i));
            }
        }
        return sb.toString();
    }
    private static Integer hexStringToInt(String hex){
        char[] arr = {'0','1','2','3','4','5','6','7','8',
                '9', 'A','B','C','D','E','F'};
        int result = 16*Arrays.binarySearch(arr, hex.charAt(0))+Arrays.binarySearch(arr, hex.charAt(1));
        return result-256;
    }
}
