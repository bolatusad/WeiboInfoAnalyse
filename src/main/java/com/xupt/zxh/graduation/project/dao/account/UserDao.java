package com.xupt.zxh.graduation.project.dao.account;

import com.xupt.zxh.graduation.project.bean.account.User;

/**
 * Created by admin on 2017/4/1.
 */
public interface UserDao {

    /**
     * 根据邮箱获取用户
     * @return
     */
    User getUserByEmail(String email);

    /**
     * 新建用户
     * @param user
     */
    void insertUser(User user);
}
