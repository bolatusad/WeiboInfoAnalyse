package com.xupt.zxh.graduation.project.service.weibo.impl;

import com.xupt.zxh.graduation.project.bean.weibo.WeiboInfo;
import com.xupt.zxh.graduation.project.bean.weibo.WeiboUserInfo;
import com.xupt.zxh.graduation.project.dao.weibo.WeiboInfoDao;
import com.xupt.zxh.graduation.project.service.weibo.IWeiboInfoService;
import com.xupt.zxh.graduation.project.service.weibo.IWeiboUserService;
import com.xupt.zxh.graduation.project.spider.MySpider2;
import com.xupt.zxh.graduation.project.util.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 2017/4/6.
 */
@Service
public class WeiboInfoServiceImpl implements IWeiboInfoService {





    @Autowired
    private WeiboInfoDao weiboInfoDao;

    @Autowired
    private IWeiboUserService weiboUserService;


    @Override
    public WeiboInfo getWeiboInfoById(Integer id) {
        WeiboInfo weiboInfo = weiboInfoDao.getWeiboInfoById(id);
        return weiboInfo;
    }

    @Override
    public List<WeiboInfo> listAllWeiboInfo() {
        List<WeiboInfo> weiboInfos = weiboInfoDao.listAllWeiboInfo();
        return weiboInfos;
    }

    @Override
    public void insertWeiboInfo(WeiboInfo weiboInfo) {
        weiboInfoDao.insertWeiboInfo(weiboInfo);
    }

    @Override
    public List<WeiboInfo> listUnalyzedWeiboInfo() {
        List<WeiboInfo> weiboInfos = weiboInfoDao.listUnalyzedWeiboInfo();
        return weiboInfos;
    }

    @Override
    public void spiderWork(IWeiboInfoService weiboInfoService) throws IOException, InterruptedException {
        MySpider2 mySpider2 = new MySpider2();
        List<WeiboUserInfo> weiboUserInfos = weiboUserService.getAllWeiboUserInfo();
        String urlPre = ConstantsUtil.getValue("spider_weibo_url_pre");
        for(WeiboUserInfo weiboUserInfo : weiboUserInfos){
            String weiboId = weiboUserInfo.getWeiboId();
            if(weiboId !=null && weiboId.length()>1){
                String url = urlPre+weiboId;
                mySpider2.getWeiboInfo(url,weiboUserInfo.getUserId(),weiboInfoService);
            }
        }

    }

}
