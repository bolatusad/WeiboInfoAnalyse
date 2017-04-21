package com.xupt.zxh.graduation.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 学生相关操作接口
 * Created by 张涛 on 2017/4/21.
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {


    /**
     * 跳转至相关页面
     * @param page
     * @return
     */
    @RequestMapping(value = "/toPage",method = RequestMethod.GET)
    public String toPage(String page){
        return page;
    }

}
