package com.xupt.zxh.graduation.project.service.weibo.impl;

import com.xupt.zxh.graduation.project.bean.weibo.WeiboEmotion;
import com.xupt.zxh.graduation.project.dao.weibo.WeiboEmotionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 张涛 on 2017/4/17.
 */
@Service
public class WeiboEmotionServiceImpl implements IWeiboEmotionService {

    @Autowired
    private WeiboEmotionDao weiboEmotionDao;


    @Override
    public void insertWeiboEomtion(WeiboEmotion weiboEmotion) {
        weiboEmotionDao.insertWeiboEomtion(weiboEmotion);
    }

    @Override
    public void insertWeiboEmotions(List<WeiboEmotion> weiboEmotions) {
        weiboEmotionDao.insertWeiboEmotions(weiboEmotions);
    }

    @Override
    public WeiboEmotion queryWeiboEmotionByWeiboId(Integer id) {
        WeiboEmotion weiboEmotion = weiboEmotionDao.queryWeiboEmotionByWeiboId(id);
        return weiboEmotion;
    }
}
