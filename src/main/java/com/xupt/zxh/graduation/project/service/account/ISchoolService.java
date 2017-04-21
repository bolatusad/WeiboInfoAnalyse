package com.xupt.zxh.graduation.project.service.account;

import com.xupt.zxh.graduation.project.bean.account.School;
import com.xupt.zxh.graduation.project.bean.account.User;
import com.xupt.zxh.graduation.project.bean.weibo.EmotionDTO;
import com.xupt.zxh.graduation.project.bean.weibo.EmotionVO;
import com.xupt.zxh.graduation.project.util.PageUtil;

import java.util.List;

/**
 * Created by 张涛 on 2017/4/19.
 */
public interface ISchoolService {

    /**
     * 通过用户ID获取对应的学校信息
     * @return
     */
    School getSchoolByUserId(Integer userId);

    /**
     * 更新学校信息
     * @param school
     */
    void updateSchool(School school);

    /**
     * 分页获取用户信息
     * @return
     */
    List<User> getUserByPage(PageUtil pageUtil);

    /**
     * 通过用户ID获取其微博情感分析
     * @param id
     * @return
     */
    List<EmotionVO> getEmotionVOByUserId(Integer id);

}
