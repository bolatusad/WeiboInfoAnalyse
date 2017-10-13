package com.xupt.zxh.graduation.project.dao.weibo;

import com.xupt.zxh.graduation.project.bean.weibo.WeiboInfo;

import java.util.List;

/**
 * 微博信息的数据类
 * Created by admin on 2017/4/6.
 */
public interface WeiboInfoDao {

    /**
     * 根据微博ID获取微博
     * @param id
     * @return
     */
    WeiboInfo getWeiboInfoById(Integer id);

    /**
     * 插入单条微博信息
     * @param weiboInfo
     */
    void insertWeiboInfo(WeiboInfo weiboInfo);

    /**
     * 获取所有的微博信息
     */
    List<WeiboInfo> listAllWeiboInfo();

    /**
     * 获取所有的未分析情感的微博
     * @return
     */
    List<WeiboInfo> listUnalyzedWeiboInfo();


}
