package com.xupt.zxh.graduation.project.controller;

import com.xupt.zxh.graduation.project.bean.weibo.WeiboUserInfo;
import com.xupt.zxh.graduation.project.service.account.IStudentService;
import com.xupt.zxh.graduation.project.util.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 学生相关操作接口
 * Created by 张涛 on 2017/4/21.
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    /**
     * 跳转至相关页面
     * @param page
     * @return
     */
    @RequestMapping(value = "/toPage",method = RequestMethod.GET)
    public String toPage(String page){
        return page;
    }


    /**
     * 用于验证用户的微博地址
     * @param weiboId
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/verifyWeiboId",method = RequestMethod.GET)
    public @ResponseBody Map verifyWeiboId(String weiboId) throws IOException {
        String nickname = studentService.verifyWeiboId(weiboId);
        Map<String,String> map = new HashMap<String,String>();
        map.put("nickname",nickname);
        return map;
    }

    /**
     * 绑定微博地址
     * @param weiboUserInfo
     * @return
     */
    @RequestMapping(value = "/bindWeibo",method = RequestMethod.POST,produces = { "application/json;charset=UTF-8" })
    public @ResponseBody ResponseInfo bindWeibo(@RequestBody WeiboUserInfo weiboUserInfo){
        ResponseInfo responseInfo = new ResponseInfo();
        studentService.bindWeibo(weiboUserInfo);
        return responseInfo;
    }


    /**
     * 获取用户的微博用户信息
     * @return
     */
    @RequestMapping(value = "/getWeiboUserInfo",method = RequestMethod.GET)
    public @ResponseBody ResponseInfo getWeiboUserInfo(){
        ResponseInfo responseInfo = new ResponseInfo();
        WeiboUserInfo weiboUserInfo = studentService.getWeiboUserInfo();
        responseInfo.setData(weiboUserInfo);
        return responseInfo;
    }

}
