package com.xupt.zxh.graduation.project.service.weibo;

import com.xupt.zxh.graduation.project.bean.weibo.WeiboUserInfo;

import java.util.List;

/**
 *
 * 微博用户信息
 * Created by 张涛 on 2017/5/24.
 */
public interface IWeiboUserService {

    /**
     * 获取所有的
     * @return
     */
    List<WeiboUserInfo> getAllWeiboUserInfo();
}
