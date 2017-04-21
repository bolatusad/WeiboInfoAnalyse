package com.xupt.zxh.graduation.project.service.account.impl;

import com.xupt.zxh.graduation.project.bean.account.School;
import com.xupt.zxh.graduation.project.bean.account.User;
import com.xupt.zxh.graduation.project.bean.weibo.EmotionDTO;
import com.xupt.zxh.graduation.project.bean.weibo.EmotionVO;
import com.xupt.zxh.graduation.project.dao.account.SchoolDao;
import com.xupt.zxh.graduation.project.dao.account.UserDao;
import com.xupt.zxh.graduation.project.service.account.ISchoolService;
import com.xupt.zxh.graduation.project.service.account.IUserService;
import com.xupt.zxh.graduation.project.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张涛 on 2017/4/17.
 */
@Service
public class SchoolServiceImpl implements ISchoolService {

    @Autowired
    private SchoolDao schoolDao;

    @Override
    public School getSchoolByUserId(Integer userId) {
        School school = schoolDao.getScgoolByUserId(userId);
        return school;
    }

    @Override
    public void updateSchool(School school) {
        //暂且模拟用户ID为1
        school.setUserId(1);
        schoolDao.updateSchool(school);
    }

    @Override
    public List<User> getUserByPage(PageUtil pageUtil) {
        List<User> users = schoolDao.getUserByPage(pageUtil);
        return users;
    }

    @Override
    public List<EmotionVO> getEmotionVOByUserId(Integer id) {
        List<EmotionDTO> emotionDTOS = schoolDao.getEmotionDTOByUserId(id);
        List<EmotionVO> emotionVOS = new ArrayList<EmotionVO>();
        if(emotionDTOS == null || emotionDTOS.size()<=0){
            return emotionVOS;
        }
        for(EmotionDTO emotionDTO : emotionDTOS){
            EmotionVO emotionVO = new EmotionVO();
            emotionVO.setEmail(emotionDTO.getEmail());
            emotionVO.setNickName(emotionDTO.getNickname());
            List<Object> value = new ArrayList<Object>();
            value.add(emotionDTO.getDate());
            value.add(emotionDTO.getPositive());
            emotionVO.setValue(value);
            emotionVOS.add(emotionVO);
        }
        return emotionVOS;
    }


}
