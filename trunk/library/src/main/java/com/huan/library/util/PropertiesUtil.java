package com.huan.library.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.LogFactory;

/**
 * 从配置文件读取相关配置信息 Dec 4, 2009 2:13:28 PM
 * 
 * 
 */
public class PropertiesUtil {
    private static InputStream inputStream = PropertiesUtil.class
            .getClassLoader().getResourceAsStream("system.properties");
    private static Properties prop = new Properties();
    static {
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            LogFactory.getLog(PropertiesUtil.class.getName()).error(
                    "初始化系统参数异常!", e);
        }
    }

    public static String getProperty(String key) {
        String value = prop.getProperty(key);
        return value;
    }
}
