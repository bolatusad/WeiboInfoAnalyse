package com.xupt.zxh.graduation.project.controller.account;

import com.alibaba.fastjson.JSON;
import com.xupt.zxh.graduation.project.bean.account.User;
import com.xupt.zxh.graduation.project.service.account.IUserService;
import com.xupt.zxh.graduation.project.util.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 账户相关的接口
 * Created by 张涛 on 2017/4/17.
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController {


    @Autowired
    private IUserService userService;

    /**
     * 注册用户
     */
    @RequestMapping(value = "/signup",method = RequestMethod.POST,produces = { "application/json;charset=UTF-8" })
    public @ResponseBody ModelAndView signup(User user){
        ModelAndView mav = new ModelAndView();
        userService.insertUser(user);
        mav.addObject("result","注册成功!请登录");
        mav.setViewName("account/login");
        return mav;
    }

    /**
     * 判断邮箱是否已经存在
     * @param email
     * @return
     */
    @RequestMapping(value = "/isEmailExist",method = RequestMethod.POST,produces = { "application/json;charset=UTF-8" })
    public @ResponseBody Boolean getUserByEmail(String email){
        ResponseInfo responseInfo = new ResponseInfo();
        User user = userService.getUserByEmail(email);
        //返回false，表示验证失败，即邮箱已存在
        if(user != null){
            return false;
        }else {
            //放回true表示验证通过，即邮箱不存在
            return true;
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public @ResponseBody ModelAndView login(User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("result","登录成功");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * 跳转至登录界面
     * @return
     */
    @RequestMapping(value = "/toLoginPage",method = RequestMethod.GET)
    public String toLoginPage(){
        return "account/login";
    }

    /**
     * 跳转至注册界面
     * @return
     */
    @RequestMapping(value = "/toSignupPage",method = RequestMethod.GET)
    public String toSignupPage(){
        return "account/register";
    }


    /**
     * 修改密码
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @RequestMapping(value = "/editPassword",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    public @ResponseBody ResponseInfo editPassword(String oldPassword,String newPassword){
        ResponseInfo responseInfo = new ResponseInfo();
        Boolean result = userService.editPassword(oldPassword,newPassword);
        responseInfo.setData(result);
        return responseInfo;
    }
}
