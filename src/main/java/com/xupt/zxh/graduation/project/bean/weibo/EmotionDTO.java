package com.xupt.zxh.graduation.project.bean.weibo;

import java.util.Date;

/**
 * 用于查询相应的数据
 * Created by 张涛 on 2017/4/19.
 */
public class EmotionDTO {

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 时间
     */
    private Date date;

    /**
     * 积极指数
     */
    private Double positive;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPositive() {
        return positive;
    }

    public void setPositive(Double positive) {
        this.positive = positive;
    }
}
