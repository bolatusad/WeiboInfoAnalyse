package com.xupt.zxh.graduation.project.dao.weibo;

import com.xupt.zxh.graduation.project.bean.weibo.WeiboUserInfo;

import java.util.List;

/**
 * 微博User数据操作接口
 * Created by 张涛 on 2017/5/7.
 */
public interface WeiboUserDao {

    /**
     * 根据用户的ID去查询其微博的用户信息
     * @param id
     * @return
     */
    WeiboUserInfo getWeiboUserInfoByUserId(Integer id);

    /**
     * 绑定微博
     * @param weiboUserInfo
     */
    void bindWeibo(WeiboUserInfo weiboUserInfo);

    /**
     * 获取所有的微博用户信息
     * @return
     */
    List<WeiboUserInfo> getAllWeiboUser();

}


