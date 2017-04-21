package com.xupt.zxh.graduation.project.controller;

import com.xupt.zxh.graduation.project.bean.account.School;
import com.xupt.zxh.graduation.project.bean.account.User;
import com.xupt.zxh.graduation.project.bean.weibo.EmotionVO;
import com.xupt.zxh.graduation.project.service.account.ISchoolService;
import com.xupt.zxh.graduation.project.util.PageUtil;
import com.xupt.zxh.graduation.project.util.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        //暂时先模拟为1
        Integer id = 1;
        School school = schoolService.getSchoolByUserId(id);
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
        //暂定为1
        pageUtil.setUserId(1);
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

    @RequestMapping(value = "/toEditPasswordPage",method = RequestMethod.GET)
    public String toEditPasswordPage(){
        return "account/editPassword";
    }

}
