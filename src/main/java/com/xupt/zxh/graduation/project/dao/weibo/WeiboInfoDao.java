package com.xupt.zxh.graduation.project.dao.weibo;

import com.xupt.zxh.graduation.project.bean.weibo.WeiboInfo;

import java.util.List;

/**
 * 微博信息的数据类
 * Created by admin on 2017/4/6.
 */
public interface WeiboInfoDao {

    /**
     * 插入单条微博信息
     * @param weiboInfo
     */
    void insertWeiboInfo(WeiboInfo weiboInfo);

    /**
     * 获取所有的微博信息
     */
    List<WeiboInfo> listAllWeiboInfo();


}
