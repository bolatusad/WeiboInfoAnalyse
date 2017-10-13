package com.xupt.zxh.graduation.project.controller.account;

import com.xupt.zxh.graduation.project.bean.account.School;
import com.xupt.zxh.graduation.project.bean.account.User;
import com.xupt.zxh.graduation.project.service.account.ISchoolService;
import com.xupt.zxh.graduation.project.service.account.IUserService;
import com.xupt.zxh.graduation.project.util.ConstantsUtil;
import com.xupt.zxh.graduation.project.util.ExpireDataSore;
import com.xupt.zxh.graduation.project.util.ResponseInfo;
import com.xupt.zxh.graduation.project.util.VerifyCodeUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;


/**
 * 账户相关的接口
 * Created by 张涛 on 2017/4/17.
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController {

    private Logger logger = Logger.getLogger(AccountController.class);


    @Autowired
    private IUserService userService;

    @Autowired
    private ISchoolService schoolService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

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
        AuthenticationToken token = new UsernamePasswordToken(user.getEmail(),user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        }catch(UnknownAccountException uae){
            System.out.println("对用户[" + user.getEmail() + "]进行登录验证..验证未通过,未知账户");
            modelAndView.addObject("message_login", "未知账户");
            modelAndView.setViewName("account/login");
            return modelAndView;
//            request.setAttribute("message_login", "未知账户");
        }catch(IncorrectCredentialsException ice){
            System.out.println("对用户[" + user.getEmail() + "]进行登录验证..验证未通过,错误的凭证");
            modelAndView.addObject("message_login", "密码不正确");
            modelAndView.setViewName("account/login");
            return modelAndView;
//            request.setAttribute("message_login", "密码不正确");
        }catch(LockedAccountException lae){
            System.out.println("对用户[" + user.getEmail() + "]进行登录验证..验证未通过,账户已锁定");
            modelAndView.addObject("message_login", "账户已锁定");
            modelAndView.setViewName("account/login");
            return modelAndView;
//            request.setAttribute("message_login", "账户已锁定");
        }catch(ExcessiveAttemptsException eae){
            System.out.println("对用户[" + user.getEmail() + "]进行登录验证..验证未通过,错误次数过多");
            modelAndView.addObject("message_login", "用户名或密码错误次数过多");
            modelAndView.setViewName("account/login");
            return modelAndView;
//            request.setAttribute("message_login", "用户名或密码错误次数过多");
        }catch(AuthenticationException ae){
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            System.out.println("对用户[" + user.getEmail() + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
            modelAndView.addObject("message_login", "用户名或密码不正确");
            modelAndView.setViewName("account/login");
            return modelAndView;
//            request.setAttribute("message_login", "用户名或密码不正确");
        }
        String email = (String) subject.getPrincipal();
        user = userService.getUserByEmail(email);
        School school = schoolService.getCurrentSchool();
        modelAndView.addObject("result","登录成功");
        if(school == null){
            modelAndView.setViewName("index_student");
        }else {
            modelAndView.setViewName("index");
        }
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

    /**
     * 获取当前登录用户信息
     * @return
     */
    @RequestMapping(value = "/getCurrentUser",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public @ResponseBody ResponseInfo getCurrentUser(){
        ResponseInfo responseInfo = new ResponseInfo();
        User user = userService.getCurrentUser();
        responseInfo.setData(user);
        return  responseInfo;
    }

    /**
     * 修改当前登录用户的用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/editUserInfo",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    public @ResponseBody ResponseInfo editUserInfo(@RequestBody User user){
        ResponseInfo responseInfo = new ResponseInfo();
        userService.editUserInfo(user);
        return responseInfo;
    }

    /**
     * 退出系统
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.getPrincipal());
        subject.logout();
        return "account/login";

    }

    /**
     * 获取图片验证码
     */
    @RequestMapping(value = "/getVerifyCode",method =RequestMethod.GET )
    public @ResponseBody void getVerifyCode() throws IOException {
        String code = VerifyCodeUtils.generateVerifyCode(
                Integer.parseInt(ConstantsUtil.getValue("verify_code_length")));
        //将生成的验证码放入会话中
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("getPassword",code);
        logger.error("验证码为："+code);
        VerifyCodeUtils.outputImage(
                Integer.parseInt(ConstantsUtil.getValue("verify_code_width")),
                Integer.parseInt(ConstantsUtil.getValue("verify_code_height")),
                response.getOutputStream(),
                code
        );
    }

    /**
     * 跳转至忘记密码页面
     * @return
     */
    @RequestMapping(value = "/toForgetPasswordPage",method = RequestMethod.GET)
    public String toForgetPasswordPage(){
        return "account/forget_password";
    }

    /**
     * 忘记密码，发送修改邮件
     * @param email
     * @return
     */
    @RequestMapping(value = "/forgetPassword",method = RequestMethod.POST,produces = {"application/json;chatset=UTF-8"})
    public @ResponseBody ResponseInfo forgetPassword(String email){
        ResponseInfo responseInfo = new ResponseInfo();
        userService.forgetPassword(email,request);
        return responseInfo;
    }

    /**
     * 跳转至重置密码页面
     * @param email
     * @param code
     * @return
     */
    @RequestMapping(value = "/toResetPasswordPage",method = RequestMethod.GET)
    public String toResetPasswordPage(String email,String code){
        String timeAndCode = ExpireDataSore.forgetPasswordExpireData.get(email);
        System.out.println(timeAndCode);
        if(timeAndCode != null){
            String[] timeAndCodes = timeAndCode.split("_");
            Long now = new Date().getTime();
            Long time = Long.parseLong(timeAndCodes[0]);
            if(now <= time && timeAndCodes[1].equals(code)){
                return "account/reset_password";
            }else{
                return "public/error_page";
            }
        }else{
            return "public/error_page";
        }

    }

    /**
     * 重置密码
     * @param user
     * @return
     */
    @RequestMapping(value = "/resetPassword/{code}",method = RequestMethod.POST)
    public @ResponseBody ResponseInfo resetPassword(@RequestBody User user,@PathVariable String code){
        ResponseInfo responseInfo = new ResponseInfo();
        String timeAndCode = ExpireDataSore.forgetPasswordExpireData.get(user.getEmail());
        System.out.println(timeAndCode);
        String[] timeAndCodes = timeAndCode.split("_");
        if(timeAndCodes[1].equals(code)){
            userService.resetPassword(user);
            ExpireDataSore.forgetPasswordExpireData.remove(user.getEmail());
        }else {
            responseInfo.setCode(ResponseInfo.FAIL);
            responseInfo.setDesc("参数有误");
        }
        return responseInfo;
    }








}
