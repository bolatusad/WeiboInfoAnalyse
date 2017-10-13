package com.xupt.zxh.graduation.project.service.account.impl;

import com.xupt.zxh.graduation.project.bean.account.School;
import com.xupt.zxh.graduation.project.bean.account.User;
import com.xupt.zxh.graduation.project.bean.weibo.EmotionDTO;
import com.xupt.zxh.graduation.project.bean.weibo.EmotionVO;
import com.xupt.zxh.graduation.project.dao.account.SchoolDao;
import com.xupt.zxh.graduation.project.service.account.ISchoolService;
import com.xupt.zxh.graduation.project.service.account.IUserService;
import com.xupt.zxh.graduation.project.util.ConstantsUtil;
import com.xupt.zxh.graduation.project.util.EmailUtil;
import com.xupt.zxh.graduation.project.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张涛 on 2017/4/17.
 */
@Service
public class SchoolServiceImpl implements ISchoolService {

    @Autowired
    private IUserService userService;

    @Autowired
    private SchoolDao schoolDao;

    @Override
    public School getCurrentSchool() {
        User user = userService.getCurrentUser();
        School school = schoolDao.getScgoolByUserId(user.getId());
        return school;
    }

    @Override
    public void updateSchool(School school) {
       User user = userService.getCurrentUser();
        schoolDao.updateSchool(school);
    }

    @Override
    public List<User> getUserByPage(PageUtil pageUtil) {
        User user = userService.getCurrentUser();
        pageUtil.setUserId(user.getId());
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

    @Override
    public School getSchoolById(Integer id) {
        School school = schoolDao.getSchoolById(id);
        return school;
    }

    @Override
    public void insertSchool(School school) {
        schoolDao.insertSchool(school);
    }

    @Override
    public void applySchoolAccount(School school, HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        User user = userService.getCurrentUser();
        String emailBody = "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "    <title> 申请成为学校账户</title>" +
                "</head>" +
                "<body>" +
                "<h3>学校账户申请</h3>" +
                "<div>" +
                "    <form action='"+url.substring(0,url.lastIndexOf('/'))+"/school/approve' method='post'>" +
                "        学校名称：<input type='text' id='schoolName' disabled value='"+school.getSchoolName()+"'/><br>" +
                "        学校编码：<input type='text' id='schoolNumber' disabled value='"+school.getSchoolNumber()+"'/><br>" +
                "        用户ID：<input type='text' id='userId' disabled value='"+user.getId()+"'/><br>" +
                "        用户邮箱：<input type='text' id='email' disabled value='"+user.getEmail()+"'/><br>" +
                "        <input type='submit' id='success' value='审核通过'/>" +
                "        <a href=''> <input type='button' id='fail' value='不通过'/></a>" +
                "    </form>" +
                "</div>" +
                "</body>" +
                "</html>";
        String adminEamil = ConstantsUtil.getValue("admin_email");
        EmailUtil.sendEmail(emailBody,adminEamil);
    }
}
