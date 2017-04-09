package com.xupt.zxh.graduation.project.service.weibo.impl;

import com.xupt.zxh.graduation.project.bean.weibo.WeiboInfo;
import com.xupt.zxh.graduation.project.dao.weibo.WeiboInfoDao;
import com.xupt.zxh.graduation.project.service.weibo.IWeiboInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/4/6.
 */
@Service
public class WeiboInfoServiceImpl implements IWeiboInfoService {

    @Autowired
    private WeiboInfoDao weiboInfoDao;


    @Override
    public List<WeiboInfo> listAllWeiboInfo() {
        List<WeiboInfo> weiboInfos = weiboInfoDao.listAllWeiboInfo();
        return weiboInfos;
    }

    @Override
    public void insertWeiboInfo(WeiboInfo weiboInfo) {
        weiboInfoDao.insertWeiboInfo(weiboInfo);
    }
}
