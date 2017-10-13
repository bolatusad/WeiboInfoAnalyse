package com.xupt.zxh.graduation.project.dao.account;

import com.xupt.zxh.graduation.project.bean.account.School;
import com.xupt.zxh.graduation.project.bean.account.User;
import com.xupt.zxh.graduation.project.bean.weibo.EmotionDTO;
import com.xupt.zxh.graduation.project.util.PageUtil;

import java.util.List;

/**
 * Created by admin on 2017/4/1.
 */
public interface SchoolDao {

    /**
     * 通过用户ID获取
     * @param id
     * @return
     */
    School getScgoolByUserId(Integer id);

    /**
     * 修改学校信息
     * @param school
     */
    void updateSchool(School school);

    /**
     * 分页获取用户信息
     * @param pageUtil
     * @return
     */
    List<User> getUserByPage(PageUtil pageUtil);

    /**
     * 通过用户ID获取其微博情感分析
     * @param id
     * @return
     */
    List<EmotionDTO> getEmotionDTOByUserId(Integer id);

    /**
     * 通过学校ID获取学校信息
     * @param id
     * @return
     */
    School getSchoolById(Integer id);

    /**
     * 插入学校信息
     * @param school
     */
    void insertSchool(School school);

}
