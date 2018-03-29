package com.sense.cloud.logCollecter.util;

import com.sense.common.config.PropertiesUtil;

import java.io.File;

/**
 * Created by Administrator on 2018/3/29.
 */
public class LogPropertiesUtil {

  private static final String propertiesFileName = "logCollecter.properties";
  private static Long lastModified = 0L;
  private static String path = null;
  private static PropertiesUtil properties = null;

  private static String getPath() {
    if (path == null) {
      path = Thread.currentThread().getContextClassLoader() == null ? "" :
              (Thread.currentThread().getContextClassLoader().getResource("") == null ? "" : Thread.currentThread().getContextClassLoader().getResource("").getPath());
    }
    return path;
  }

  public static boolean isModifiedProp() {
    boolean b = false;
    File f = new File(getPath() + propertiesFileName);
    if (f.lastModified() > lastModified) {
      properties = new PropertiesUtil(propertiesFileName);
      lastModified = f.lastModified();
      b = true;
    }
    return b;
  }

  public static String getProperty(String key, String defaultValue) {
    if (properties == null) {
      properties = new PropertiesUtil(propertiesFileName);
    } else {
      isModifiedProp();
    }
    return properties.getProperty(key, defaultValue);
  }

  public static String getStr(String key, String defaultValue) {
    return getProperty(key, defaultValue);
  }

  public static Integer getInt(String key, Integer defaultValue) {
    String s = getProperty(key, defaultValue + "");
    return Integer.parseInt(s);
  }


  private LogPropertiesUtil() {
  }
}
