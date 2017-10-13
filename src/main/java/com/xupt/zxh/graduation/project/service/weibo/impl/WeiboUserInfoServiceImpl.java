package com.xupt.zxh.graduation.project.service.weibo.impl;

import com.xupt.zxh.graduation.project.bean.weibo.WeiboUserInfo;
import com.xupt.zxh.graduation.project.dao.weibo.WeiboUserDao;
import com.xupt.zxh.graduation.project.service.weibo.IWeiboUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 微博用户信息服务类
 * Created by 张涛 on 2017/5/24.
 */
@Service
public class WeiboUserInfoServiceImpl implements IWeiboUserService {

    @Autowired
    private WeiboUserDao weiboUserDao;

    @Override
    public List<WeiboUserInfo> getAllWeiboUserInfo() {
        List<WeiboUserInfo> weiboUserInfos = weiboUserDao.getAllWeiboUser();
        return weiboUserInfos;
    }
}
