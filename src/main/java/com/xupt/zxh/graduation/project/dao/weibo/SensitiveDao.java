package com.xupt.zxh.graduation.project.dao.weibo;

import com.xupt.zxh.graduation.project.bean.weibo.Sensitive;
import com.xupt.zxh.graduation.project.bean.weibo.WeiboSensitive;

import java.util.List;

/**
 * 敏感词数据相关操作
 * Created by 张涛 on 2017/5/7.
 */
public interface SensitiveDao {

    /**
     * 插入敏感词
     * @param sensitive
     */
    void insertSensitive(Sensitive sensitive);

    /**
     * 获取所有的敏感词
     * @return
     */
    List<Sensitive> listAllSensitive();

    /**
     * 插入敏感词分析结果
     */
    void insertResult(WeiboSensitive weiboSensitive);

    /**
     * 获取所有的敏感词分析结果
     */
    List<WeiboSensitive> listAllSensitiveResult();

}


