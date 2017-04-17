package com.xupt.zxh.graduation.project.service.weibo.impl;

import com.xupt.zxh.graduation.project.bean.weibo.WeiboEmotion;

import java.util.List;

/**
 * 微博情感分析相关操作
 * Created by 张涛 on 2017/4/17.
 */
public interface IWeiboEmotionService {

    /**
     * 插入微博情感分析
     * @param weiboEmotion
     */
    void insertWeiboEomtion(WeiboEmotion weiboEmotion);

    /**
     * 批量插入微博情感分析
     * @param weiboEmotions
     */
    void insertWeiboEmotions(List<WeiboEmotion> weiboEmotions);


    /**
     * 通过微博ID查询微博情感分析
     * @param id
     */
    WeiboEmotion queryWeiboEmotionByWeiboId(Integer id);
}
