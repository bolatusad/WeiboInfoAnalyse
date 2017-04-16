package com.xupt.zxh.graduation.project.bean.weibo;

/**
 * Created by 张涛 on 2017/4/16.
 */
public class WeiboEmotion {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 微博ID
     */
    private Integer weiboId;

    /**
     * 积极指数
     */
    private Double positive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWeiboId() {
        return weiboId;
    }

    public void setWeiboId(Integer weiboId) {
        this.weiboId = weiboId;
    }

    public Double getPositive() {
        return positive;
    }

    public void setPositive(Double positive) {
        this.positive = positive;
    }
}
