package com.xupt.zxh.graduation.project.controller;

import com.xupt.zxh.graduation.project.bean.account.School;
import com.xupt.zxh.graduation.project.bean.account.User;
import com.xupt.zxh.graduation.project.bean.weibo.EmotionVO;
import com.xupt.zxh.graduation.project.bean.weibo.WeiboInfo;
import com.xupt.zxh.graduation.project.bean.weibo.WeiboSensitive;
import com.xupt.zxh.graduation.project.service.account.ISchoolService;
import com.xupt.zxh.graduation.project.service.account.IUserService;
import com.xupt.zxh.graduation.project.service.weibo.ISensitiveService;
import com.xupt.zxh.graduation.project.service.weibo.IWeiboInfoService;
import com.xupt.zxh.graduation.project.util.PageUtil;
import com.xupt.zxh.graduation.project.util.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 学校相关界面接口
 * Created by 张涛 on 2017/4/19.
 */
@Controller
@RequestMapping(value = "/school")
public class SchoolController {

    @Autowired
    private ISchoolService schoolService;

    @Autowired
    private IWeiboInfoService weiboInfoService;

    @Autowired
    private ISensitiveService sensitiveService;

    @Autowired
    private IUserService userService;

    @Autowired
    private HttpServletRequest request;

    /**
     * 跳转至学校基本信息界面
     */
    @RequestMapping(value = "/toSchoolInfoPage",method = RequestMethod.GET)
    public String toShoolInfoPage(){
        return "school/school_info";
    }

    /**
     * 获取学校的基本信息
     * @return
     */
    @RequestMapping(value = "/getSchoolInfo")
    public @ResponseBody ResponseInfo getSchoolInfo(){
        ResponseInfo responseInfo = new ResponseInfo();
        School school = schoolService.getCurrentSchool();
        responseInfo.setData(school);
        return responseInfo;
    }


    /**
     * 更新学校信息
     * @param school
     * @return
     */
    @RequestMapping(value = "/updateSchoolInfo",method = RequestMethod.POST)
    public @ResponseBody ResponseInfo updateSchoolInfo(@RequestBody School school){
        ResponseInfo responseInfo = new ResponseInfo();
        schoolService.updateSchool(school);
        responseInfo.setDesc("更新成功");
        return responseInfo;
    }

    /**
     * 获取主页的内容
     * @return
     */
    @RequestMapping(value = "/getIndexContent",method = RequestMethod.GET)
    public String getIndexContent(){
        return "index_v1";
    }

    /**
     * 获取学生列表
     * @return
     */
    @RequestMapping(value = "/getStudentList",method = RequestMethod.GET)
    public @ResponseBody ResponseInfo getStudent(){
        PageUtil pageUtil = new PageUtil();
        ResponseInfo responseInfo = new ResponseInfo();
        List<User> users = schoolService.getUserByPage(pageUtil);
        responseInfo.setData(users);
        return responseInfo;
    }

    /**
     * 跳转至学生列表界面
     * @return
     */
    @RequestMapping(value = "/toStudentListPage",method = RequestMethod.GET)
    public String toStudentListPage(){
        return "/school/student_list";
    }

    /**
     * 跳转至情感分析界面
     * @return
     */
    @RequestMapping(value = "/toStudentEmotionPage",method = RequestMethod.GET)
    public String toStudentEmotionPage(){
        return "student_emotion";
    }

    /**
     * 通过用户的ID获取其对应的微博情感分析
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getStudentEmotion/{userId}",method = RequestMethod.GET,produces = { "application/json;charset=UTF-8" })
    public @ResponseBody ResponseInfo getStudentEmotion(@PathVariable Integer userId){
        ResponseInfo responseInfo = new ResponseInfo();
        List<EmotionVO> emotionVOS = schoolService.getEmotionVOByUserId(userId);
        responseInfo.setData(emotionVOS);
        return responseInfo;
    }

    /**
     * 通过用户邮箱获取微博情感分析
     * @param email
     * @return
     */
    @RequestMapping(value = "/getStudentEmotionByEmail",method = RequestMethod.GET,produces = { "application/json;charset=UTF-8" })
    public @ResponseBody ResponseInfo getStudentEmotionByEmail(String email){
        ResponseInfo responseInfo = new ResponseInfo();
        User user = userService.getUserByEmail(email);
        List<EmotionVO> emotionVOS = null;
        if(user != null){
            emotionVOS = schoolService.getEmotionVOByUserId(user.getId());
        }else {
            responseInfo.setCode(ResponseInfo.FAIL);
        }
        responseInfo.setData(emotionVOS);
        return responseInfo;
    }

    /**
     * 跳转至修改密码界面
     * @return
     */
    @RequestMapping(value = "/toEditPasswordPage",method = RequestMethod.GET)
    public String toEditPasswordPage(){
        return "account/editPassword";
    }


    /**
     * 获取所有的敏感词分析结果
     * @return
     */
    @RequestMapping(value = "/getAllSensittive",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public @ResponseBody ResponseInfo getAllSensitive(){
        ResponseInfo responseInfo = new ResponseInfo();
        List<WeiboSensitive> weiboSensitives = sensitiveService.listAllSensitiveResult();
        responseInfo.setData(weiboSensitives);
        return  responseInfo;
    }


    /**
     * 跳转至指定页面
     * @param page
     * @return
     */
    @RequestMapping(value = "/toPage",method = RequestMethod.GET)
    public String toPage(String page){
        return page;
    }

    /**
     * 通过微博ID获取微博信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/getWeiboInfoById",method = RequestMethod.GET,produces = {"application/json;chartset=UTF-8"})
    public @ResponseBody ResponseInfo getWeiboInfoById(Integer id){
        ResponseInfo responseInfo = new ResponseInfo();
        WeiboInfo weiboInfo = weiboInfoService.getWeiboInfoById(id);
        responseInfo.setData(weiboInfo);
        return responseInfo;
    }

    /**
     * 通过学校ID获取学校信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/getSchoolById/{id}")
    public @ResponseBody ResponseInfo getSchoolById(@PathVariable Integer id){
        ResponseInfo responseInfo = new ResponseInfo();
        School school = schoolService.getSchoolById(id);
        responseInfo.setData(school);
        return responseInfo;
    }

    /**
     * 申请成为学校账户
     * @param school
     * @return
     */
    @RequestMapping(value = "/applySchoolAccount",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    public @ResponseBody ResponseInfo applySchoolAccount(@RequestBody School school){
        ResponseInfo responseInfo = new ResponseInfo();
        schoolService.applySchoolAccount(school,request);
        responseInfo.setDesc("已提交");
        return responseInfo;
    }

    /**
     * 审核通过
     */
    @RequestMapping(value = "/approve",method = RequestMethod.POST)
    public @ResponseBody String approve(School school){
        schoolService.insertSchool(school);
        return "审核通过："+school.getSchoolName();
    }

}
