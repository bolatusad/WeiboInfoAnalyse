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

    /**
     * 修改密码
     * @param user
     */
    void editPassword(User user);

    /**
     * 通过用户ID获取用户信息
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 修改用户信息
     * @param user
     */
    void editUserInfo(User user);


    /**
     * 重置密码，通过邮箱
     * @param user
     */
    void resetPasswordByEmail(User user);

}
