package com.xupt.zxh.graduation.project.service.weibo;

import com.xupt.zxh.graduation.project.bean.weibo.WeiboInfo;

import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 2017/4/6.
 */
public interface IWeiboInfoService {

    WeiboInfo getWeiboInfoById(Integer id);

    /**
     * 获取所有的微博信息
     */
    List<WeiboInfo> listAllWeiboInfo();


    /**
     * 插入微博信息
     * @param weiboInfo
     */
    void insertWeiboInfo(WeiboInfo weiboInfo);


    /**
     * 获取所有没有进行情感分析的微博
     * @return
     */
    List<WeiboInfo> listUnalyzedWeiboInfo();


    /**
     * 读取微博信息并爬去用户的微博信息
     */
    void spiderWork(IWeiboInfoService weiboInfoService) throws IOException, InterruptedException;





}
