package com.xupt.zxh.graduation.project.service.account;

import com.xupt.zxh.graduation.project.bean.account.User;

import javax.servlet.http.HttpServletRequest;

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
    boolean editPassword(String oldPassword,String newPassword);

    /**
     * 获取当前登录用户的用户信息
     * @return
     */
    User getCurrentUser();

    /**
     * 修改用户信息
     * @param user
     */
    void editUserInfo(User user);

    /**
     * 忘记密码，发送修改密码的邮件
     * @param email
     */
    void forgetPassword(String email,HttpServletRequest request);

    /**
     * 重置密码，用于忘记密码
     * @param user
     */
    void resetPassword(User user);
}
