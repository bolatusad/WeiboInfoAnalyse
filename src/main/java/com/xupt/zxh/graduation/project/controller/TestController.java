package com.xupt.zxh.graduation.project.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.xupt.zxh.graduation.project.bean.TestUser;
import com.xupt.zxh.graduation.project.service.TestUserService;

/**
 * @Title:TestController
 * @Description:用于环境搭建的Controller
 * @author: zxh
 * @Date：2017年2月24日下午4:10:09
 *
 */
@Controller
@RequestMapping(value="/test")
public class TestController {
	
	Logger logger = Logger.getLogger(TestController.class);
	
	@Autowired
	private TestUserService testUserService;
	
	@RequestMapping(value="/testConfig")
	public ModelAndView testConfig(){
		ModelAndView mav = new ModelAndView();
		List<TestUser> testUsers = testUserService.listUser();
		mav.addObject("users",testUsers);
		mav.setViewName("success");
		logger.info("===========>"+JSON.toJSONString(testUsers));
		return mav;
	}

	@RequestMapping(value="/addUser")
	public @ResponseBody String addUser(@RequestBody TestUser testUser){
		try{
			testUserService.addTestUser(testUser);
		}catch (Exception e){
			return "fail";
		}
		return "success";
	}


}
