package com.xupt.zxh.graduation.project.service;

import java.util.List;

import com.xupt.zxh.graduation.project.bean.TestUser;

/**
 * @Title:TestUserService
 * @Description:用于测试环境的service
 * @author: zxh
 * @Date：2017年2月25日上午10:22:05
 *
 */
public interface TestUserService {
	
	List<TestUser> listUser();

	void addTestUser(TestUser testUser);



}
