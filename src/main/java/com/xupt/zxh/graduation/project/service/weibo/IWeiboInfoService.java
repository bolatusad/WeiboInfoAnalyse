package com.xupt.zxh.graduation.project.service.weibo;

import com.xupt.zxh.graduation.project.bean.weibo.WeiboInfo;

import java.util.List;

/**
 * Created by admin on 2017/4/6.
 */
public interface IWeiboInfoService {

    /**
     * 获取所有的微博信息
     */
    List<WeiboInfo> listAllWeiboInfo();


    /**
     * 插入微博信息
     * @param weiboInfo
     */
    void insertWeiboInfo(WeiboInfo weiboInfo);


    List<WeiboInfo> listUnalyzedWeiboInfo();

}
