package com.xupt.zxh.graduation.project.util;

/**
 * 常量工具类
 * Created by 张涛 on 2017/4/12.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 *
 */
public class ConstantsUtil {


    /**
     * 读取properties文件的工具类
     */
    private static Properties p = new Properties();

    /**
     * 读取properties配置文件信息
     */
    static {
        try {
            //用于解决读取中文配置文件乱码的情况
            InputStream inputStream = ConstantsUtil.class.getClassLoader().getResourceAsStream("properties/constants.properties");
            p.load(new InputStreamReader(inputStream,"utf-8"));
//            p.load(ConstantsUtil.class.getClassLoader().getResourceAsStream("/properties/constants.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据key得到value的值
     */
    public static String getValue(String key) {
        return p.getProperty(key);
    }
}
