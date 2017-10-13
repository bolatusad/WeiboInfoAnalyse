package com.xupt.zxh.graduation.project.service.account.impl;

import com.xupt.zxh.graduation.project.bean.account.User;
import com.xupt.zxh.graduation.project.bean.weibo.WeiboUserInfo;
import com.xupt.zxh.graduation.project.dao.weibo.WeiboUserDao;
import com.xupt.zxh.graduation.project.service.account.IStudentService;
import com.xupt.zxh.graduation.project.service.account.IUserService;
import com.xupt.zxh.graduation.project.util.ConstantsUtil;
import com.xupt.zxh.graduation.project.util.MyHttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 学生相关内容服务类实现
 * Created by 张涛 on 2017/5/6.
 */
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IUserService userService;

    @Autowired
    private WeiboUserDao weiboUserDao;

    @Override
    public String verifyWeiboId(String weiboId) throws IOException {
        String preUrl = ConstantsUtil.getValue("weibo_home_pre");
        String weiboHomeUrl = preUrl+weiboId;
        String page = MyHttpUtil.requestGet(weiboHomeUrl);
        Document document = Jsoup.parse(page);
        String title = document.title();
        String nickname = title.substring(0,title.indexOf("的微博"));
        return nickname;
    }


    @Override
    public void bindWeibo(WeiboUserInfo weiboUserInfo) {
        User user = userService.getCurrentUser();
        WeiboUserInfo oldWeiboUserInfo = weiboUserDao.getWeiboUserInfoByUserId(user.getId());
        if(oldWeiboUserInfo == null){
            weiboUserInfo.setUserId(user.getId());
            weiboUserDao.bindWeibo(weiboUserInfo);
        }
    }

    @Override
    public WeiboUserInfo getWeiboUserInfo() {
        User user = userService.getCurrentUser();
        WeiboUserInfo weiboUserInfo = weiboUserDao.getWeiboUserInfoByUserId(user.getId());
        return weiboUserInfo;
    }
}
