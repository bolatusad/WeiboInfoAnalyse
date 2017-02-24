package com.xupt.zxh.graduation.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping(value="/testConfig")
	public String testConfig(){
		return "success";
	}

}
