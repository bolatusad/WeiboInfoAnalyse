package com.xupt.zxh.graduation.project.service.account;

import com.xupt.zxh.graduation.project.bean.account.User;

/**
 * Created by admin on 2017/4/1.
 */
public interface IUserService {

    /**
     * 新建用户
     * @param user
     */
    void insertUser(User user);

    /**
     * 通过邮箱获取用户
     * @param email
     * @return
     */
    User getUserByEmail(String email);


    /**
     * 修改密码
     * @param oldPassword
     * @param newPassword
     * @return
     */
    public boolean editPassword(String oldPassword,String newPassword);
}
