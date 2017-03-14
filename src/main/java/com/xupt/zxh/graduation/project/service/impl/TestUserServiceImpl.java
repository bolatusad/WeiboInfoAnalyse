package com.xupt.zxh.graduation.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xupt.zxh.graduation.project.bean.TestUser;
import com.xupt.zxh.graduation.project.dao.TestUserDao;
import com.xupt.zxh.graduation.project.service.TestUserService;

@Service
public class TestUserServiceImpl implements TestUserService {
	
	@Autowired
	private TestUserDao testUserDao;



	public List<TestUser> listUser() {
		List<TestUser> testUsers = testUserDao.listUser();
		return testUsers;
	}
}
