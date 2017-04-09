package com.xupt.zxh.graduation.project.dao;

import java.util.List;

import com.xupt.zxh.graduation.project.bean.TestUser;


public interface TestUserDao {
	
	List<TestUser> listUser();


	void addTestUser(TestUser testUser);

}
