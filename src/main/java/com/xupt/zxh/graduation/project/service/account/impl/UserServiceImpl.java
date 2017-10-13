package com.xupt.zxh.graduation.project.service.account.impl;

import com.xupt.zxh.graduation.project.bean.account.User;
import com.xupt.zxh.graduation.project.dao.account.UserDao;
import com.xupt.zxh.graduation.project.service.account.IUserService;
import com.xupt.zxh.graduation.project.util.EmailUtil;
import com.xupt.zxh.graduation.project.util.ExpireDataSore;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

/**
 * Created by 张涛 on 2017/4/17.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public User getUserByEmail(String email) {
        User user = userDao.getUserByEmail(email);
        return user;
    }

    @Override
    public boolean editPassword(String oldPassword, String newPassword) {
        User user = getCurrentUser();
        if(user.getPassword().equals(oldPassword)){
            user.setPassword(newPassword);
            userDao.editPassword(user);
            return true;
        }
        return false;
    }

    @Override
    public User getCurrentUser() {
        String email = (String) SecurityUtils.getSubject().getPrincipal();
        User user = getUserByEmail(email);
        return user;
    }

    @Override
    public void editUserInfo(User user) {
        User oldUser = getCurrentUser();
        user.setId(oldUser.getId());
        userDao.editUserInfo(user);
    }

    @Override
    public void forgetPassword(String email, HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        String code = UUID.randomUUID().toString();
        long time = new Date().getTime();
        time = time+24*60*60*1000;
        String timeAndCode = ExpireDataSore.forgetPasswordExpireData.get(email);
        if(timeAndCode == null){
            ExpireDataSore.forgetPasswordExpireData.put(email,time+"_"+code);
        }else {
            ExpireDataSore.forgetPasswordExpireData.remove(email);
            ExpireDataSore.forgetPasswordExpireData.put(email,time+"_"+code);
        }
        String content = "<!DOCTYPE html>\n" +
                "<html><head>" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></head>"+
                "<body><a href="+url.substring(0,url.lastIndexOf('/'))
                +"/toResetPasswordPage?email="+email+"&code="+code
                +">找回密码请点击此链接!</a></body></html>";
        EmailUtil.sendEmail(content,email);
    }

    @Override
    public void resetPassword(User user) {
        userDao.resetPasswordByEmail(user);
    }
}
