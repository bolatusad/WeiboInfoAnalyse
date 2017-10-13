package com.xupt.zxh.graduation.project.service.account;

import com.xupt.zxh.graduation.project.bean.weibo.WeiboUserInfo;

import java.io.IOException;

/**
 * 学生相关操作接口
 * Created by 张涛 on 2017/4/21.
 */
public interface IStudentService {

    /**
     * 验证微博
     * @param weiboId
     */
    String verifyWeiboId(String weiboId) throws IOException;

    /**
     * 绑定微博
     * @param weiboUserInfo
     */
    void bindWeibo(WeiboUserInfo weiboUserInfo);

    /**
     * 获取用户自己的微博信息
     * @return
     */
    WeiboUserInfo getWeiboUserInfo();


}
