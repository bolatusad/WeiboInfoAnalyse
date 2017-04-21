package com.xupt.zxh.graduation.project.bean.weibo;

import java.util.List;

/**
 * Created by 张涛 on 2017/4/19.
 */
public class EmotionVO {
    /**
     * 用户的邮箱
     */
    private String email;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 返回的数据，下标0：时间；下标1：积极指数
     */
    private List<Object> value;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<Object> getValue() {
        return value;
    }

    public void setValue(List<Object> value) {
        this.value = value;
    }
}
